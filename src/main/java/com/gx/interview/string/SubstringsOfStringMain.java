package com.gx.interview.string;

/**
 * 将使用String类的subString方法来查找所有subString，基于两个for循环
 */
class SubstringsOfStringMain {
    public static void main(String args[]) {
        String str = "sun";
        System.out.println("sun的所有子字符串 : ");
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));

            }
        }
    }
}