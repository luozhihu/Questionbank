package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class Test68 {
    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth).get(4).length());
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        int i = 0;
        int width = 0;
        int count = 0;
        int space = 0;
        int addspace = 0;
        int lastaddspace = 0;
        int j = 0;
        int num = 0;
        int m = 0;
        StringBuffer temp = new StringBuffer();
        while (i < n){
            width += words[i].length();
            num++;
            count++;
            if(width + count - 1 > maxWidth && count>2) {
                width -= words[i].length();
                count--;
                num--;
                space = maxWidth - width;
                addspace = space/(count-1);
                lastaddspace = space%(count-1);
                for (; j < num -1; j++) {
                    temp.append(words[j]);
                    for (int k = 0; k < addspace; k++) {
                        temp.append(" ");
                    }
                    if(m < lastaddspace){
                        temp.append(" ");
                        m++;
                    }
                    if(j == num - 2){
                        temp.append(words[j+1]);
                    }
                }
                j++;
                ans.add(temp.toString());
                temp.delete(0,temp.length());
                count = 0;
                width = 0;
                m = 0;
                i --;
            }else if(width + count - 1 > maxWidth && count<=2){
                width -= words[i].length();
                count--;
                num--;
                space = maxWidth - width;
                temp.append(words[j]);
                j++;
                for (int p = 0; p < space; p++) {
                    temp.append(" ");
                }
                ans.add(temp.toString());
                temp.delete(0,temp.length());
                count = 0;
                width = 0;
                m = 0;
                i--;
            }else if(i == n - 1){
                for (; j < num - 1; j++) {
                    temp.append(words[j]);
                    temp.append(" ");
                }
                if(j == num -1){
                    temp.append(words[j]);
                }
                while (temp.length()<maxWidth){
                    temp.append(" ");
                }
                ans.add(temp.toString());
            }
            i++;
        }
        return ans;
    }
}
