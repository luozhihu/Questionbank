package com.leecode;

import java.io.*;

public class Acw890 {
    public static int N = 20,n,m;
    public static int[] p = new int[N];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            p[i] = Integer.parseInt(str[i]);
        }
        int res = 0;
        for (int i = 1; i < 1 << m; i++) {
            int t = 1;
            int s = 0;
            for (int j = 0; j < m; j++) {
                if (((i>>j) & 1) == 1){
                    if((long)t*p[j] > n){
                        t = -1;
                        break;
                    }
                    s++;
                    t *= p[j];
                }

            }
            if(t == -1)continue;
            if ((s&1) == 1) res += n/t;
            else res -= n/t;
        }

        writer.write(res+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
