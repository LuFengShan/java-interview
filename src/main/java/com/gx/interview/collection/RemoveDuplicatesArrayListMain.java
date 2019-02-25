package com.gx.interview.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 从arraylist中删除重复项
 * 1. 使用迭代方法
 * 2. 使用HashSet（但不维护插入顺序）
 * 3. 使用LinkedHashMap
 */
public class RemoveDuplicatesArrayListMain {
    public static void main(String[] args) {
        List<String> employeeNameList = new ArrayList();
        employeeNameList.add("张三");
        employeeNameList.add("李四");
        employeeNameList.add("王五");
        employeeNameList.add("张三");
        employeeNameList.add("李白");
        employeeNameList.add("二狗");

        System.out.println("从列表中删除重复项");
        // 使用普通方式：在创建一个新的集合对象，判断旧的集合中的元素，
        // 在新的集合中是否存在，存在则不添加到时新的集合中，不存在则增加，这样就保证了添加的顺序
        ArrayList<String> uniqueElements = new ArrayList();
        for (String empName : employeeNameList) {
            if (!uniqueElements.contains(empName)) {
                uniqueElements.add(empName);
            }
        }

        System.out.println("1. 使用迭代方法，可以保证顺序");
        for (String uniqElem : uniqueElements) {
            System.out.println(uniqElem);
        }

        System.out.println("*******************************");
        System.out.println("2. 使用HashSet（但不维护插入顺序）");
        // using HashSet but does not maintain order
        uniqueElements = new ArrayList(new HashSet(
                employeeNameList));
        for (String uniqElem : uniqueElements) {
            System.out.println(uniqElem);
        }

        System.out.println("*******************************");
        System.out.println("3. 使用LinkedHashMap，可以保证顺序");
        uniqueElements = new ArrayList(new LinkedHashSet(
                employeeNameList));
        for (String uniqElem : uniqueElements) {
            System.out.println(uniqElem);
        }

    }
}
