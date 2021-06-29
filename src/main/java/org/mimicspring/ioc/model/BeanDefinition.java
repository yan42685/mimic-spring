package org.mimicspring.ioc.model;

import lombok.Data;
import org.mimicspring.ioc.annotation.enums.ScopeEnum;
import org.mimicspring.ioc.model.enums.BeanDefinitionSource;

@Data
public class BeanDefinition {
    private String name;
    // 类的全限定名
    private String fullClassName;
    private ScopeEnum scope;
    private boolean isLazyInit;
    private BeanDefinitionSource definitionSource;
}
