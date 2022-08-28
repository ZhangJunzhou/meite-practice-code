package com.zjz.annotation0007.test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @ClassName Main
 * @Author Junzhou Zhang
 * @Create 2022/8/28 20:19
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.zjz.annotation0007.test.UserEntity");

//        // 获取该类的所有注解
//        Annotation[] annotations = aClass.getAnnotations();
//        for(Annotation annotation : annotations){
//            System.out.println(annotation);
//        }

        // 获取该类的某个注解
        SetTable setTable = aClass.getDeclaredAnnotation(SetTable.class);
        String fromTable = setTable.value();

        StringBuffer sb = new StringBuffer();
        sb.append("select ");
        Field[] declaredFields = aClass.getDeclaredFields();
        // 遍历每个变量
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            // 属性字段
            SetProperty setProperty = field.getAnnotation(SetProperty.class);
            sb.append(setProperty.name() + " ");
            if (i == declaredFields.length - 1) {
                sb.append("from");
            } else {
                sb.append(", ");
            }
        }
        sb.append(" " + fromTable);
        System.out.println(sb.toString());
    }
}
