package com.leecode;

import java.util.*;

public class Test502 {
//    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//        int n = capital.length;
//        List<int[]> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(new int[] {capital[i],profits[i]});
//        }
//        list.sort(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] > o2[0]){
//                    return 1;
//                }else if(o1[0] < o2[0]){
//                    return -1;
//                }else {
//                    return o1[1]-o2[1];
//                }
//            }
//        });
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        int count = 0;
//        int i = 0;
//        while(count<k){
//            while (i<n&&list.get(i)[0]<=w) queue.offer(list.get(i++)[1]);
//            w = w + queue.poll();
//            count ++;
//        }
//        return w;
//    }
public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int n = profits.length;
    int f[][] = new int[n][2];
    //把两个数组一一对应，存入二维数组
    for (int i = 0; i < n; i++) {
        f[i][0] = capital[i];
        f[i][1] = profits[i];
    }
    //安装投资升序排序
    Arrays.sort(f,(a,b)->{
        return a[0] - b[0];
    });
    int pre = 0;
    //默认为小根堆，我们需要大根堆，重写compare方法
    PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
        return b-a;
    });
    //pre记录当前可以做的最大投资的项目的下标
    for (; pre < n && f[pre][0] <= w; pre++) {
        queue.add(f[pre][1]);
    }
    int i = 0;
    //如果堆为空表示无项目可做，退出循环
    while (i<k&&!queue.isEmpty()){
        i++;
        //做完的项目需要从堆中移除
        w = w + queue.poll();
        for (; pre < n && f[pre][0] <= w; pre++) {
            queue.add(f[pre][1]);
        }
    }
    return w;
}
}
