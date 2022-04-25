package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class Test352 {
    List<int[]> list = new ArrayList<>();
    public void addNum(int val) {
        int l = 0,r = list.size()-1;
        while (l<r){
            int mid = l + r + 1 >> 1;
            if (list.get(mid)[0]<=val){
                l = mid;
            }else {
                r = mid - 1;
            }
        }

    }
}
