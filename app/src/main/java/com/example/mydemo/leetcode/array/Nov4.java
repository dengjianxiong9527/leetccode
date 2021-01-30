package com.example.mydemo.leetcode.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jianxiong.deng
 * @date 2020/11/5
 * @des
 */
class Nov4 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] dp = new int[n + 1];
//        int[] readArr = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            for (int k = 1; k < n + 1; k++)
//                readArr[k] = in.nextInt();
//            for (int j = 1; j < n + 1; j++)
//                dp[j] = Math.max(dp[j], dp[j - 1]) + readArr[j];
//        }
//        System.out.println(dp[n]);
//          longestPalindrome("babab");
//            maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});

//        uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});

//        List<String> list = new ArrayList<>();
//        list.add("cats");
//        list.add("dog");
//        list.add("sand");
//        list.add("and");
//        list.add("and");
//        wordBreak("catsandog", list);
//        maxProfit(new int[]{7,1,5,3,6,4});
          minPathSum(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}});
          maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});

    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] record = new int[m][n];
        int i=0,j=0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(i==0 && j==0)
                    record[i][j]=grid[i][j];
                else if(i==0 && j>0)
                    record[i][j]=grid[i][j]+record[i][j-1];
                else if(j==0 && i>0)
                    record[i][j]=grid[i][j]+record[i-1][j];
                else
                    record[i][j]=Math.min(record[i-1][j],record[i][j-1])+grid[i][j];
            }
        }
        return record[i-1][j-1];
    }

    public static int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int min_prices = prices[0];
        int max_profit = 0;
        for(int i = 0;i<prices.length;i++){
            min_prices = Math.min(min_prices, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - min_prices);
        }
        return max_profit;
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] record = new int[obstacleGrid.length][obstacleGrid[0].length];
        int i = 0;
        int j = 0;
        for (i = 0; i < obstacleGrid.length; i++) {
            for (j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    record[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    record[i][j] = 1;
                } else if (i == 0 && j > 0) {
                    record[i][j] = record[i][j - 1];
                } else if (j == 0 && i > 0) {
                    record[i][j] = record[i - 1][j];
                } else {
                    record[i][j] = record[i - 1][j] + record[i][j - 1];
                }
            }
        }
        return record[i - 1][j - 1];
    }
    //输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
    //输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
    //输出: 6
    //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);  //以一个字符为中心
            int len2 = expandAroundCenter(s, i, i + 1); //以两个字符为中心
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    //写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    public int add(int a, int b){
        if(a == 0 || b == 0){
            return a == 0 ? b : a;
        }

        int sum = 0, carry = 0;

        while (b != 0){
            sum = a ^ b;
            carry =  (a & b) << 1 ;

            a = sum;
            b = carry;
        }
        return a;
    }
}
