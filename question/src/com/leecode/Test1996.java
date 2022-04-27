package com.leecode;

import java.util.Arrays;
import java.util.Comparator;

public class Test1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        int count = 0;
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return o2[0]-o1[0];
                }
            }
        });
        int maxdef=properties[0][1];
        for(int n = 0; n<properties.length;n++){
            if(maxdef<=properties[n][1]){
                maxdef = properties[n][1];
            }else {
                count++;
            }
        }
        return count;
    }
}
