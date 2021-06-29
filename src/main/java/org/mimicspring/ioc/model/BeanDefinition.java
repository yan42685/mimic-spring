package org.mimicspring.ioc.model;

import lombok.Data;
import org.mimicspring.ioc.annotation.enums.ScopeEnum;
import org.mimicspring.ioc.model.enums.BeanDefinitionSource;

@Data
public class BeanDefinition {
    private String name;
    /**
     * bean类的全限定名
     */
    private String fullClassName;
    /**
     * bean的类型
     */
    private Class<?> beanClass;
    private ScopeEnum scope;
    private boolean isLazyInit;
    private BeanDefinitionSource definitionSource;
}
