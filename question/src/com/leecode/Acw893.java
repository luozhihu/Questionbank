package com.leecode;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Acw893 {
    public static int[] f = new int[10010];
    public static int[] s = new int[110];
    public static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        m = Integer.parseInt(str[0]);
        //int[] s = new int[m];
        //t[] f = new int[m];
        for (int i = 0; i < 10010; i++) {
            f[i] = -1;
        }
        str = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            s[i] = Integer.parseInt(str[i]);
        }
        str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int res = 0;
        str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int x;
            //str = reader.readLine().split(" ");
            x = Integer.parseInt(str[i]);
            res^=sg(x);
        }
        if (res > 0) writer.write("Yes");
        else writer.write("No");
        writer.flush();
        writer.close();
        reader.close();
    }
    public static int sg(int x){
        if (f[x] != -1) return f[x];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int sum = s[i];
            if(x>=sum) set.add(sg(x-sum));
        }
        for (int i = 0; ; i++) {
            if (!set.contains(i)){
                return f[x] = i;
            }
        }

    }
}
