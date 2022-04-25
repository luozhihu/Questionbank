package com.leecode;

public class Text58 {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        int i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        int count = 0;
        while (i >= 0 && s.charAt(i) != ' '){
            i--;
            count++;
        }
        return count;
    }
}
