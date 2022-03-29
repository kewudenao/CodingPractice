package swordOffer;

import java.util.Arrays;

public class isStraight {
    /**
     *  想清楚几件事情：
     *  1.题目表达的是什么意思？
     *  2.题目要获得什么样的结果
     *  3.获得结果的方式有没有优化的途径
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums){
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<4;i++){
            if(nums[i]==0) count++;
            else if (nums[i]==nums[i+1]) return false;
        }
        return  nums[4]-nums[count]>5;
    }
}
