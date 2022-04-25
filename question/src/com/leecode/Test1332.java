package com.leecode;

public class Test1332 {
    public static void main(String[] args) {

    }
    public static int removePalindromeSub(String s) {
        char[] ch = s.toCharArray();
        int i = 0,j = ch.length-1;
        while (i<j){
            if (ch[i] == ch[j]){
                i++;
                j--;
            }else {
                return 2;
            }
        }
        return 1;
    }
}
