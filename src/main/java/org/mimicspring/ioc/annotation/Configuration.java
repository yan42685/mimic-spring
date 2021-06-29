package org.mimicspring.ioc.annotation;

import java.lang.annotation.*;


@Component
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Configuration {
    String value() default "";
}
