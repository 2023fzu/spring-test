package com.harvey.utils;

import com.harvey.annotation.MyComponent;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 要求:注解了之后的类,依据给的beanName(id),就会自动帮我们配置完毕
 * 实现:Bean工厂的内处理器,扫描每一个,凡有该注解的,实现要求,要在创建对象之前.扫描Map之后
 *
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : BaseClassScanUtils
 * @date : 2023/11/03 21:30
 **/
public class BaseClassScanUtils {

    // 创建容器存储使用了指定注解的Bean字节码对象
    private static final String RESOURCE_PATTERN = "/**/*.class";

    /**
     * @param basePackage 包名,其下的文件皆会被扫描
     * @return Map<String, Class> 容器存储使用了指定注解的Bean自解码对象
     */
    public static Map<String, Class> scanMyComponentAnnotation(String basePackage) throws IOException, ClassNotFoundException {
        Map<String, Class> annotationClassMap = new HashMap<>();
        //Spring工具类,可以获取指定路径下的全部类
        ResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();

        String pattern =
                ResourcePatternResolver.CLASSPATH_URL_PREFIX +
                        ClassUtils.convertClassNameToResourcePath(basePackage) +
                        RESOURCE_PATTERN;
        Resource[] resources = pathResolver.getResources(pattern);
        // MetadataReader 的工厂类
        MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory();
        for (Resource resource : resources) {
            // 用于读取类信息
            MetadataReader reader = readerFactory.getMetadataReader(resource);
            // 扫描到的class
            String className = reader.getClassMetadata().getClassName();
            Class clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(MyComponent.class)) {
                // 获取注解是MyComponent的注解
                //这个强转不知道用的对不对
                MyComponent annotation = (MyComponent) clazz.getAnnotation(MyComponent.class);
                String beanName = annotation.value();
                if (beanName != null && !beanName.isEmpty()) {
                    // 如果有指定beanName
                    annotationClassMap.put(beanName, clazz);
                    continue;
                }
                //如果没有或为"".那就吧当前类的类的类名作为beanName

                // 顺便搞成了首字母小写
                String classSimpleName = clazz.getSimpleName();
                beanName = classSimpleName.substring(0, 1).toLowerCase() +
                        classSimpleName.substring(1);
                annotationClassMap.put(beanName, clazz);
            }
        }

        return annotationClassMap;
    }

    //这样只要吧MyComponent2配置进去就OK啦

}
