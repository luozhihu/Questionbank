package com.leecode;

import java.util.Arrays;

public class Test881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0,j = n - 1;
        int ans = 0;
        while(i<=j){
            if(people[i]+people[j]<=limit) i++;
            ans++;
            j--;
        }
        return ans;

    }
}
