package com.leecode;

import java.io.*;
import java.util.Arrays;

public class Acw907 {
    public static int N = 100010;
    public static int[][] a = new int[N][2];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int star = Integer.parseInt(str[0]), end = Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        for (int i = 0; i < n; i++) {
            str = reader.readLine().split(" ");
            a[i][0] = Integer.parseInt(str[0]);
            a[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(a,0,n,(b,c)->{return b[0]-c[0];});
        int t = star;
        int count = 0;

        for (int i = 0; i < n; i++) {
            while (i<n&&a[i][0] <= star)
            {
                if (a[i][1]>t){
                    t = a[i][1];
                }
                i++;
            }
            if (t>star){
                count++;
                star = t;
                i--;
            }
            if (t>=end){
                break;
            }

        }
        if (star < end)
            count = -1;
        writer.write(count+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
