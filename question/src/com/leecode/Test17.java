package com.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test17 {
    public List<String> letterCombinations(String digits) {
        Map<Integer,char[]> map = new HashMap<>();
        map.put(2,new char[] {'a','b','c'});
        map.put(3,new char[] {'d','e','f'});
        map.put(4,new char[] {'g','h','i'});
        map.put(5,new char[] {'j','k','l'});
        map.put(6,new char[] {'m','n','o'});
        map.put(7,new char[] {'p','q','r','s'});
        map.put(8,new char[] {'t','u','v'});
        map.put(9,new char[] {'w','x','y','z'});
        int n = digits.length();
        char[] chars = digits.toCharArray();
        List<String> ans = new ArrayList<>();
        String str = "";
        add(map,digits,0,ans,n,str);
        return ans;
    }

    void add(Map<Integer,char[]> map,String digits,int i,List<String> ans,int n,String str){
        if (i==n){
            ans.add(str);
            return ;
        }
        for (int j = 0; j < map.get(digits.charAt(i)-'0').length; j++) {
            add(map,digits,i+1,ans,n,str+map.get(digits.charAt(i)-'0')[j]);
        }
    }
}
