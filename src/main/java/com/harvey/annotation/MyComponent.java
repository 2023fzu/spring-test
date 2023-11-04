package com.harvey.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 需求:
 * 每次在写完一个类之后,都要去.xml文件里配置
 * 这种配置常常很没有技术含量,是个重复工作
 * 配置需要在两个界面来回切换,效率低下,让人心烦气躁
 * 全类名的复制很麻烦
 *
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : RegisterMyBean
 * @date : 2023/11/02 21:00
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyComponent {
    String value() default "";
}

