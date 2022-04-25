package com.leecode;

public class Test240 {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0,j = m - 1;
        return find(matrix,target,i,j);
    }
    boolean find(int[][] matrix,int target,int i,int j){
        if(i>=matrix.length) return false;
        if(j<0)return false;
        if(matrix[i][j]==target) return true;
        if(matrix[i][j]<target) return find(matrix,target,i+1,j);
        else return find(matrix,target,i,j-1);
    }
}
