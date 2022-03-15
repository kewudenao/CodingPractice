package swordOffer;
//统计一个数字在排序数组中出现的次数。
public class search {
    /**
     *  方法：二分查找
     *  i 为左边界 j 为右边界
     *  nums[mid] > target 让 右边界左移  j = mid +1
     *  nums[mid] < target 让 左边界右移  i = mid +1
     *  nums[mid] = target 分情况讨论
     *   查找右边界 i = mid +1
     *   查找左边界 j = mid -1
     * @param nums
     * @param target
     * @return
     */
    int methodOne(int[] nums,int target){
        int i = 0 ,j = nums.length;
        while (i<=j){
            int mid = (i+j)/2;
            if(nums[mid]<=target){
                i = mid+1;
            }else
                j=mid-1;
        }
        int right = i;
        i = 0;j=nums.length;
        while (i <= j) {
            int mid = (i+j)/2;
            if(nums[mid]<target){
                i = mid+1;
            }else
                j = mid-1;
        }
        int left = j;
        int[][] b;

        return right-left-1;
    }

}
