package com.leecode;

import java.util.HashMap;
import java.util.Map;

public class Test397 {
    Map<Long, Integer> map = new HashMap<>();
        public int integerReplacement(int n) {
        return dfs(n*1L);
    }
    int dfs(long n){
        if (n==1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int ans;
        if (n%2==0){
                 ans = dfs(n/2)+1;
            }else {
                ans =  1+Math.min(dfs(n+1),dfs(n-1));
            }
        map.put(n, ++ans);
        return ans;
    }
}
