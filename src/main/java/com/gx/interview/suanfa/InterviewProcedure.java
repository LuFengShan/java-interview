package com.gx.interview.suanfa;

/**
 * 主要是记录面试中遇到的程序问题
 */
public class InterviewProcedure {
    public static void main(String[] args) {
        boot();
        System.out.println("递归，N的阶乘 : " + diGui_JieCheng(5));
        System.out.println("递归，1到N的相加 : " + diGui_1_N(100));
    }


    /**
     * N的阶乘,递归实现
     *
     * @param n
     * @return
     */
    public static int diGui_JieCheng(int n) {
        if (n == 1) {
            return 1;
        } else {
            int num = n * diGui_JieCheng(n - 1);
            return num;
        }
    }

    /**
     * 从1加到n,用递归算法实现
     *
     * @param n
     * @return
     */
    public static int diGui_1_N(int n) {
        if (n == 1) {
            return 1;
        } else {
            int num = n + diGui_1_N(n - 1);
            return num;
        }
    }

    /**
     * 面试中遇到的基础运算符优先级的问题
     */
    public static void boot() {
        int a = 5, b = 8, c = 9;
        // System.out.println("++a : " + ++a); // 6
        // System.out.println("++a * a  : " + ++a * a); // 36
        // System.out.println("++a * a + --b : " + (++a * a + --b)); // 43
        // System.out.println(++a * a + --b + c--); //52 这个时候c运行完以后是9
        // System.out.println(++a * a + --b + c * c--); // 142
        System.out.println(++a * a + --b + c-- * c); // 115
    }
}
