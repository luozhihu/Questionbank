package com.leecode;

import java.io.*;

public class Acw827 {
    static int N = 1000010;
    static int[] left = new int[N];
    static int[] right = new int[N];
    static int[] value = new int[N];
    static int index = 1;
    public static void main(String[] args) throws IOException{
        right[0] = 1000000;
        left[1000000] = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(reader.readLine());
        while (m > 0){
            m--;
            String[] str = reader.readLine().split(" ");
            if(str[0].equals("L")){
                headInsert(Integer.parseInt(str[1]));
            }else if(str[0].equals("R")){
                tailInsert(Integer.parseInt(str[1]));
            }else if(str[0].equals("D")){
                delete(Integer.parseInt(str[1]));
            }else if(str[0].equals("IL")){
                rightInsert(left[Integer.parseInt(str[1])],Integer.parseInt(str[2]));
            }else if(str[0].equals("IR")){
                rightInsert(Integer.parseInt(str[1]),Integer.parseInt(str[2]));
            }
        }
        int count = right[0];
        while (count != 1000000) {
            //writer.write(value[count]+'');
            System.out.print(value[count]+" ");
            count = right[count];
        }
    }
    public static void headInsert(int x){
        value[index] = x;
        right[index] = right[0];
        left[index] = 0;
        left[right[0]] = index;
        right[0] = index;
        index++;
    }
    public static void tailInsert(int x){
        value[index] = x;
        right[index] = 1000000;
        left[index] = left[1000000];
        right[left[1000000]] = index;
        left[1000000] = index;
        index++;
    }
    public static void delete(int k){
        right[left[k]] = right[k];
        left[right[k]] = left[k];
    }
    public static void rightInsert(int k,int x){
        value[index] = x;
        left[index] = k;
        right[index] = right[k];
        left[right[k]] = index;
        right[k] = index;
        index++;
    }
}
