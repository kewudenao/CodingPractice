package swordOffer;

public class maxSubArray {
    //输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
    class Solution {
        public int methodOne(int[] nums) {
            int sum = nums[0];
            int max = nums[0];
            for(int i=1; i< nums.length;i++){
                sum = Math.max(sum+nums[i],nums[i]);
                max = Math.max(sum,max);

            }
            return max;
        }
    }
}
