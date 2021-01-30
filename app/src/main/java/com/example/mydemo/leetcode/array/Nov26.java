package com.example.mydemo.leetcode.array;

import java.util.Stack;

/**
 * @author jianxiong.deng
 * @date 2020/11/27
 * @des 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 */
class Nov26 {
    public static void main(String[] args) {
        Nov26 nov26 = new Nov26();
        nov26.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        nov26.compressString("aabcccccaaa");

        nov26.reverseWords("the sky is blue");
    }

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int newParams = Math.abs(A[i]);
            A[i] = (newParams * newParams);
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                int temp;
                if (A[j] > A[j + 1]) {
                    temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }

        return A;
    }

    //实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
    //输入: s = "leetcode"
    //输出: false

    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (astr.indexOf(chars[i], i + 1) != -1) {
                return false;
            }
        }
        return true;
    }

    //字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
    // 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
    // 输入："aabcccccaaa"
    // 输出："a2b1c5a3"
    public String compressString(String S) {
        char[] chars = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
                continue;
            } else {
                stringBuilder.append(chars[i]);
                count = 1;
                stringBuilder.append(count);

            }
        }
        System.out.println("sss: " + stringBuilder.toString());
        return stringBuilder.toString().length() > S.length() ? S : stringBuilder.toString();
    }

    // 统计一个数字在排序数组中出现的次数。
    // 输入: nums = [5,7,7,8,8,10], target = 8
    //输出: 2
    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
            }
        }
        return count;
    }

    //输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
    public String reverseWords(String s) {
        String[] a = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> strings = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if(!a[i].isEmpty()){
                strings.push(a[i]);
            }
        }
        int size = strings.size();
        int count = 0;
        while (!strings.isEmpty()){

            count++;

            stringBuilder.append(strings.pop());
            if(count < size){
                stringBuilder.append(" ");
            }
        }

        System.out.println("stringBuilder:" + stringBuilder.toString() + "---");
        return stringBuilder.toString();
    }


}
