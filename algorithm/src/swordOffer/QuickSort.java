package swordOffer;

import java.util.Arrays;

public class QuickSort {
    /*
        快速排序的核心是哨兵机制
        哨兵机制：选定一个元素，一般是第一个元素，将大于它的元素放在数组的左边
        小于它的元素放在数组的右边，此时数组被分成两部分 ，大于num[0] 、小于nums[0]
        递归迭代这个过程直到边界为1；
     */
    void quickSort(String[] nums,int l,int r){
        if(l>=r) return;
        int i =l,j=r;
        String tmp = nums[i];
        while (i<j){
            while ((nums[j]+nums[l]).compareTo(nums[l]+nums[j])>=0&&i<j) j--;
            while ((nums[i]+nums[l]).compareTo(nums[l]+nums[i])<=0&&i<j) i++;
             tmp = nums[i];
             nums[i]=nums[j];
             nums[j]=tmp;
        }
        nums[i] = nums[l];
        nums[l] = tmp;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }

    public String methodOne(int[] nums){
        String[] str = new String[nums.length];
        for(int i = 0;i< nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(x, y)->
            (x+y).compareTo(y+x)
        );
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i< str.length;i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
