package com.leecode;

import java.util.*;

public class Test524 {
//    public static void main(String[] args) {
//        List<String> dictionary = new ArrayList<>();
//        dictionary.add("abe");
//        dictionary.add("abc");
//        String s = "abce";
//        System.out.println(findLongestWord(s, dictionary));
//    }
//    public static String findLongestWord(String s, List<String> dictionary) {
//        Collections.sort(dictionary, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o2.length()!=o1.length()) {
//                    return o2.length() - o1.length();
//                }else {
//                    return o1.compareTo(o2);
//                }
//            }
//        });
//        for (int i = 0; i < dictionary.size(); i++) {
//            String temp = dictionary.get(i);
//            if(temp.length()>s.length()) continue;
//                for (int m=0,n=0;m<s.length()&&n<temp.length();){
//                    if(s.charAt(m) == temp.charAt(n)){
//                        m++;
//                        n++;
//                    }else {
//                        m++;
//                    }
//                    if(n == temp.length()){
//                        return temp;
//                    }
//            }
//        }
//        return "";
//    }
public String findLongestWord(String s, List<String> dictionary) {
    //把数组按照字符串长度排序，同样长度的按照字母序顺序排序
    dictionary.sort(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length()!=o2.length()) return o1.length()-o2.length();
            else return o2.compareTo(o1);
        }
    });
    int n = dictionary.size();
    //遍历字符串数组
    for (int i = n-1; i >= 0; i--) {
        String str = dictionary.get(i);
        int j = 0,k = 0;
        //匹配
        while (j<s.length()&&k<str.length()){
            if (s.charAt(j) == str.charAt(k)){
                j++;
                k++;
            }else {
                j++;
            }
        }
        if (k == str.length()) return str;
    }
    return "";
}
}
