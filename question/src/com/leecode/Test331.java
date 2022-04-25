package com.leecode;

public class Test331 {
    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        int n = ss.length;
        int in = 0, out = 0;
        for (int i = 0; i < n; i++) {
            if (!ss[i].equals("#")) out += 2;
            if (i != 0) in++;
            if (i != n - 1 && out <= in) return false;
        }
        return in == out;

    }
}
