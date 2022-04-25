package com.leecode;

public class Test371 {
    public static void main(String[] args) {

    }
    public static int getSum(int a,int b){
        int ans = 0;
        int u1,u2, t = 0;
        for (int i = 0; i < 32; i++) {
            u1 = (a >> i) & 1;
            u2 = (b >> i) & 1;
            if(u1 == 1 && u2 == 1){
                ans |= (t << i);
                t = 1;
            }else if(u1 == 1 || u2 == 1){
                ans |= ((1 ^ t) << i);
            }else {
                ans |= (t << i);
                t = 0;
            }
        }
        return ans;
    }
}
