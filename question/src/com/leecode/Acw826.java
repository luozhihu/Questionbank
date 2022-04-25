package com.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acw826 {
    static int N = 100000;
    static int[] value = new int[N];
    static int[] next = new int[N];
    static int head = -1;
    static int index = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        while (m > 0){
            m--;
            String[] act;
            act = reader.readLine().split(" ");
            if(act[0].toCharArray()[0] == 'H'){
                headInsert(Integer.parseInt(act[1]));
            }else if(act[0].toCharArray()[0] == 'I'){
                Insert(Integer.parseInt(act[1]),Integer.parseInt(act[2]));
            }else if(act[0].toCharArray()[0] == 'D'){
                Delete(Integer.parseInt(act[1]));
            }
        }
        int t = head;
        while (t != -1){
            System.out.print(value[t]+" ");
            t = next[t];
        }
    }
    public static void headInsert(int x){
        value[index] = x;
        next[index] = head;
        head = index;
        index++;
    }
    public static void Insert(int k,int x){
        value[index] = x;
        next[index] = next[k];
        next[k] = index;
        index++;
    }
    public static void Delete(int k){
        if(k == 0){
            head = next[head];
        }
        next[k] = next[next[k]];
    }

}
