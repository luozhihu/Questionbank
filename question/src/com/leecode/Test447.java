package com.leecode;

import java.util.HashMap;
import java.util.Map;

public class Test447 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        System.out.println(numberOfBoomerangs(points));
    }
    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(i == j) continue;
                int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
                int dist = x * x + y * y;
                map.put(dist,map.getOrDefault(dist,0)+1);
            }
            for(int dist : map.keySet()){
                int cnt = map.get(dist);
                count += cnt*(cnt-1);
            }
            map.clear();
        }
        return count;
    }
}
