package org.mimicspring.ioc.core;

import cn.hutool.core.util.ClassUtil;

public class MimicSpringApplication {
    private static ApplicationContext context;
    /**
     * IOC 容器启动入口
     */
    public static void run(Class<?> bootClass) {
        initApplicationContext(bootClass);
    }

    private static void initApplicationContext(Class<?> bootClass) {
        context = new ApplicationContext();
        // 获取传入类型所在的package
        String basePackage = ClassUtil.getPackage(bootClass);
        context.setBasePackage(basePackage);
    }


}
