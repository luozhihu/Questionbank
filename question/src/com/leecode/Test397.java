package com.leecode;

import java.util.HashMap;
import java.util.Map;

public class Test397 {
    public int integerReplacement(int _n) {
        long n = _n;
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n >>= 1;
            } else {
                //如果+1或-1之后可以被2整除则操作
                if (n != 3 && ((n >> 1) & 1) == 1) n++;
                else n--;
            }
            ans++;
        }
        return ans;
    }
}
