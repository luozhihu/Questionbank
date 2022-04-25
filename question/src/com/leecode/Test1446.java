package com.leecode;

public class Test1446 {
    public static void main(String[] args) {

    }
    public static int maxPower(String s) {
        char[] ch = s.toCharArray();
        int count = 1,max = 0;
        int i = 1;
        int n = s.length();
        while (i<n){
            if (ch[i] == ch[i-1]){
                count++;
            }else {
                max = Math.max(max,count);
                count=1;
            }
            i++;
        }
        return max;
    }
}
