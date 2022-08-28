package com.zjz.dataTransfer0005;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName XmlTest
 * @Author Junzhou Zhang
 * @Create 2022/8/28 15:29
 */
public class XmlTest {

    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("D:\\meitejiaoyu\\code\\first-phase\\src\\main\\resources\\stu.xml"));
        // 获取根节点
        Element rootElement = read.getRootElement();
        getNodes(rootElement);

    }

    static public void getNodes(Element rootElement) {
        System.out.println("当前节点名称:" + rootElement.getName());
        // 获取属性ID
        List<Attribute> attributes = rootElement.attributes();
        for (Attribute attribute : attributes) {
            System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
        }
        if (!rootElement.getTextTrim().equals("")) {
            System.out.println(rootElement.getName() + "--" + rootElement.getText());
        }
        // 使用迭代器遍历
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element next = elementIterator.next();
            getNodes(next);
        }

    }

}
