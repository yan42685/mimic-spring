package org.mimicspring.ioc.model.enums;

/**
 * 根据 BeanDefinition 的各种来源，决定新建对象的方式
 */
public enum BeanDefinitionSource {
    /**
     * Component注解
     */
    COMPONENT_ANNOTATION,
    /**
     * Bean注解
     */
    BEAN_ANNOTATION,
    /**
     * xml、json等配置文件
     */
    RESOURCE
}
