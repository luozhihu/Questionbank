package com.leecode;

import java.util.Arrays;

public class Test881 {
    public static void main(String[] args) {
        int[] people = {3,5,3,4};
        System.out.println(numRescueBoats(people,5));
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0,j = n-1;
        int count = 0,ans=0;
        while (people[j]==limit){
            j--;
            count++;
            ans++;
        }
        while (i<j){
            while (people[i]+people[j]>limit&&i<j){
                j--;
            }
            if (i<j&&people[i]+people[j]<=limit){
                count += 2;
                i++;
                j--;
                ans++;
            }
        }
        ans = n-count + ans;
        return ans;
    }
}
