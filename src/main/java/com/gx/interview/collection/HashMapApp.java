package com.gx.interview.collection;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapApp {
    public static void main(String[] args) {

        Country india = new Country("India", 1000);
        Country japan = new Country("Japan", 10000);

        Country france = new Country("France", 2000);
        Country russia = new Country("Russia", 20000);

        HashMap<Country, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put(india, "Delhi");
        countryCapitalMap.put(japan, "Tokyo");
        countryCapitalMap.put(france, "Paris");
        countryCapitalMap.put(russia, "Moscow");

        Iterator countryCapitalIter = countryCapitalMap.keySet().iterator();//在这一行打上断点
        while (countryCapitalIter.hasNext()) {
            Country countryObj = (Country) countryCapitalIter.next();
            String capital = countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName() + "----" + capital);
        }
    }
}
