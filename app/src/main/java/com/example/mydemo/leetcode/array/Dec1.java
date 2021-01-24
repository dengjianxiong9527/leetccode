package com.example.mydemo.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jianxiong.deng
 * @date 2020/12/11
 * @des
 */
class Dec1 {

    public static void main(String arg[]) {
        Dec1 dec11 = new Dec1();
        dec11.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});

        dec11.replaceSpace("We are happy.");

        dec11.printNumbers(1);
    }

    // * 输入:
    // * [4,3,2,7,8,2,3,1]
    // * 输出:
    // * [2,3]
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> setList = new HashSet<>();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!setList.add(nums[i])) {
                integerList.add(nums[i]);
            }

        }

        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }
        return integerList;
    }

    // [
    //  [1,   4,  7, 11, 15],
    //  [2,   5,  8, 12, 19],
    //  [3,   6,  9, 16, 22],
    //  [10, 13, 14, 17, 24],
    //  [18, 21, 23, 26, 30]
    //]
    //给定 target = 5，返回 true。
    //给定 target = 20，返回 false。

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int col = matrix[0].length;
        int row = 0;
        int column = col - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (target == num) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    // 输入：s = "We are happy."
    //输出："We%20are%20happy."
    public String replaceSpace(String s) {
//        if(s == null ) return  "";
//        System.out.println("sssss:" + s.replaceAll(" ", "%20"));
//        return s.replaceAll(" ", "%20");
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : s.toCharArray()) {
            if (character == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    //s = "abaccdeff"
    //返回 "b"
    // s = ""
    //返回 " "

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            hashMap.put(c, !hashMap.containsKey(c));
        }
        for (char c : chars) {
            if (hashMap.get(c)) {
                return c;
            }
        }
        return ' ';
    }
    //输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

    public int[] printNumbers(int n) {
        int k = 1;

        for(int i = 0; i < n; i++){
             k = k * 10;
        }
        int a[] = new int[k];

        for(int i = 0; i < a.length - 1 ; i ++){
            a[i] = i + 1;
        }
        return a;
    }

}
