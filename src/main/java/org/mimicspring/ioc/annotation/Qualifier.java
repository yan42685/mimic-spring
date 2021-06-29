package org.mimicspring.ioc.annotation;

import java.lang.annotation.*;

//@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,  ElementType.ANNOTATION_TYPE})
// 暂时只完成基础功能: 字段注入和构造器注入
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,  ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
// 对子类产生影响
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
