package org.mimicspring.ioc.model;

import java.util.List;

public class AnnotationBeanDefinition extends BeanDefinition {
    private String methodName;

    private Class[] methodParamTypes;

    private List<String> methodParamRefs;
}
