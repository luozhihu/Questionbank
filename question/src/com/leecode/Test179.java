package com.leecode;

import java.util.Arrays;
import java.util.Comparator;

public class Test179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        //把int数组转化成Strin数组，因为int数组比较器不能重写
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        //重写比较器后排序
        Arrays.sort(ss,(a,b)->{
            String sa = a+b, sb = b+a;
            return sb.compareTo(sa);
        });
        String ans = "";
        for (int i = 0; i < n; i++) {
            ans += ss[i];
        }
        int len = ans.length();
        //去除前导0
        int k = 0;
        while (k < len - 1 && ans.charAt(k) == '0') k++;
        return ans.substring(k);
    }
}
