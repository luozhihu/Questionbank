package com.leecode;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static int[] table = new int[100000];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        int n = lengthOfLongestSubstring(str[0]);
        writer.write(n+"");
        writer.flush();
        writer.close();
        reader.close();
    }
    public static int lengthOfLongestSubstring(String str){
        int left = 0;
        int max = 0;
        int n = str.length();
        HashMap<Character,Integer> map = new HashMap<>();
        //1.HashMap可以用来计算各个字符个数
        //2.可以记录是否出现过
        //3.可以记录字符所在的下标
        for (int i = 0; i < n; i++) {
            if (map.containsKey(str.charAt(i))){
                left = Math.max(left,map.get(str.charAt(i))+1);
            }
            map.put(str.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
