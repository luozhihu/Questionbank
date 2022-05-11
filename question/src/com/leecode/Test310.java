package com.leecode;

import java.util.*;

public class Test310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int flag[] = new int[n];
        for (int i = 0; i < n-1; i++) {
            int x1 = edges[i][0];
            int x2 = edges[i][1];
            Set set = map.getOrDefault(x1,new HashSet<>());
            set.add(x2);
            map.put(x1,set);
            Set set2 = map.getOrDefault(x2,new HashSet<>());
            set2.add(x1);
            map.put(x2,set2);
        }
        int min = n;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(flag,0);
            int heigh = dfs(map,i,flag);
            if(heigh<min) {
                ans.clear();
                min = heigh;
            }
            if (heigh==min) ans.add(i);
        }
        return ans;
    }

    private int dfs(Map<Integer, Set<Integer>> map, int i, int[] flag) {
        flag[i] = 1;
        int len = 0;
        if(map.containsKey(i))
            for (int x : map.get(i)) {
                if (flag[x] == 0)
                    len = Math.max(dfs(map,x, flag)+1,len);
            }
        return len;
    }
}
