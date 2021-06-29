package org.mimicspring.ioc.factory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
    /**
     * key: fullClassName
     */
    public Map<String, List<Object>> beanMap = new ConcurrentHashMap<>();

    public <T> T getBean(String fullClassName) {
        return null;
    }

    public <T> T getBean(String name, Class<T> clazz) {
        return null;
    }
}
