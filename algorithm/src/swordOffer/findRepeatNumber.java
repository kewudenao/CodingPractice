package swordOffer;


import java.util.HashMap;
/**找出数组中重复的数字。
*在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
* 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */

public class findRepeatNumber {
    public int methodOne(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        while( i < nums.length ){
            if (map.containsKey(nums[i]) ) return nums[i];
            map.put(nums[i],1);
            i++;
        }
        return -1;
    }

    // 思路在于 nums 中的元素均小于 nums.length
    // 所以  nums[i] 中元素值的位置应该为 nums[nums[i]] = nums[i];
    // 将 nums[i] 和 i 两个元素值的位置做交换  循环
    //直到找到重复的值
    public int methodTwo(int[] nums){
        int i = 0;
        while(i<nums.length){
            if(nums[i]==i){
                i++;
                continue;
            }
            if(nums[nums[i]]==nums[i]) return nums[i];
            int temp = nums[i];
            nums[i]=nums[temp];
            nums[temp]=temp;
        }
        return -1;
    }
}
