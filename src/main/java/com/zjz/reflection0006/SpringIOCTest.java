package com.zjz.reflection0006;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName SpringIOCTest
 * @Author Junzhou Zhang
 * @Create 2022/8/28 16:14
 */
public class SpringIOCTest {
    public static void main(String[] args) {
        //1.读取springxml配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "user.xml");
        //2.获取bean对象
        UserEntity userEntity = (UserEntity) classPathXmlApplicationContext.getBean("user1");
        System.out.println(userEntity.getUserId());
        System.out.println(userEntity.getUserName());

    }
}
