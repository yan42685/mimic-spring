package org.mimicspring.ioc.annotation;

import java.lang.annotation.*;

//@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
// 暂时只完成基础功能: 字段注入和构造器注入
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
    boolean required() default true;
}
