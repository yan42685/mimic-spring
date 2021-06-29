package org.mimicspring.ioc.annotation;

import org.mimicspring.ioc.annotation.enums.ScopeEnum;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    ScopeEnum value() default ScopeEnum.SINGLETON;
}
