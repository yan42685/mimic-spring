package org.mimicspring.ioc.core;

import lombok.Setter;
import org.mimicspring.ioc.factory.BeanFactory;

public class ApplicationContext extends BeanFactory {
    @Setter
    private String basePackage;
}
