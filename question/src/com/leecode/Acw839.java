package com.leecode;

import java.io.*;

public class Acw839 {
    public static int[][] p = new int[10010][10010];
    public static int[] ad = new int[10010];
    public static int size;
    public static int index;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        while (n-->0){
            str = reader.readLine().split(" ");
            if(str[0].equals("I")){
                insert(Integer.parseInt(str[1]));
            }else if (str[0].equals("PM")){
                //System.out.println(getmin());
                writer.write(""+getmin());
                writer.write("\n");
                writer.flush();
            }else if (str[0].equals("DM")){
                delmin();
            }else if (str[0].equals("D")){
                del_k(Integer.parseInt(str[1]));
            }else if (str[0].equals("C")){
                update(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
            }
        }
        writer.close();
        reader.close();
    }
    public static void insert(int x){
        index++;
        ++size;
        p[0][size] = x;
        p[1][size] = index;
        ad[index] = size;
        up(size);
    }
    public static int getmin(){
        return p[0][1];
    }
    public static void delmin(){
        p[0][1] = p[0][size];
        p[1][1] = p[1][size];
        ad[p[1][1]] = 1;
        size--;
        down(1);
    }
    public static void del_k(int k){
        p[0][ad[k]] =  p[0][size];
        p[1][ad[k]] = p[1][size];
        int t = ad[k];
        ad[p[1][ad[k]]] = ad[k];
        size--;
        down(t);
    }
    public static void update(int k, int x){
        p[0][ad[k]] = x;
        down(ad[k]);
        up(ad[k]);
    }
    public static void up(int x){
        int t = x;
        if (t/2 > 0 && p[0][t/2] > p[0][t]) x = t/2;
        if(t != x) {
            p[0][x] = p[0][x] + p[0][t];
            p[0][t] = p[0][x] - p[0][t];
            p[0][x] = p[0][x] - p[0][t];

            p[1][x] = p[1][x] + p[1][t];
            p[1][t] = p[1][x] - p[1][t];
            p[1][x] = p[1][x] - p[1][t];

            ad[p[1][x]] = x;
            ad[p[1][t]] = t;
            up(x);
        }
    }
    public static void down(int x){
        int t = x;
        if(t * 2 <= size && p[0][t * 2] < p[0][t]) x = t * 2;
        if(t * 2 + 1 <= size && p[0][t * 2 + 1] < p[0][t * 2]) x = t * 2 + 1;
        if(t != x) {
            p[0][x] = p[0][x] + p[0][t];
            p[0][t] = p[0][x] - p[0][t];
            p[0][x] = p[0][x] - p[0][t];

            p[1][x] = p[1][x] + p[1][t];
            p[1][t] = p[1][x] - p[1][t];
            p[1][x] = p[1][x] - p[1][t];
            ad[p[1][x]] = x;
            ad[p[1][t]] = t;
            down(x);
        }
    }
}
