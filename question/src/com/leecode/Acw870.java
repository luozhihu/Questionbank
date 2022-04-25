package com.leecode;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Acw870 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = reader.readLine();
        int n = Integer.parseInt(str);
        Map<Integer, Integer> countmap = new HashMap<>();
        while (n-- > 0) {
            str = reader.readLine();
            int x = Integer.parseInt(str);
            //countmap.put(x, 0);
            for (int i = 2; i <= x / i; ++i) {
                while (x % i == 0) {
                    //x /= i;
                    countmap.put(i, countmap.getOrDefault(i, 0) + 1);
                    x /= i;
                }
            }
            if (x > 1) {
                countmap.put(x, countmap.getOrDefault(x, 0) + 1);
            }
        }
        //int ans = 1;
        long ans = 1;
        int mod = 1000000007;
        for (int value : countmap.values()) {
            ans = (ans * (value+1))%mod;
        }
        System.out.println(ans);
    }
}
