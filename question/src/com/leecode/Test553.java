package com.leecode;

import java.util.Arrays;

public class Test553 {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        //先把所有的数字和符号/加上
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
            if (i + 1 < n) sb.append("/");
        }
        //然后在第二个数和最后一个数上加上括号
        if (n > 2) {
            sb.insert(sb.indexOf("/") + 1, "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
