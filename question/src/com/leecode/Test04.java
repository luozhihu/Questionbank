package com.leecode;

public class Test04 {
    public static void main(String[] args) {
        int[] nums1 = {1,3},nums2 = {2,7};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length,m = nums2.length;
        int k = m + n >> 1;
        int left = find(nums1,nums2,0,0,k);
        int right = find(nums1,nums2,0,0,k+1);
        return (double) (left+right) / 2.0;
    }
    //寻找两个有序数组第k大的数
    private static int find(int[] nums1, int[] nums2, int i, int j, int k) {
        int n = nums1.length,m = nums2.length;
        //保证nums1的剩余量大于nums2
        if (n-i<m-j) return find(nums2,nums1,j,i,k);
        if (j>=m) return nums1[i+k-1];
        //由于else里是让r加上向上取整的数，避免取不到j+1的情况发生
        if (k==1) return nums1[i] > nums2[j] ? nums2[j] : nums1[i];
        else {
            //分别对 k/2 向上取整和向下取整。
            int si = i+k-(k/2), sj = Math.min(m-1,j+k/2);
            if (nums1[si-1]<=nums2[sj-1]) return find(nums1,nums2,si,j,k-(si-i));
            else return find(nums1,nums2,i,sj,k-(sj-j));
        }
    }
}
