package swordOffer;

import java.util.ArrayList;

public class twoSum {
    //自己的方法
    public int[] methodOne(int[] nums, int target) {
        int i=0,j=nums.length-1,mid;
        while(nums[j]>target&&j>i) j--;
        while(i<j){
            while((target-nums[j]>nums[i])&&j>i) i++;
            if(nums[i]+nums[j]==target)
                return new int[]{nums[i],nums[j]};
            j--;
        }

        return new int[]{};
    }
    public int[] methodTwo(int[] nums, int target) {
        int i=0,j=nums.length-1,sum;
        while(i<j){
            sum = nums[i]+nums[j];
            if(sum>target)j--;
            else if(sum<target)i++;
            else
                return new int[]{nums[i],nums[j]};
        }
        return new int[0];
    }
}
