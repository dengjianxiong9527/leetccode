package com.example.mydemo.leetcode;

import java.util.Arrays;

/**
 * @author jianxiong.deng
 * @date 2020/11/14
 * @des
 */
class Nov5 {
    public static void main(String[] args) {
        Nov5 nov5 = new Nov5();
        nov5.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }


    // 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
    public int majorityElement(int[] nums) {


        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int temp = 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1]) {
                    temp++;
                } else {
                    if (temp > nums.length / 2) {
                        max = i;
                        break;
                    }

                    temp = 1;
                }

            } else {
                if (temp > nums.length / 2) {
                    max = i;
                }
            }
        }
        return max > 0 ? nums[max] : -1;
    }
    // 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
    // 输入：arr = [3,2,1], k = 2
    //输出：[1,2] 或者 [2,1]

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = arr[i];
        }
        return a;
    }

}
