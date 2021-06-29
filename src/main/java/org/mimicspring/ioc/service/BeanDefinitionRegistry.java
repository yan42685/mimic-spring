package org.mimicspring.ioc.service;

import lombok.extern.slf4j.Slf4j;
import org.mimicspring.ioc.model.BeanDefinition;
import org.mimicspring.utils.ClassUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class BeanDefinitionRegistry {
    /**
     * 每个bean名称对应的 BeanDefinition, 用于根据 name 注入
     */
    private final Map<String, BeanDefinition> nameDefinitionMap = new ConcurrentHashMap<>();
    /**
     * 每个 class 或 interface对应的 BeanDefinition list，用于根据类型注入
     * NOTE: Spring的实现里用的ConcurrentHashMap, 所以这里先这么写着，暂时不理解为什么会有并发读写的场景。
     */
    private final Map<Class<?>, List<BeanDefinition>> typeDefinitionMap = new ConcurrentHashMap<>();

    public BeanDefinition getDefinitionByName(String name) {
        return nameDefinitionMap.get(name);
    }

    public boolean containsDefinition(String name) {
        return nameDefinitionMap.containsKey(name);
    }

    public List<BeanDefinition> getDefinitionsByType(Class<?> type) {
        return typeDefinitionMap.get(type);
    }

    public void register(Iterable<BeanDefinition> definitions) {
        definitions.forEach(definition -> {
            // 注册到 nameDefinitionMap
            String name = definition.getName();
            BeanDefinition existingDefinition = nameDefinitionMap.get(name);
            // 命名重复会导致冲突 (BeanDefinition中默认的name是类的simpleName)
            if (existingDefinition != null) {
                log.error("bean name {} for bean class [{}] conflicts with existing bean class [{}]",
                        name, definition.getBeanClass().getName(), existingDefinition.getBeanClass().getName());
                throw new RuntimeException();
            }
            nameDefinitionMap.put(name, definition);

            // 将bean的类型及其所有父类和接口注册到 typeDefinitionMap
            List<Class<?>> typeList = getTypeList(definition);
            typeList.forEach(type -> {
                List<BeanDefinition> definitionList = typeDefinitionMap.get(type);
                if (definitionList == null) {
                    definitionList = new CopyOnWriteArrayList<>();
                }
                definitionList.add(definition);
                typeDefinitionMap.put(type, definitionList);
            });
        });
    }


    /**
     * 获取BeanDefinition的 class对象及其所有的父类和接口
     */
    @SuppressWarnings("unchecked")
    private List<Class<?>> getTypeList(BeanDefinition beanDefinition) {
        Class<?> currentClass = beanDefinition.getBeanClass();
        List<Class<?>> classes = (List<Class<?>>) ClassUtils.getAllSuperClassAndInterface(currentClass);
        classes.add(currentClass);
        return classes;
    }

}
