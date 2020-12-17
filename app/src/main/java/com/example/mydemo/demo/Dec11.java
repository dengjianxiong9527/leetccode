package com.example.mydemo.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jianxiong.deng
 * @date 2020/12/11
 * @des
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [2,3]
 */
class Dec11 {

    public static void main(String arg[]){
        Dec11 dec11 = new Dec11();
        dec11.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }

    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> setList = new HashSet<>();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!setList.add(nums[i])) {
                integerList.add(nums[i]);
            }

        }

        for(int i = 0;  i < integerList.size(); i++){
            System.out.println(integerList.get(i));
        }
        return integerList;
    }
}
