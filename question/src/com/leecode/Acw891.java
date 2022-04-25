package com.leecode;

import java.io.*;

public class Acw891 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        str = reader.readLine().split(" ");
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res^Integer.parseInt(str[i]);
        }
        if(res>0) writer.write("Yes");
        else writer.write("No");
        writer.flush();
        writer.close();
        reader.close();
    }
}
