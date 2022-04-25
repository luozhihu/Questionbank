package com.leecode;

import java.util.*;

public class Test524 {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("abe");
        dictionary.add("abc");
        String s = "abce";
        System.out.println(findLongestWord(s, dictionary));
    }
    public static String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o2.length()!=o1.length()) {
                    return o2.length() - o1.length();
                }else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (int i = 0; i < dictionary.size(); i++) {
            String temp = dictionary.get(i);
            if(temp.length()>s.length()) continue;
                for (int m=0,n=0;m<s.length()&&n<temp.length();){
                    if(s.charAt(m) == temp.charAt(n)){
                        m++;
                        n++;
                    }else {
                        m++;
                    }
                    if(n == temp.length()){
                        return temp;
                    }
            }
        }
        return "";
    }
}
