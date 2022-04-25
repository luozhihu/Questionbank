package com.leecode;

import java.io.*;

public class Acw886 {
    static int N = 100010, p = (int) 1e9 + 7;
    static int[] fact = new int[N], infact = new int[N];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        fact[0] = infact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = (int) ((long)fact[i-1]*i%p);
            infact[i] = (int)((long)infact[i-1]*qmi(i,p-2,p)%p);
        }
        int t = Integer.parseInt(str[0]);
        while (t-- > 0) {
            str  = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int  res = (int)((long)fact[a]*infact[a-b]%p*infact[b]%p);
            writer.write(res+"\n");

        }
        writer.flush();
        writer.close();
        reader.close();
    }
    public static int qmi(int a,int k, int p){
        long res = 1;
        while (k > 0){
            if((k&1)==1){
                res = res * a % p;
            }
            a = (int)((long)a*a%p);
            k >>= 1;
        }
        return (int)res;
    }
}
