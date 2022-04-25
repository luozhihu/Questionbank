package com.leecode;

import java.io.*;

public class Acw877 {
    public static int x=0,y=0;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int a,b;
        while (n-->0){
            str = reader.readLine().split(" ");
            a=Integer.parseInt(str[0]);
            b=Integer.parseInt(str[1]);
            exgct(a,b);
            writer.write(x + " " + y + "\n");
            writer.flush();

        }
        writer.close();
        reader.close();
    }
    public static int exgct(int a,int b){
        if (b == 0){
            x = 1;
            y = 0;
            return a;
        }
        int d;
        d = exgct(b,a%b);
        int tmp = x;
        x = y;
        y = tmp - a/b*y;
        return d;
    }
}
