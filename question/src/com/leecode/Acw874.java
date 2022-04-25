package com.leecode;

import java.io.*;

public class Acw874 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        writer.write(get_oulasum(n)+"");
        writer.flush();
        writer.close();
        reader.close();

    }
    public static long get_oulasum(int n){
        int[] st = new int[n+1];
        int[] primes = new int[n+1];
        int count = 0;
        int[] phi = new int[n+1];
        phi[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(st[i] == 0) {
                primes[count++] = i;
                phi[i] = i - 1;
            }
            for (int j = 0; i <= n / primes[j]; j++) {
                st[i*primes[j]] = 1;
                if(i%primes[j] == 0) {
                    phi[i*primes[j]] = phi[i] * primes[j];
                    break;
                }
                phi[i*primes[j]] = phi[i] * (primes[j] - 1);
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans + phi[i];
        }
        return ans;
    }
}
