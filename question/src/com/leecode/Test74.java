package com.leecode;

public class Test74 {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length,n=matrix.length;
        int i = 0,j = n - 1;
        while (i<j){
            int mid = (i+j + 1)/2;
            if (matrix[mid][0]<=target){
                i = mid;
            }else {
                j = mid - 1;
            }
        }
        int y = i;
        i = 0;
        j = m - 1;
        while (i<j){
            int mid = (i+j + 1)/2;
            if (matrix[y][mid]<=target){
                i = mid;
            }else {
                j = mid - 1;
            }
        }
        if (matrix[y][i] == target) return true;
        else return false;
    }
}
