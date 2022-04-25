package com.leecode;

import java.io.*;
import java.util.Arrays;

public class Acw905 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            str = reader.readLine().split(" ");
            nums[i][0] = Integer.parseInt(str[0]);
            nums[i][1] = Integer.parseInt(str[1]);
        }
        Arrays.sort(nums,(a,b)->{return a[1] - b[1];});
        //System.out.println("a:"+Arrays.deepToString(nums));
        int count = 1;
        int p = 0;
        for (int i = 1; i < n; i++) {
            if (nums[p][1]<nums[i][0])
            {
                p = i;
                count++;
            }
        }
        writer.write(count+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
