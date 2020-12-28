package com.example.mydemo.demo;

import java.util.Collections;

/**
 * @author jianxiong.deng
 * @date 2020/11/27
 * @des
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 */
class Nov26 {
    public static void main(String[] args){
        Nov26 nov26 = new Nov26();
        nov26.sortedSquares(new int[]{-4,-1,0,3,10});
    }

    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            int newParams = Math.abs(A[i]);
            A[i] = (newParams * newParams);
        }

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length - 1; j++){
                int temp;
                if(A[j] > A[j+1]){
                     temp = A[j];
                     A[j] = A[j+1];
                     A[j+1] = temp;
                }
            }
        }

        for(int i = 0;  i < A.length; i++){
            System.out.println(A[i]);
        }

        return A;
    }
}
