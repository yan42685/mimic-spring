package org.mimicspring.ioc.loader;

import cn.hutool.core.util.ClassUtil;
import org.mimicspring.ioc.definition.BeanDefinition;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BeanDefinitionLoader {

    public List<BeanDefinition> load(String basePackage) {
        List<BeanDefinition> definitions = new LinkedList<>();
        definitions.addAll(loadFromPackage(basePackage));
        definitions.addAll(loadFromClassPath());
        return definitions;
    }

    private List<BeanDefinition> loadFromPackage(String basePackage) {
        return Collections.emptyList();
    }

    private List<BeanDefinition> loadFromClassPath() {
        return Collections.emptyList();
    }
}
