package com.leecode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Test1221 {
    public int balancedStringSplit(String s) {
        int i = 0;
        int count = 0;
        char a = s.charAt(0);
        for(int j = 0;j < s.length();j++)
        {
            if (s.charAt(j) == a) {
                i++;
                if(i == 0){
                    count++;
                }
            } else {
                i--;
                if(i == 0){
                    count++;
                }
            }
        }
        return count;
    }
}