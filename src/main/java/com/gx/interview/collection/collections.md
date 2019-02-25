[

# 1. 集合

## 1.1 如何在java中迭代hashmap

1. 使用keyset（）和每个循环（Java 5）
2. 使用keyset（）和java Iterator
3. 使用EntrySet（）和每个循环（Java 5）**推荐使用**
4. 使用EntrySet（）和java Iterator

```java
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
        System.out.println("使用EntrySet（）和每个循环（Java 5）");
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

```

##  1.2 Java中使用Comparator基于属性对ArrayList进行排序

> 1. 如果要对类的对象列表进行排序，可以使用Comparator接口。您不需要在需要对其对象进行排序的类上实现Comparator。您可以创建一个单独的类并实现Comparator接口
>
> 2. **使用匿名比较器【推荐使用，因为我们这里没有创建比较器特定类】**

### 方法1：如果要对类的对象列表进行排序，可以使用Comparator接口。您不需要在需要对其对象进行排序的类上实现Comparator。您可以创建一个单独的类并实现Comparator接口

**员工类**

```java
public class Employee {
	private int empId;
	private String name;
	private int age;
	public Employee(int empId, String name, int age) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
 
```

**创建一个类。该类将具有通过empId对Employees列表进行排序的逻辑。**

```java
public class EmployeeSortByIdComparator implements Comparator{
 
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getEmpId()-e2.getEmpId();
	}
}
```

**测试类**

```java
public class EmployeeComparatorMain {
 
	public static void main(String[] args) {
		Employee e1= new Employee(4, "John", 20);
		Employee e2= new Employee(3, "Martin", 40);
		Employee e3= new Employee(1, "Mary", 28);
		Employee e4= new Employee(2, "Andrew", 35);
		
		List<Employee> listofEmployees=new ArrayList<>>();
		listofEmployees.add(e1);
		listofEmployees.add(e2);
		listofEmployees.add(e3);
		listofEmployees.add(e4);
		
		System.out.println("Before Sorting by empId: ");
		for (Employee e:listofEmployees) {
			System.out.println("Employee Id: "+e.getEmpId()+"|| name: "+e.getName());
		}
		
		Collections.sort(listofEmployees,new EmployeeSortByIdComparator());
		System.out.println("After Sorting by empId: ");
		for (Employee e:listofEmployees) {
			System.out.println("Employee Id: "+e.getEmpId()+"|| name: "+e.getName());
		}
	}
}
```

### 方法2：匿名比较者

主要是通过下面的一个方法

```java
Collections.sort(listofEmployees,new Comparator<Employee>() {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
});
```

示例

```java
public class EmployeeComparatorMain {
 
	public static void main(String[] args) {
		Employee e1= new Employee(4, "John", 20);
		Employee e2= new Employee(3, "Martin", 40);
		Employee e3= new Employee(1, "Mary", 28);
		Employee e4= new Employee(2, "Andrew", 35);
		
		List<Employee> listofEmployees=new ArrayList<>>();
		listofEmployees.add(e1);
		listofEmployees.add(e2);
		listofEmployees.add(e3);
		listofEmployees.add(e4);
		
		System.out.println("Before Sorting by name: ");
		for (Employee e:listofEmployees) {
			System.out.println("Employee Id: "+e.getEmpId()+"|| name: "+e.getName());
		}
		
		Collections.sort(listofEmployees,new Comparator<Employee>() {
 
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("After Sorting by name: ");
		for (Employee e:listofEmployees) {
			System.out.println("Employee Id: "+e.getEmpId()+"|| name: "+e.getName());
		}
	}
}
 
```

## 1.3 java中使用Comparable基于属性对Arraylist进行排序

要对其对象进行排序的类，必须实现Comparable接口。在些我们必须实现compareTo(Object)方法。

示例

```java
public class Country implements Comparable{
       @Override
    public int compareTo(Country country) {
        return (this.countryId < country.countryId ) ? -1: (this.countryId > country.countryId ) ? 1:0 ;
    }
}
```

如果任何类实现了Comparable接口，则可以使用Collection.sort()或着Arrays.sort()自动对该对象的集合进行排序。排序的依据就是该类实现的compareTo方法。

在java中实现Comparable的对象可以用作TreeMap等SortedMap中的键，也可以像TreeSet一样使用SortedSet，而不需要实现任何其他接口

排序逻辑必须位于其对象正在排序的同一个类中。因此，这被称为对象的自然排序

下面是示例

**1.Contry.java**

```java
//If this.cuntryId < country.countryId:then compare method will return -1
//If this.countryId > country.countryId:then compare method will return 1
//If this.countryId==country.countryId:then compare method will return 0
public class Country implements Comparable{
    int countryId;
    String countryName;
   
   
    public Country(int countryId, String countryName) {
        super();
        this.countryId = countryId;
        this.countryName = countryName;
    }
 
    @Override
    public int compareTo(Country country) {
       return (this.countryId < country.countryId ) ? -1: (this.countryId > country.countryId ) ? 1:0 ;
    }
 
 
    public int getCountryId() {
        return countryId;
    }
 
 
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
 
 
    public String getCountryName() {
        return countryName;
    }
 
 
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
   
}
```

**2.ComparableMain.java**

```java
public class ComparableMain {
 
	/**
	 * @author Arpit Mandliya
	 */
	public static void main(String[] args) {
		Country indiaCountry=new Country(1, "India");
		Country chinaCountry=new Country(4, "China");
		Country nepalCountry=new Country(3, "Nepal");
		Country bhutanCountry=new Country(2, "Bhutan");
 
		List listOfCountries = new ArrayList();
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);
 
		System.out.println("Before Sort  : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country=(Country) listOfCountries.get(i);
			System.out.println("Country Id: "+country.getCountryId()+"||"+"Country name: "+country.getCountryName());
		}
		Collections.sort(listOfCountries);
 
		System.out.println("After Sort  : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country=(Country) listOfCountries.get(i);
			System.out.println("Country Id: "+country.getCountryId()+"|| "+"Country name: "+country.getCountryName());
		}
	}
 
}
```

## 1.4 如何从ArrayList中删除重复的元素

1. 使用迭代方法 : 在创建一个新的集合对象，然后遍历旧的集合，第遍历一个元素就判断此元素在新的集合中有没有，如果有，则不存入新的集合中，没有则存入
2. 使用HashSet(不维护插入的顺序)‘
3. 使用LinkedHashMap

**示例**

```java
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
```

## 1.5 在java中迭代列表

- 对于循环**for (int i = 0; i < max; i ++)**
- 对于每个循环**foreach**
- 循环
- 迭代器

```java
		// For loop
		System.out.println("Iterating using for loop : ");
		for (int i = 0; i < countryLists.size(); i++) {
			Country countryObj=countryLists.get(i);
			System.out.println(countryObj.getName());
		}
		System.out.println("-----------------------------");
 
		// For each loop
		System.out.println("Iterating using for each loop : ");
		for (Country countryObj:countryLists) {
			System.out.println(countryObj.getName());
		}
		System.out.println("-----------------------------");
 
		// While loop
		System.out.println("Iterating using while loop : ");
		int i=0;
		while(i<countryLists.size())
		{
			Country countryObj=countryLists.get(i);
			System.out.println(countryObj.getName());
			i++;
		}
 
		System.out.println("-----------------------------");
 
		// Iterator
		System.out.println("Iterating using iterator : ");
		Iterator iteratorCountryLists= countryLists.iterator();
		while(iteratorCountryLists.hasNext())
		{
			System.out.println(iteratorCountryLists.next().getName());
		}
 
```

