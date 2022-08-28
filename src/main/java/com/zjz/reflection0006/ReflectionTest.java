package com.zjz.reflection0006;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionTest
 * @Author Junzhou Zhang
 * @Create 2022/8/28 15:56
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class<?> aClass = Class.forName("com.zjz.reflection0006.UserEntity");
        Object o = aClass.newInstance();
        UserEntity userEntity = (UserEntity) o;

        // 配置私有成员的变量
        Field userName = aClass.getDeclaredField("userName");
        userName.setAccessible(true);
        userName.set(userEntity, "zjz");

        Field userId = aClass.getDeclaredField("userId");
        userId.setAccessible(true);
        userId.set(userEntity, 26);
        System.out.println(userEntity);


        Method[] declaredMethod = aClass.getDeclaredMethods();
        for(Method method : declaredMethod){
            System.out.println(method);
        }


    }

}
