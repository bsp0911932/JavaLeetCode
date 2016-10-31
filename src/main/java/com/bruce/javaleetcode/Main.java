package com.bruce.javaleetcode;

import com.bruce.javaleetcode.chapter1array.RemoveDuplicates;

/**
 * Created by bushaopeng on 16/10/31.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("this is my proj");
        int[] dupArr = {1, 1, 2, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5};
        int len = RemoveDuplicates.remove2(dupArr, 4);
        for (int i = 0; i < len; i++) {
            System.out.println(dupArr[i]);
        }
    }
}
