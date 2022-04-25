package com.leecode;

import java.util.*;

public class Test301 {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
                if (str[i] == ')') {
                    if (!deque.isEmpty()) {
                    if (deque.peekLast() == '(') {
                        deque.pollLast();
                    } else {
                        deque.addLast(str[i]);
                    }
                }else {
                        deque.addLast(str[i]);
                    }
            }
            if (str[i] == '(') deque.addLast(str[i]);
        }
        int count = deque.size();
        List<String> ans = new ArrayList<>();
        deque.clear();
        dfs(str,0,0,n-count,ans,"");
        Set<String> set = new HashSet<>();
        for (String str1 : ans) {
            set.add(str1);
        }
        ans.clear();
        for (String str1 :set) {
            ans.add(str1);
        }
        return ans;
    }
    void dfs(char[] str,int i,int count,int num,List<String> ans,String cur){
        if (count == num){
            if(check(cur)){
                ans.add(cur);
            }
            return;
        }
        if (i==str.length) return;
        if (str[i] == '('||str[i] == ')') {
            cur = cur + str[i];
            dfs(str, i + 1, count + 1,num, ans, cur);
            cur = cur.substring(0,cur.length()-1);
            dfs(str, i + 1, count,num, ans, cur);
        }else {
            cur = cur + str[i];
            dfs(str, i + 1, count+1,num, ans, cur);
        }
    }
    boolean check(String cur){
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < cur.length(); i++) {
            char ch = cur.charAt(i);
                if (ch == ')') {
                    if (!stack.isEmpty()) {
                        if (stack.peekLast() == '(') {
                            stack.pollLast();
                        } else {
                            stack.addLast(ch);
                        }
                    } else {
                        stack.addLast(ch);
                    }
                }
            if (ch == '(') stack.addLast(ch);
        }
        return stack.isEmpty();
    }

}
