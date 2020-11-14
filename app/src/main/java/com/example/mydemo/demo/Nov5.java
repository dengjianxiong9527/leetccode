package com.example.mydemo.demo;

import java.util.Arrays;

/**
 * @author jianxiong.deng
 * @date 2020/11/14
 * @des
 */
class Nov5 {
    public static void main(String[] args) {
        Nov5 nov5 = new Nov5();
        nov5.majorityElement(new int[]{2,2,1,1,1,2,2});
    }

    public  int majorityElement(int[] nums) {


        if(nums.length  == 1){
            return  nums[0];
        }
        Arrays.sort(nums);
        int temp = 1;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i+1 < nums.length){
                if(nums[i] == nums[i+1]){
                    temp ++;
                }else {
                    if(temp > nums.length / 2){
                        max = i;
                        break;
                    }

                    temp = 1;
                }

            }else {
                if(temp > nums.length / 2){
                    max = i;
                }
            }
        }
        return  max > 0 ? nums[max] : -1;

    }
}
