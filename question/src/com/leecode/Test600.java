package com.leecode;

public class Test600 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(findIntegers(n));
    }
    public static int findIntegers(int n) {
        String num = "";
        while (n>0){
            int a;
            a = n%2;
            n /= 2;
            num = a + num;
        }
        System.out.println(num);
        int[][] f = new int[num.length()+1][2];
        f[1][0]=f[1][1]=1;
        for (int i = 2; i <= num.length(); i++) {
            f[i][0] = f[i-1][0]+f[i-1][1];
            f[i][1] = f[i-1][0];
        }
        int res = 0;
        for(int i = 0, last = 0;i<num.length();i++){
            if(num.charAt(i) == '1'){
                res += f[num.length()-i][0];
                if(last == '1') return res;
            }
            last = Integer.valueOf(num.charAt(i));
        }
        return res + 1;
    }
}
