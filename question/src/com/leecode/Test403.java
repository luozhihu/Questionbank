package com.leecode;

import java.util.HashMap;
import java.util.Map;

public class Test403 {
    Map<String,Boolean> map = new HashMap<>();
    public boolean canCross(int[] stones) {
        return bfs(0,0,stones);
    }
    boolean bfs(int i,int idx,int[] stones){
        String key = i + "_" + idx;
        if (idx == stones.length-1) return true;
        if (map.containsKey(key)) return map.get(key);
        boolean flag = false;
        for (int j = idx+1; j < stones.length; j++) {
            if (stones[j]>stones[idx]+i+1) break;
            if (stones[j]>=stones[idx]+i-1){
                flag = bfs(stones[j]-stones[idx],j,stones) || flag;
                if(flag == true) return flag;
            }
        }
        map.put(key,flag);
        return flag;
    }
}
