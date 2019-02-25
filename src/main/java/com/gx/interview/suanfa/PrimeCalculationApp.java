package com.gx.interview.suanfa;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 输出范围内1-10000的素数的个数
 * {@link Executors} : 提供了方便的工厂方法来创建不同类型的执行程序服务.其实就是创建线程池
 * {@link ExecutorService} : 执行线程池的执行器。
 * {@link Executors#newWorkStealingPool()} : 默认是创建主机CPU的可用核心数线程池
 */
public class PrimeCalculationApp {
    public static void main(String[] args) throws InterruptedException {
        // 1.线程服务提供者（线程池大小与主机核心默认是一样的）
        ExecutorService executor = Executors.newWorkStealingPool();
        // 2.可回调的线程的列表
        PrimeCalculationThread server1 = new PrimeCalculationThread(1, 2500);
        PrimeCalculationThread server2 = new PrimeCalculationThread(2501, 5000);
        PrimeCalculationThread server3 = new PrimeCalculationThread(5001, 7500);
        PrimeCalculationThread server4 = new PrimeCalculationThread(7501, 10000);
        List<Callable<Integer>> list = Arrays.asList(server1, server2, server3, server4);
        // 3.批量执行所有的线程
        List<Integer> collect = executor.invokeAll(list)
                .stream()
                .map(future -> {
                    Integer sum = 0;
                    try {
                        sum = future.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return sum;
                }).collect(Collectors.toList());
        int sum = 0;
        for (Integer i : collect) {
            sum += i;
        }
        System.out.println(sum);
    }
}

/**
 * 范围内(列如小于等于1000)的多线程计算素数的方法
 */
class PrimeCalculationThread implements Callable<Integer> {
    private int start;
    private int end;

    public PrimeCalculationThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        int j;
        for (int i = start; i <= end; i++) {
            j = 2;
            for (; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > Math.sqrt(i)) {
                // System.out.println(i);
                sum++;
            }
        }
        return sum;
    }
}