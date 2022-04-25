package com.leecode;

import java.io.*;

public class Acw240 {
    static int[] fa= new int[50010], d= new int[50010];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n,k;
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
        }
        int count = 0;
        while (k-->0){
            str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[2]);
            if(x>n || x<1 || y>n || y<1){
                count++;
                continue;
            }else if(a == 2 && x == y){
                count++;
                continue;
            }else {
                int rel;
                if(a == 2) rel = 1;
                else rel = 0;
                int px = find(x),py = find(y);
                if(px == py){
                    if((((d[x] - d[y]) % 3) + 3) % 3 != rel){
                        count++;
                    }
                }else
                    {
                        fa[px] = py;
                        d[px] = d[y] -(d[x] - rel);
                    }

            }
        }
        //System.out.println(count);
        writer.write(""+count);
        writer.flush();
        writer.close();
        reader.close();
    }
    public static int find(int x){
        if(fa[x] != x){
            int t = find(fa[x]);
            d[x] += d[fa[x]];
            fa[x] = t;
        }
        return fa[x];
    }
}
