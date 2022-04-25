package com.leecode;

import java.io.*;

public class Acw872 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        while (n-- > 0){
            str = reader.readLine().split(" ");
            writer.write(gcd(Integer.parseInt(str[0]),Integer.parseInt(str[1]))+" ");
            writer.flush();
        }
    }
    public static int gcd (int a,int b){
        return b > 0 ? gcd(b,a%b) : a;

    }
}
