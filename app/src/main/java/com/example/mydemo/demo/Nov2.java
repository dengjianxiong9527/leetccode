package com.example.mydemo.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author jianxiong.deng
 * @date 2020/11/2
 * @des
 */
public class Nov2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.intersection(new int[]{1, 2, 2, 3, 1}, new int[]{2, 3,});
    }

    public static class Solution {

        public int[] intersection(int[] nums1, int[] nums2) {
            if(nums1 != null && nums2 != null && nums1.length > 0 && nums2.length > 0) {
                Set<Integer> setNew = new HashSet<>();

                for(int i = 0; i < nums1.length; i++){
                    for(int j = 0; j < nums2.length; j++){
                        if(nums2[j] == nums1[i]){
                            setNew.add(nums2[j]);
                        }
                    }
                }

                int[] newNums = new int[setNew.size()];
                int a = 0;
                for(Integer value : setNew){
                    newNums[a] = value;
                    System.out.println("value:" + value);
                    a = a + 1;
                }
                return newNums;
            }else {
                return  new int[]{};
            }
        }
    }


}
