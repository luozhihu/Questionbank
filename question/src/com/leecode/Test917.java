package com.leecode;

public class Test917 {
    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.println(reverseOnlyLetters(s));
    }
    public static String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i=0,j=n-1;
        while (i<j){
            if (ch[i] - 'a'>=0 && ch[i] - 'a'<= 25 || ch[i] - 'A'>=0 && ch[i] - 'A'<= 25){
                while (i<j&&!(ch[j] - 'a'>=0 && ch[j] - 'a'<= 25 || ch[j] - 'A'>=0 && ch[j] - 'A'<= 25)){
                    j--;
                }
                if (i<j&&(ch[j] - 'a'>=0 && ch[j] - 'a'<= 25 || ch[j] - 'A'>=0 && ch[j] - 'A'<= 25)){
                    char c =ch[i];
                    ch[i] = ch[j];
                    ch[j] = c;
                    i++;
                    j--;
                }
            }else {
                i++;
            }
        }
        return new String(ch);
    }
}
