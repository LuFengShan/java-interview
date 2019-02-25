package com.gx.interview.collection;

public class Country {

    String name;
    long population;

    public Country(String name, long population) {
        super();
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    //如果country对象中的name长度为偶数，则返回31（任意随机数），如果为奇数，则返回95（任意随机数）。
    //这不是一个很好的做法，如下面的方法生成哈希码，但我这样做是为了更好，更容易地理解hashmap。
    @Override
    public int hashCode() {
        if (this.name.length() % 2 == 0)
            return 31;
        else
            return 95;
    }

    @Override
    public boolean equals(Object obj) {

        Country other = (Country) obj;
        if (name.equalsIgnoreCase((other.name)))
            return true;
        return false;
    }

}