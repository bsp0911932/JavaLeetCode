package com.bruce.javaleetcode.chapter1array;

/**
 * Created by bushaopeng on 16/10/31.
 * Given a sorted array, remove the duplicates in place
 * such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 *
 * key points:
 */
public class RemoveDuplicates {

    public static int remove1(int[] dupArr) {
        int len = 0;
        int noDupIndex = 0;
        for (int i = 0; i < dupArr.length - 1; i++) {
            if (dupArr[i + 1] != dupArr[noDupIndex]) {
                noDupIndex++;
                if (dupArr[noDupIndex] != dupArr[i + 1]) {
                    dupArr[noDupIndex] = dupArr[i + 1];
                }
            }
        }
        len = noDupIndex + 1;
        return len;
    }

    /**
     * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice? Or n times? For example,
     * Given sorted array A = [1,1,1,2,2,3],
     * Your function should return length = 5, and A is now [1,1,2,2,3]
     *
     * @param dupArr
     * @param allowDup how many times allowed at most
     * @return
     */
    public static int remove2(int[] dupArr, int allowDup) {
        int len = 0;
        int actPos = 0;
        int appearTime = 1;
        int actNum = dupArr[actPos];
        for (int i = 1; i < dupArr.length; i++) {
            if (dupArr[i] == actNum) {
                appearTime++;
            } else {
                if (appearTime >= allowDup) {
                    actPos += allowDup;
                } else {
                    actPos += appearTime;
                }
                dupArr[actPos] = actNum = dupArr[i];
                appearTime = 1;
            }
        }
        //注意尾部处理
        int tailLen;
        if (appearTime >= allowDup) {
            tailLen= allowDup;
        } else {
            tailLen= appearTime;
        }
        len = actPos+tailLen;
        for (int i = actPos + 1; i < actPos + tailLen; i++) {
            dupArr[i] = actNum;
        }
        return len;
    }

    public static int test() {
        System.out.println("this is my proj");
        int[] dupArr = {1, 1, 2, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5};
        int len = RemoveDuplicates.remove2(dupArr, 3);
        for (int i = 0; i < len; i++) {
            System.out.println(dupArr[i]);
        }
        return 0;
    }
}
