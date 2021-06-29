package org.mimicspring.ioc.core;

import cn.hutool.core.util.ClassUtil;

public class MimicSpringApplication {
    private static ApplicationContext ctx;
    /**
     * IOC 容器启动入口
     */
    public static void run(Class<?> bootClass) {
        initApplicationContext(bootClass);
    }

    private static void initApplicationContext(Class<?> bootClass) {
        ctx = new ApplicationContext();
        // 获取传入类型所在的package
        String basePackage = ClassUtil.getPackage(bootClass);
        ctx.setBasePackage(basePackage);
    }


}
