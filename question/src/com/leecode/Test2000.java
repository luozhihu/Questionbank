package com.leecode;

import java.util.Arrays;

public class Test2000 {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word,ch));

    }
    public static String reversePrefix(String word, char ch) {
        int n = word.length();
        char[] str = word.toCharArray();
        int i=0,j=0;
        while (j<n&&ch!=str[j]) j++;
        if (j<n){
            return new String(reverse(i,j,str));
        }else {
            return new String(str);
        }
    }
    public static  char[] reverse(int i,int j,char[] str){
        while (i<j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return str;
    }
}
