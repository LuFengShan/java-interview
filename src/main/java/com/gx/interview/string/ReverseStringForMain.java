package com.gx.interview.string;

/**
 * 反转字符串
 * 1. 使用for循环
 * 2. 使用递归
 * 3. 使用StringBuffer：推荐使用
 */
public class ReverseStringForMain {
    public static void main(String[] args) {
        ReverseStringForMain rsf = new ReverseStringForMain();
        String reverse = rsf.forReverseString("tilesile");
        System.out.println("使用for循环反转 tilesile 的结果:" + reverse);
        reverse = rsf.recursiveReverse("qwertyuiop");
        System.out.println("使用递归反转 qwertyuiop 的结果:" + reverse);
        reverse = rsf.stringBufferReverseString("asdfghjkl");
        System.out.println("使用StringBuffer反转 asdfghjkl 的结果:" + reverse);
    }

    /**
     * 使用for循环
     * @param str
     * @return
     */
    public String forReverseString(String str){
        // 使用for循环
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }

    /**
     * 使用递归来反转字符串
     *
     * @param orig
     * @return
     */
    public String recursiveReverse(String orig) {
        if (orig.length() == 1)
            return orig;
        else
            return orig.charAt(orig.length() - 1) + recursiveReverse(orig.substring(0, orig.length() - 1));
    }

    /**
     * 使用StringBuffer来反转字符串
     * @param str
     * @return
     */
    public String stringBufferReverseString(String str) {
        StringBuffer sb = new StringBuffer(str);
        return  sb.reverse().toString();
    }

}
