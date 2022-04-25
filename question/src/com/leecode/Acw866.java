package com.leecode;

import java.io.*;

public class Acw866 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        while (n-->0){
            str = reader.readLine().split(" ");
            int i = Integer.parseInt(str[0]);
            if (isp(i)){
                writer.write("Yes\n");
            }else {
                writer.write("No\n");
            }

            writer.flush();
        }
        writer.close();
        reader.close();

    }
    public static boolean isp(int x){
        if (x <= 1){
            return false;
        }
        for (int i = 2; i <= x /i; i++) {
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}
