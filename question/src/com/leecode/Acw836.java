package com.leecode;

import java.io.*;

public class Acw836 {
    static int N = 100010;
    static int[] p = new int[N];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while (m -- > 0){
            str = reader.readLine().split(" ");
            if(str[0].equals("M")){
                p[find(Integer.parseInt(str[1]))] = find(Integer.parseInt(str[2]));
            }else if(str[0].equals("Q")){
                if(find(Integer.parseInt(str[1])) == find(Integer.parseInt(str[2]))){
                    writer.write("YES");
                }else {
                    writer.write("NO");
                }
                writer.write("\n");
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }
    public static int find(int x){
        if(p[x] != x) return find(p[x]);
        return x;
    }
}
