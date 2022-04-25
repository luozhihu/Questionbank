package com.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Acw830 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        int[] arr = new int[m];
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < m; j++) {
            if(stack.empty()){
                System.out.print("-1"+" ");
                stack.push(arr[j]);
            }else {
                while (!stack.empty() && stack.peek() >= arr[j]){
                    stack.pop();
                }
                if(stack.empty()) {
                    System.out.print("-1" + " ");
                }else {
                    System.out.print(stack.peek() + " ");
                }
                stack.push(arr[j]);
            }
        }
    }
}
