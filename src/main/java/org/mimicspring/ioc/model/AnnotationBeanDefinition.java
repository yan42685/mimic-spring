package org.mimicspring.ioc.model;

import lombok.Data;

import java.util.List;

@Data
public class AnnotationBeanDefinition extends BeanDefinition {
    private String methodName;

    private List<Class<?>> methodParamTypes;

    private List<String> methodParamRefs;
}
