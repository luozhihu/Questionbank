package com.leecode;

import java.util.LinkedList;
import java.util.List;

public class Test728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)){
                ans.add(i);
            }
        }
        return ans;
    }
    boolean check(int num){
        for (int i = num%10; num>0 ; num /= 10) {

            if (i == 0||num%i!=0){
                return false;
            }
        }
        return true;
    }
}
