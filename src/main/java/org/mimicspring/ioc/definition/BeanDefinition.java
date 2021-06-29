package org.mimicspring.ioc.definition;

import lombok.Data;
import org.mimicspring.ioc.annotation.enums.ScopeEnum;

@Data
public class BeanDefinition {
    private String name;
    // 类的全限定名
    private String fullClassName;
    private ScopeEnum scope = ScopeEnum.SINGLETON;
    private boolean isLazyInit = true;
}
