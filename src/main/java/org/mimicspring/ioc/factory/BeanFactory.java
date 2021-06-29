package org.mimicspring.ioc.factory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {

    <T> T getBean(String name, Class<T> clazz);

    <T> T getBean(Class<T> clazz);

    Object getBean(String name);

    boolean containsBean(String name);

    boolean isSingleton(String name);

    boolean isPrototype(String name);
}
