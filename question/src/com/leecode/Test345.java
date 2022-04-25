package com.leecode;

import java.util.HashSet;

public class Test345 {
    public static void main(String[] args) {

    }
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = s.length();
        int i = 0 , j = n - 1;
        char[] ch = s.toCharArray();
        while (i<j){
            while (!set.contains(ch[i])){
                i++;
            }
            while (!set.contains(ch[j])){
                j--;
            }
            if (i<j){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
            }
            i++;
            j--;
        }
        return String.valueOf(ch);
    }
}
