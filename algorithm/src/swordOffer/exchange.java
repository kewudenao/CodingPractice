package swordOffer;

public class exchange {
    //  思路正确，代码逻辑有待优化
    public int[] methOne(int[] nums) {
        int[] a =new int[]{1,2};
        int i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]%2==0){
                if(nums[j]%2==0){
                    j--;
                    continue;
                }
                if(nums[j]%2==1){
                    int tmp = nums[j];
                    nums[j]=nums[i];
                    nums[i]=tmp;
                    j--;
                    i++;
                    continue;
                }
            }
            if(nums[i]%2==1) i++;
        }
        return nums;
    }
    // 官方答案
    public int[] methodTwo(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j){
            while(i<j&&(nums[i]&1)==1) i++;
            while(i<j&&(nums[j]&1)==0) j--;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
