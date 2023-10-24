package LeetCode;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年10月05日 2:02 PM
 */
public class _34_Find1stAndLastElement {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        int mid = -1;
        int low=0;
        int high= nums.length-1;

        if(nums.length==0){
            return new int[]{-1,-1};
        }

        //if nums[mid] < targer,
        //move low to mid+1, else move high to mid
        //in this step, we will find first element in an array(if there is one)
        while(low<high){
            mid = low+high >>> 1;
            if(nums[mid]<target){
                low = mid+1;
            } else {
                high = mid;
            }
        }

        if(nums[low]!=target){
            return new int[]{-1,-1,};
        }

        int[] res = new int[2];
        res[0]=low;
        high = nums.length-1;
        while(low<high){
            mid = (low+high >>> 1)+1;
            if(nums[mid]>target){
                high = mid-1;
            } else {
                low= mid;
            }
        }
        res[1]=high;
        return res;

    }
}
