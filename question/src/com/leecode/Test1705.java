package com.leecode;

import java.util.PriorityQueue;

public class Test1705 {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        //f[i]表示第i天过期的苹果剩余数量。
        int[] f = new int[40000];
        //max表示所有苹果过期的那天
        int max = n;
        //表示未过期苹果的剩余数量
        int num = 0;
        //吃到的苹果数
        int ans = 0;
        //优先队列默认是小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //从第0天开始，所有苹果过期结束
        for (int i = 0;i < max; i++) {
            int cnt=0;
            int d = 0;
            if (i<n) {
                cnt = apples[i];
                d = days[i];
            }
            f[i+d] += cnt;
            num += cnt;
            //如果有更晚过期的苹果则更新最晚过期时间
            if(i+d>max) max = i+d;
            //如果第i+d天没有加入到堆中，且该天的苹果大于0，则加入堆中
            if (!queue.contains(i+d)&&cnt>0)
                queue.add(i+d);
            //当第i天的到来时，把第i天过期的苹果丢弃
            if(!queue.isEmpty()&&i==queue.peek()) {
                num -= f[queue.poll()];
            }
            //如果未过期的苹果大于0，则吃到的苹果+1，剩余苹果减一
            if (num>0){
                ans++;
                num--;
                //如果最快过期的这天的水果数量为0，该天出站。
                if(--f[queue.peek()] == 0) queue.poll();
            }
        }
        return ans;
    }
}
