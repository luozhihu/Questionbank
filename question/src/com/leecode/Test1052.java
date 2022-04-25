package com.leecode;

public class Test1052 {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers,grumpy,minutes));

    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int i = 0,j=0;
        int count = 0;
        int scount = 0;
        int all = 0;
        while (j<minutes){
            count += customers[j];
            if (grumpy[j] == 0) {
                scount += customers[j];
                all += customers[j];
            }
            j++;
        }
        int max = 0;
        max = Math.max(max,count-scount);
        while (j<n){
            count -= customers[i];
            if (grumpy[i] == 0)
                scount -= customers[i];
            i++;
            if (j<n){
                count += customers[j];
                if (grumpy[j] == 0) {
                    scount += customers[j];
                    all += customers[j];
                }
            }else {
                break;
            }
            j++;
            max = Math.max(max,count-scount);
        }
        return all+max;
    }
}
