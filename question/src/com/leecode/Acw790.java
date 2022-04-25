package com.leecode;

import java.util.Scanner;

public class Acw790 {
    static double x;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        x = scan.nextDouble();
        double l = -10000,r = 10000; //如果-1<x<1那么使用（0,x）将永远取不到答案。
        if (x >= 0)
            System.out.println(String.format("%.6f", bsearch_3(l, r))); // 保留 6位小数
        else
            System.out.println("-" + String.format("%.6f", bsearch_3(l, r)));
    }
    public static double bsearch_3(double l, double r){
        double eps = 1e-8;
        while (r-l>eps){
            double mid = (l+r)/2;
            if(check(mid)) r = mid;
            else l = mid;
        }
        return l;
    }
    public static boolean check(double y){
        if(y*y*y > Math.abs(x)){
            return true;
        }else {
            return false;
        }
    }
}
