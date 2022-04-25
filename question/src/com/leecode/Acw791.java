package com.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Acw791 {
    public static void main(String[] args) throws IOException{
        List<Integer> C;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        int[] A = new int[str1.length()];
        int[] B = new int[str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            A[str1.length()-i-1] = str1.charAt(i) - '0';
        }
        for (int i = 0; i < str2.length(); i++) {
            B[str2.length()-i-1] = str2.charAt(i) - '0';
        }
        C = add(A,B);
        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print(C.get(i));
        }
    }
    public static List<Integer> add(int[] A, int[] B){
        if(A.length<B.length) return add(B,A);
        List<Integer> C = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.length; i++) {
            t =t + A[i];
            if(i<B.length) t += B[i];
            C.add(i,t%10);
            t /= 10;
        }
        if(t == 1)
        {
            C.add(A.length,t);
        }
        return C;
    }
}
