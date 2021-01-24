package com.example.mydemo.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jianxiong.deng
 * @date 2020/11/2
 * @des
 */
public class Nov3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverse(-321);
    }

    public static class Solution {
        public int reverse(int x) {
            boolean isUnSign = false;
            StringBuilder stringBuilder = new StringBuilder();
            List<Character> list = new ArrayList<>();
            char[] chars = String.valueOf(x).toCharArray();
            if (chars[0] == 45) {
                isUnSign = true;
            }
            for (int i = 0; i < chars.length; i++) {

                if (i == (chars.length - 1) && chars[chars.length - 1] == 48 || i == 0 && chars[0] == 45) {

                } else {
                    list.add(chars[i]);
                }
            }
            Collections.reverse(list);

            if (isUnSign) {
                stringBuilder.append("-");
            }
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
            }

            BigDecimal bigDecimal = new BigDecimal(stringBuilder.toString());
            if (bigDecimal.compareTo(new BigDecimal(String.valueOf(Integer.MAX_VALUE))) > 0 || bigDecimal.compareTo(new BigDecimal(String.valueOf(Integer.MIN_VALUE))) < 0) {
                return 0;
            } else {
                System.out.println();
                System.out.print("" + Integer.parseInt(stringBuilder.toString()));
                return Integer.parseInt(stringBuilder.toString());
            }

        }
    }


}
