package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class Test22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n,ans,0,0,"");
        return ans;
    }
    void dfs(int n,List<String> ans,int left,int right,String str){
        if(right+left == n*2){
            ans.add(str);
            return;
        }
        if (left>right){
            if(left<n) {
                str = str + "(";
                dfs(n,ans,left+1,right,str);
                str = str.substring(0,str.length()-1);
            }
            if (right<n){
                str = str + ")";
                dfs(n,ans,left,right+1,str);
                str = str.substring(0,str.length()-1);
            }
        }else {
            if(left<n) {
                str = str + "(";
                dfs(n,ans,left+1,right,str);
                str = str.substring(0,str.length()-1);
            }
        }
    }
}
