package com.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acw828 {
    static int[] stack = new int[1000000];
    static int top = -1;
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
                if (empty()) {
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
        stack[++top] = x;
    }
    public static int pop(){
        return stack[top--];
    }
    public static boolean empty(){
        return top == -1;
    }
    public static int query(){
        return stack[top];
    }
}
