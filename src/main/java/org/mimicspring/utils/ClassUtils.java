package org.mimicspring.utils;

import cn.hutool.core.util.ArrayUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ClassUtils {
    /**
     * 根据class新建对象
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取当前的 class loader
     */
    public static ClassLoader currentClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 获取类信息
     */
    public static Optional<Class<?>> getClass(String className) {
        try {
            return Optional.ofNullable(currentClassLoader().loadClass(className));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取所有父类信息
     */
    public static <T> List<Class<? super T>> getAllSuperClass(Class<T> clazz) {
        List<Class<? super T>> result = new LinkedList<>();
        if (clazz == null) {
            return result;
        }
        Class<? super T> tempClass = clazz.getSuperclass();
        while (tempClass != null) {
            result.add(tempClass);
            tempClass = tempClass.getSuperclass();
        }

        return result;
    }

    /**
     * 获取所有接口信息
     */
    @SuppressWarnings("unchecked")
    public static <T> List<Class<? super T>> getAllInterfaces(Class<T> clazz) {
        List<Class<? super T>> result = new LinkedList<>();
        if (clazz == null) {
            return result;
        }
        Class[] interfaces = clazz.getInterfaces();
        if (ArrayUtil.isNotEmpty(interfaces)) {
            // 强制类型转换 Class -> Class<? super T>
            for (Class<? super T> interfaceClass : interfaces) {
                result.add(interfaceClass);
                // 递归添加当前接口继承的所有接口
                result.addAll(getAllInterfaces(interfaceClass));
            }
        }

        return result;
    }

    /**
     * 获取所有父类信息和接口信息
     */
    public static <T> List<Class<? super T>> getAllSuperClassAndInterface(Class<? super T> clazz) {
        List<Class<? super T>> result = new LinkedList<>();
        if (clazz == null) {
            return result;
        }
        result.addAll(getAllInterfaces(clazz));
        result.addAll(getAllSuperClass(clazz));

        return result;
    }
}
