package org.mimicspring.ioc.core;

import lombok.Setter;
import org.mimicspring.ioc.factory.DefaultBeanFactory;

public class ApplicationContext extends DefaultBeanFactory {
    @Setter
    private String basePackage;
}
