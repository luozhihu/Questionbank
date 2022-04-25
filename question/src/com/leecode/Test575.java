package com.leecode;

import java.io.*;

public class Test575 {
    //public static int N = 210010;
    //public static int[] candies = new int[N];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int[] candies = new int[n];
        str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            candies[i] = Integer.parseInt(str[i]);
        }

        writer.write(distributeCandies(candies)+"");
        writer.flush();
        writer.close();
        reader.close();
    }
    public static int distributeCandies(int[] candyType) {
        int[] mm = new int[200000];
        int count = 0;
        int l = candyType.length;
        for (int i = 0; i < l; i++) {
            int t = (candyType[i]+100000)%200000;
            if (mm[t] == 0){
                count++;
                mm[t]=1;
            }
        }
        if (count>=l/2){
            return l/2;
        }else {
            return count;
        }


    }

    /*
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) set.add(i);
        return Math.min(candyType.length / 2, set.size());
    }*/

}
