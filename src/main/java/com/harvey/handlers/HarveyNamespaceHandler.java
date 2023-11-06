package com.harvey.handlers;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : MyNamespace
 * @date : 2023/11/05 21:09
 **/
public class HarveyNamespaceHandler extends NamespaceHandlerSupport {
    /**
     * 初始化
     * 一般情况下,一个命名空间会有多个标签
     * 会在init方法中为每一个标签注册一个标签解析器
     * */
    @Override
    public void init() {
        // 我们的标签: <xsd:element name="annotation-driven"/>
        // 怎么注册?这么注册:
        this.registerBeanDefinitionParser(
                "annotation-driven",
                new HarveyBeanDefinitionParser());
    }
}

/**
 * 需求:注入一个BeanPostProcessor
 * */
class HarveyBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("com.harvey.processor.HarveyBeanPostProcessor");
        parserContext.getRegistry().registerBeanDefinition("harveyBeanPostProcessor",beanDefinition);
        return beanDefinition;
    }
}

