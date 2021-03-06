---
title: java XML 处理
date: 2015/8/10
categories:
- java基础
tags:
- java XML处理
---

### XPDL（XML Process Definition Language）
是由Workflow Management Coalition所提出的一个标准化规格，  
使用XML文件让不同的工作流程软件能够交换商业流程定义。  

### 使用dom4j解析xml文件
```java
package com.mendian.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * xml 工具类
 * 
 * @ClassName: XmlUtil
 * @author jh
 * @date 2016-7-8 上午11:56:44
 * 
 */
public class XmlUtil {

	/**
	 * 通过文件名创建documnet
	 * 
	 * @Author: jianghan
	 * @param fileName
	 * @return
	 * 
	 */
	public static Document createDocument(String fileName) {
		if (StringUtil.isEmpty(fileName)) {
			return null;
		}
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(fileName);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return doc;
	}

	/**
	 * 通过request创建document
	 * 
	 * @Author: jianghan
	 * @param request
	 * @return
	 * 
	 */
	public static Document createDocument(HttpServletRequest request) {
		Document doc = null;
		try {
			InputStream inputStream = request.getInputStream();
			SAXReader reader = new SAXReader();

			doc = reader.read(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return doc;
	}

	/**
	 * 通过文件名创建根节点
	 * 
	 * @Author: jianghan
	 * @param fileName
	 * @return
	 * 
	 */
	public static Element createRootElement(String fileName) {
		return createDocument(fileName).getRootElement();
	}

	/**
	 * 通过request创建根节点
	 * 
	 * @Author: jianghan
	 * @param request
	 * @return
	 * 
	 */
	public static Element createRootElement(HttpServletRequest request) {
		return createDocument(request).getRootElement();
	}

	/**
	 * 获取当前节点的名字,内容等属性
	 * 
	 * @Author: jianghan
	 * @param node
	 * @return
	 * 
	 */
	public static Map<String, String> getElement(Element node) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", node.getName());
		map.put("value", node.getText());
		return map;
	}

	/**
	 * 获取当前节点的所有子节点
	 * 
	 * @Author: jianghan
	 * @return
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static List<Element> getChildElement(Element node) {
		List<Element> elements = new ArrayList<Element>();
		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			elements.add(e);
		}
		return elements;
	}

	public static List<Map<String, Object>> getAttributes(Element node) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int i = 0;
		for (Iterator<?> it = node.attributeIterator(); it.hasNext();) {
			Attribute attribute = (Attribute) it.next();
			list.get(i).put(attribute.getName(), attribute.getText());
			i++;
		}
		return list;
	}

}
```
