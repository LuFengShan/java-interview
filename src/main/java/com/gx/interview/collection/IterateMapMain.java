package com.gx.interview.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 如何在java中迭代hashmap
 *
 * 1. 使用keyset（）和每个循环（Java 5）
 * 2. 使用keyset（）和java Iterator
 * 3. 使用EntrySet（）和每个循环（Java 5） （推荐使用）
 * 4. 使用EntrySet（）和java Iterator
 *
 * 推荐使用3，因为只迭代了一次，1、2分别迭代了两次，浪费时间性能等
 */
public class IterateMapMain {

    public static void main(String args[]) {
        HashMap<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("美国", "纽约");
        countryCapitalMap.put("中国", "北京");
        countryCapitalMap.put("日本", "东京");
        countryCapitalMap.put("韩国", "首尔");

        // 使用keyset（）和每个循环（Java 5）
        System.out.println("使用keyset（）和每个循环（Java 5）");
        for (String countryKey : countryCapitalMap.keySet()) {
            System.out.println("Country:" + countryKey + " and  Capital:" + countryCapitalMap.get(countryKey));

        }
        System.out.println("-----------------------------");

        // 使用keyset（）和java Iterator
        System.out.println("使用keyset（）和java Iterator");
        Iterator countryKeySetIterator = countryCapitalMap.keySet().iterator();
        while (countryKeySetIterator.hasNext()) {
            String countryKey = (String) countryKeySetIterator.next();
            System.out.println("Country:" + countryKey + " and Capital:" + countryCapitalMap.get(countryKey));

        }
        System.out.println("-----------------------------");

        // 使用EntrySet（）和每个循环（Java 5）
        System.out.println("使用EntrySet（）和每个循环（Java 5）【推荐使用】");
        for (Map.Entry<String, String> entry : countryCapitalMap.entrySet()) {
            System.out.println("Country:" + entry.getKey() + " and  Capital:" + entry.getValue());

        }
        System.out.println("-----------------------------");

        // 使用EntrySet（）和java Iterator
        System.out.println("使用EntrySet（）和java Iterator");
        Iterator<Map.Entry<String, String>> entryIterator = countryCapitalMap.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            System.out.println("Country:" + entry.getKey() + " and  Capital:" + entry.getValue());

        }
        System.out.println("-----------------------------");

    }

}
