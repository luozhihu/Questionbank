package com.leecode;

public class Test1423 {
    public static void main(String[] args) {

    }
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += cardPoints[i];
        }
        int sum = ans;
        for (int i = k-1,j = n-1; i >= 0 ; i--,j--) {
            sum = sum - cardPoints[i] + cardPoints[j];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
