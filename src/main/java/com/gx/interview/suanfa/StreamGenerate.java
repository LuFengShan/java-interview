package com.gx.interview.suanfa;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link Stream#generate(Supplier)} : 返回无限顺序无序流，其中每个元素由提供的Supplier生成。 这适用于生成恒定流，随机元素流等。
 * {@link Stream#iterate(Object, UnaryOperator)} :
 * 返回有序无限连续Stream由函数的迭代应用产生f至初始元素seed ，产生Stream包括seed ， f(seed) ， f(f(seed)) ，等
 * 第一元件（位置0在） Stream将是提供seed 。 对于n > 0 ，位置n的元素将是将函数f应用于位置n - 1的元素的n - 1 。
 * 简单的说就是指定一个常量seed，产生从seed到常量f（由UnaryOperator返回的值得到）的流。这是一个迭代的过程。
 */
public class StreamGenerate {
    public static void main(String[] args) {
        // 1.请计算1的平方到n的平方的和，取前5个值
        System.out.println("基本实现");
        Stream.iterate(new Pair(1, 1),
                pair -> new Pair(pair.index + 1, Math.pow(pair.index + 1, 2)))
                .limit(5)
                .map(pair -> pair.value)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // 2. 1中的方法太麻烦，改进类
        System.out.println("1中的方法太麻烦，改进类");
        Stream.iterate(Pair2.SEED, Pair2::next)
                .limit(5)
                .map(pair2 -> pair2.value)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // 3. 阶乘函数
        System.out.println("阶乘函数");
        Stream.iterate(Factorial.SEED, Factorial::next)
                .limit(5)
                .map(factorial -> factorial.value)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // 4. 斐波那契
        System.out.println("斐波那契");
        Stream.iterate(Fibonacci.SEED, Fibonacci::next)
                .limit(5)
                .map(fibonacci -> fibonacci.value)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // 5.
    }
}

/**
 * 平方
 */
class Pair {

    public final int index;
    public final double value;

    public Pair(int index, double value) {
        this.index = index;
        this.value = value;
    }
}

class Pair2 {
    public static final Pair2 SEED = new Pair2(1, 1);

    public final int index;
    public final double value;

    public Pair2(int index, double value) {
        this.index = index;
        this.value = value;
    }

    public Pair2 next() {
        return new Pair2(index + 1, Math.pow(index + 1, 2));
    }
}

/**
 * 阶乘函数
 */
class Factorial {

    public static final Factorial SEED = new Factorial(1, 1);

    public final int index;
    public final int value;

    public Factorial(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public Factorial next() {
        return new Factorial(index + 1, value * index);
    }
}

/**
 * 斐波那契函数
 */
class Fibonacci {

    public static final Fibonacci SEED = new Fibonacci(1, 1);

    public final int previous;
    public final int value;


    public Fibonacci(int previous, int value) {
        this.previous = previous;
        this.value = value;
    }

    public Fibonacci next() {
        return new Fibonacci(value, value + previous);
    }
}