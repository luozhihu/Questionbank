package com.leecode;

import java.io.*;

public class Acw867 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void divide(int x) throws IOException{
        for (int i = 2; i < x / i; i++) {
            if(x % i == 0){
                int s = 0;
                while (x % i == 0){
                    x = x/i;
                    s++;
                }
                writer.write(i+" "+s+"\n");
                writer.flush();
            }
        }
        if(x > 1){
            writer.write(x+" "+1);
            writer.flush();
        }
    }

    public static void main(String[] args) throws IOException{
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        while (n-->0){
            str = reader.readLine().split(" ");
            int i = Integer.parseInt(str[0]);
            divide(i);
            writer.write("\n");
            writer.flush();
        }
        reader.close();
        writer.close();
    }
}
