package com.leecode;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Acw869 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = reader.readLine();
        int n = Integer.parseInt(str);
        while (n-->0){
            str = reader.readLine();
            List<Integer> ans = search(Integer.parseInt(str));
            ans.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (Integer an : ans) {
                writer.write(an+" ");
            }
            writer.write("\n");
            writer.flush();
        }
        writer.close();
        reader.close();

    }
    public static List<Integer> search(int n){
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0){
                list.add(i);
                if (i != n / i){
                    list.add(n/i);
                }
            }
        }
        return list;
    }
}
