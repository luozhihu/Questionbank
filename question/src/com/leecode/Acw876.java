package com.leecode;

import java.io.*;

public class Acw876 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        while (n-->0){
            int a,p;
            str = reader.readLine().split(" ");
            a= Integer.parseInt(str[0]);
            p = Integer.parseInt(str[1]);
            if(a%p == 0) {
                writer.write("impossible\n");
            }else {
                writer.write(qmi(a,p-2,p)+"\n");
            }
            writer.flush();
        }
        writer.close();
        reader.close();
    }
    public static long qmi(int a,int b, int p){
        long res = 1;
        long c = a;
        while (b>0){
            if((b&1)==1){
                res = res * c % p;
            }
            c = c * c % p;
            b>>=1;
        }
        return res;
    }
}
