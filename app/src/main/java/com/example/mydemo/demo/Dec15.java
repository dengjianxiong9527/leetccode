package com.example.mydemo.demo;

import java.util.Arrays;

/**
 * @author jianxiong.deng
 * @date 2020/12/15
 * @des
 * 输入: "Hello, my name is John"
 * 输出: 5
 * reverseString 数组反转
 */
class Dec15 {
    public static void main(String[] args){
        Dec15 dec15 = new Dec15();
        //dec15.countSegments("");

        dec15.reverseString("hello".toCharArray());
    }

    public int countSegments(String s) {
        if(s.isEmpty()) return 0;
        int a = 0;
        for(int i = 0; i < s.length(); i++){
           if(s.toCharArray()[i] == 32){
               a++;
           }
        }
        System.out.println(a);
        return a + 1;
    }


    public void reverseString(char[] s) {
        if(s==null||s.length<=1){
            return;
        }

        int length = s.length-1;
        int center = length/2;

        char temp;
        int last;
        for(int i = 0;i <= center;i++){
            last = length-i;
            temp = s[i];
            s[i] = s[last];
            s[last] = temp;
        }
        System.out.print(s);
    }

//    public int findRepeatNumber(int[] nums) {
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length; i++){
//
//        }
//    }

}
