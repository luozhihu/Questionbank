package com.leecode;

import java.io.*;

public class Acw837 {
    static int N = 100010;
    static int[] p = new int[N];
    static int[] count = new int[N];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]),m=Integer.parseInt(str[1]);
        while (n>0){
            p[n] = n;
            count[n] = 1;
            n--;
        }
        while (m-->0){
            str = reader.readLine().split(" ");
            if (str[0].equals("C")){
                if(find(Integer.parseInt(str[1]))!=find(Integer.parseInt(str[2]))) {
                    count[find(Integer.parseInt(str[2]))] += count[find(Integer.parseInt(str[1]))];
                    p[find(Integer.parseInt(str[1]))] = find(Integer.parseInt(str[2]));
                }
            }else if (str[0].equals("Q1")){
                if(find(Integer.parseInt(str[1]))==find(Integer.parseInt(str[2])))
                    //writer.write("Yes");
                    System.out.println("Yes");
                else
                    //writer.write("No");
                    System.out.println("No");
                //writer.write("\n");
            }else if (str[0].equals("Q2")){
                //writer.write(count[find(Integer.parseInt(str[1]))]);
                //writer.write("\n");
                System.out.println(count[find(Integer.parseInt(str[1]))]);
            }
        }
    }
    public static int find(int x){
        if(p[x] != x) return find(p[x]);
        return x;
    }
}
