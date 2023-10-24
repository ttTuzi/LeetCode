package LeetCode;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年10月06日 12:13 PM
 */
public class _41_FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
        System.out.println(Arrays.toString(nums));
    }


    //pigeonhole problem
    public static int firstMissingPositive(int[] nums) {

        //keep the number in range of (1-nums.length)
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=0 || nums[i]> nums.length){
                nums[i]=0;
            }
        }



        for (int i = 0; i < nums.length; i++) {
            //swap util they are in correct position
            //for example(when i=0):
            // 3,4,2,0
            //2,4,3,0
            //4,2,3,0
            //0,2,3,4
            //called cyclic sort
            while(nums[i]!=0 && nums[i]!=i+1){
                if (nums[i] == nums[ (nums[i] - 1) ])break;
                swap(nums,nums[i]-1,i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return nums.length+1;
    }

    private static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
