package main.java.easy;

import java.util.Arrays;

/**
 * @author lijx
 * @date 2019/2/22 - 10:20
 */
public class MissingNumber {
    public static  int missingNumber(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0,j=nums.length; true; ) {
            int middleIndex=(i+j-1)/2;
            int tmp=nums[middleIndex];
            if(tmp==middleIndex+nums[0]){
                if(i==middleIndex){
                    return nums[i]+1;
                }
                i=middleIndex;
            }else{
                j=middleIndex;
            }
        }
    }

    public static void main(String[] args) {
        int n[]={8,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(n));
    }
}
