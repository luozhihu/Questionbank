package com.leecode;

public class Acw650 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(minSteps(n));

    }
    public static int minSteps(int n) {
        int ans = 0;
        for(int i = 2; i*i <= n;i++){
            while (n % i == 0){
                ans += i;
                n /= i;
            }
        }
        if(n != 1) ans += n;
        return ans;
    }
}
