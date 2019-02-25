package com.gx.interview.sort;

public class MergeSortMain {

    static int arr[] = {100, 20, 15, 30, 5, 75, 40};

    public static void main(String args[]) {
        System.out.println("数据排序之前 ： ");
        // 排序前打印数组
        printArray(arr, 0, arr.length - 1);
        System.out.println("-----------------------------");

        // 用递归实现排序
        mergeSort(0, arr.length - 1);

        System.out.println("-----------------------------");

        // 排序后打印数组
        System.out.println("排序后打印数组:");
        printArray(arr, 0, arr.length - 1);


    }

    /**
     * 用于合并排序的递归算法
     *
     * @param start
     * @param end
     */
    public static void mergeSort(int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            // 排序左半部分
            mergeSort(start, mid);
            // 排序右半部分
            mergeSort(mid + 1, end);
            // 合并左右两半
            merge(start, mid, end);
        }

    }


    private static void merge(int start, int mid, int end) {
        // 初始化临时数组和索引
        int[] tempArray = new int[arr.length];
        int tempArrayIndex = start;

        System.out.print("合并前:  ");
        printArray(arr, start, end);

        int startIndex = start;
        int midIndex = mid + 1;

        // 它将迭代直到较小的列表到达结尾
        while (startIndex <= mid && midIndex <= end) {
            if (arr[startIndex] < arr[midIndex]) {
                tempArray[tempArrayIndex++] = arr[startIndex++];
            } else {
                tempArray[tempArrayIndex++] = arr[midIndex++];
            }
        }

        // 复制剩余的元素
        while (startIndex <= mid) {
            tempArray[tempArrayIndex++] = arr[startIndex++];
        }
        while (midIndex <= end) {
            tempArray[tempArrayIndex++] = arr[midIndex++];
        }

        // 排序后将tempArray复制到实际数组
        for (int i = start; i <= end; i++) {
            arr[i] = tempArray[i];
        }

        System.out.print("合并后:   ");
        printArray(tempArray, start, end);
        System.out.println();
    }

    /**
     * 打印数组
     *
     * @param arr   传入的数组
     * @param start 遍历开始的位置
     * @param end   遍历结束的位置
     */
    public static void printArray(int arr[], int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

