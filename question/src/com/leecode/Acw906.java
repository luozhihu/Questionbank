package com.leecode;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Acw906 {
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
        Arrays.sort(nums,(a, b)->{return a[0] - b[0];});
        //System.out.println(Arrays.deepToString(nums));
        int ans = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 >= o2 ? 1 : -1;
            }
        });
        for (int i = 0; i < n; i++) {
            if (maxHeap.isEmpty()){
                maxHeap.offer(nums[i][1]);
                ans++;
            }else if (maxHeap.peek()<nums[i][0]){
                maxHeap.poll();
                maxHeap.offer(nums[i][1]);
            }else if(maxHeap.peek()>=nums[i][0]){
                //maxHeap.clear();
                maxHeap.offer(nums[i][1]);
                ans++;
            }
        }
        writer.write(ans+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
