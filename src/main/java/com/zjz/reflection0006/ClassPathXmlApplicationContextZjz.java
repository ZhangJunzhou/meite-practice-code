package com.zjz.reflection0006;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @ClassName ClassPathXmlApplicationContextZjz
 * @Author Junzhou Zhang
 * @Create 2022/8/28 16:31
 */
public class ClassPathXmlApplicationContextZjz {

    private String xmlPath;

    public ClassPathXmlApplicationContextZjz(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Object getBeans(String beanId) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        // 读取xml配置文件
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(this.getClass().getClassLoader().getResourceAsStream(this.xmlPath));
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();

        Object object = null;
        for(Element element : elements){
            //获取class地址
            String beanIdInter = element.attributeValue("id");
            if(!beanIdInter.equals(beanId)){
                continue;
            }

            // 获取每个bean配置，获取class地址
            String beanClassPath = element.attributeValue("class");
            Class<?> aClass = Class.forName(beanClassPath);

            // 拿到class地址，实例化对象；
            object = aClass.newInstance();

            List<Element> elements1 = element.elements();
            for(Element eee : elements1){
                String name = eee.attributeValue("name");
                String value = eee.attributeValue("value");
                // 反射Api为私有属性赋值
                Field field = aClass.getDeclaredField(name);
                field.setAccessible(true);
                field.set(object, value);
            }
        }
        return object;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, DocumentException, IllegalAccessException {
        ClassPathXmlApplicationContextZjz classPathXmlApplicationContextZjz = new ClassPathXmlApplicationContextZjz("user.xml");
        UserEntity userEntity = (UserEntity) classPathXmlApplicationContextZjz.getBeans("user1");
        System.out.println(userEntity.getUserId());
        System.out.println(userEntity.getUserName());
    }
}
