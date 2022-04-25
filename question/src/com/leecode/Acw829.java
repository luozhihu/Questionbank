package com.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acw829 {
    static int N = 1000000;
    static int[] arr = new int[N];
    static int tail = -1, top = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        while (m-- > 0){
            String[] str = reader.readLine().split(" ");
            if(str[0].equals("push")){
                push(Integer.parseInt(str[1]));
            }else if(str[0].equals("pop")){
                pop();
            }else if(str[0].equals("empty")){
                if(empty()){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }else if(str[0].equals("query")){
                System.out.println(query());
            }
        }

    }
    public static void push(int x){
        tail++;
        arr[tail] = x;
    }
    public static void pop(){
        top++;
    }
    public static boolean empty(){
        return top > tail;
    }
    public static int query(){
        return arr[top];
    }
}
