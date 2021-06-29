package org.mimicspring;


import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import org.atool.tool.Asserts;

public class Test {
    public static void main(String[] args) {
//        String[] splitPaths = Test.class.getPackage().getName().split("\\.");
//        String basePackage = splitPaths[0] + "." + splitPaths[1];
//        ClassUtil.scanPackage(basePackage, (clazz -> {
//            System.out.println(clazz.getName());
//            return true;
//        }));
        System.out.println(ClassUtil.getPackage(Test.class));
    }
}
