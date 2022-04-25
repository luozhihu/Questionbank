package com.leecode;

public class Test434 {
    public static void main(String[] args) {
        String str = "a, b, c";
        System.out.println(countSegments(str));

    }
    public static int countSegments(String s) {
        int ans = 0, t = 0;
        int n = s.length();
            for (int i = 0; i < n; i++) {
                if(s.charAt(i) != ' '){
                    t = 1;
                }
                if (s.charAt(i) == ' ') {
                    if (t == 1) {
                        ans++;
                        t = 0;
                    }
                    while (i < n && s.charAt(i) == ' '){
                        i++;
                    }
                }
            }
            return ans + t;
    }
}
