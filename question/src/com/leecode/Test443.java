package com.leecode;

public class Test443 {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        int n = chars.length;
        int ans=0,count=0;
        char[] s = new char[20000];
        int num = 0;
        for (int i = 0,j = 0;j<n&&i<n;){
            while (j<n&&i<n&&chars[i] == chars[j]) {
                count++;
                j++;
            }
            if(count == 1){
                s[num++] = chars[i];
            }else if (count>1){
                String str=String.valueOf(count);
                s[num++] = chars[i];
                for (int k = 0; k < str.length(); k++) {
                    s[num++] = str.charAt(k);
                }
            }
            count = 0;
            i=j;
        }
        for (int i = 0; i < num; i++) {
            chars[i] = s[i];
        }
        return num;
    }
}
