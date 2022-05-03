package com.leecode;

public class Test1414 {
    public int findMinFibonacciNumbers(int k) {
        int a = 1,b = 1;
        int ans = 0;
        //寻找到斐波那契数列中第一个大于等于k的数
        while(b < k){
            b = a + b;
            a = b - a;
        }
        //如果k大于0那么继续寻找小于等于k的斐波那契数
        while(k>0){
            //寻找小于等于k的斐波那契数
            while(b>k){
                a = b - a;
                b = b - a;
            }
            //进行减操作
            while(b<=k){
                k -= b;
            }
            //没寻找到一个数，ans++
            ans++;
        }
        return ans;
    }
}
