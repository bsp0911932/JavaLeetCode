package com.bruce.javaleetcode.chapter1array;

/**
 * Created by bushaopeng on 16/11/1.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index,
 * otherwise return -1. You may assume no duplicate exists in the array.
 */
public class SearchInRotated {
    public static int binarySearchInRotated(int[] rotateArr, int target) {
        int first = 0, last = rotateArr.length;
        int mid = 0;
        while (first != last) {
            mid = getMid(first, last);
            if (rotateArr[mid] == target) {
                return mid;
            }
            if (rotateArr[mid] > rotateArr[first]) {
                if (rotateArr[mid] > target && rotateArr[first] < target) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
            } else {
                if (target < rotateArr[first] && target > rotateArr[mid]) {
                    first = mid + 1;
                } else {
                    last = mid;
                }
            }
        }
        return -1;
    }

    public static int getMid(int start, int end) {
        return (end - start) / 2 + start;
    }

    public static void test() {
        System.out.println("找到的index是：" + binarySearchInRotated(new int[]{8, 9, 10, 1, 2, 4, 5, 6, 7}, 5));
    }
}
