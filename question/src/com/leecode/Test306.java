package com.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test306 {
    public static void main(String[] args) {
        String num = "112358";
        isAdditiveNumber(num);
    }
    public static boolean isAdditiveNumber(String num) {
        int n = num.length();
        List<Integer> list = new ArrayList<>();
        return dfs(num,list,0);
    }

    private static boolean dfs(String num, List<Integer> list,int i) {
        if (i == num.length()&&list.size()>=3){
            return true;
        }
        for (int j = 1; j+i <= num.length(); j++) {
            if (i+j<num.length()&&num.charAt(i+j)-'0'==0) continue;
            String cur = num.substring(i,j+i);
            if (list.size()<2){
                list.add(Integer.parseInt(cur));
            }else {
                if (list.get(list.size()-1)+list.get(list.size()-2)==Integer.parseInt(cur)) list.add(Integer.parseInt(cur));
                else continue;
            }
            if (dfs(num,list,j)){
                return true;
            }else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
