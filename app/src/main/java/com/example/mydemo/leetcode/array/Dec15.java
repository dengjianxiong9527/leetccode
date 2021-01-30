package com.example.mydemo.leetcode.array;

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

        //dec15.reverseString("hello".toCharArray());

        dec15.twoSum(new int[]{2,7,8,11,15}, 9);
        dec15.spiralOrder(new int[][]{{1, 2, 3},{4, 5, 6}, {7, 8, 9} });
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

    // 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    // 输入：nums = [2,7,11,15], target = 9
    //输出：[2,7] 或者 [7,2]
    public int[] twoSum(int[] nums, int target) {
        int i = 0; int j = nums.length - 1;
        while (i < j){
            int a = nums[i] + nums[j];
            if(a < target){
                i++;
            }else if(a > target){
                j--;
            }else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[]{};
    }

    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int columns = matrix[0].length;

        int[] a = new int[row * columns];

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int x = 0;
        while (true){
            for(int i = l ; i <= r; i++){
                a[x++] = matrix[t][i];
            }
            if(++t > b) break;

            for(int i = t; i<= b; i++){
                a[x++] = matrix[i][b];
            }
            if(l > r--) break;
            for(int i = r; i>= l; i--){
                a[x++] =matrix[b][i];
            }
            if(t > --b) break;
            for(int i = b; i >= t; i--){
                a[x++] = matrix[i][l];
            }
            if(++l > r) break;
        }


        return a;
    }

}
