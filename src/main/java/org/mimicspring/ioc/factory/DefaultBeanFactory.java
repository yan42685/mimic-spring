package org.mimicspring.ioc.factory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory implements BeanFactory{
    /**
     * key: fullClassName
     */
    public Map<String, List<Object>> beanMap = new ConcurrentHashMap<>();

    @Override
    public <T> T getBean(String name, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return null;
    }

    @Override
    public Object getBean(String name) {
        return null;
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    @Override
    public boolean isSingleton(String name) {
        return false;
    }

    @Override
    public boolean isPrototype(String name) {
        return false;
    }
}

