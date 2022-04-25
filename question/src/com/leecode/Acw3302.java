package com.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Acw3302 {
    static Stack<Integer> num_stack = new Stack<>();
    static Stack<Character> op_stack = new Stack<>();
    static Map<Character,Integer> h = new HashMap<>();
    public static void main(String[] args) throws IOException{
        h.put('+', 1);
        h.put('-', 1);
        h.put('*', 2);
        h.put('/', 2);
        h.put('(', 0);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //Stack<Integer> num_stack = new Stack<>();
        //Stack<Character> op_stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int x = 0, j = i;//计算数字
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9')
                {
                    x = x * 10 + s.charAt(j) - '0';
                    j++;
                }
                num_stack.push(x);
                i = j - 1;
            }else if(s.charAt(i) == '('){
                op_stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                while (op_stack.peek() != '('){
                    eval();
                }
                op_stack.pop();
            }else {
                while (op_stack.size() > 0 && h.get(op_stack.peek()) >= h.get(s.charAt(i))){
                    eval();
                }
                op_stack.push(s.charAt(i));
            }
        }
        while (op_stack.size() > 0)
            eval();
        System.out.println(num_stack.pop());
    }
    public static void eval(){
        int a = num_stack.peek();
        num_stack.pop();
        int b = num_stack.peek();
        num_stack.pop();
        char p = op_stack.peek();
        op_stack.pop();
        int r = 0;
        if (p == '+') r = b + a;
        if (p == '-') r = b - a;
        if (p == '*') r = b * a;
        if (p == '/') r = b / a;
        num_stack.push(r);
    }
}
