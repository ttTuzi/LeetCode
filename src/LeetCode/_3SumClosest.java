package LeetCode;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年04月12日 1:12 PM
 */
public class _3SumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                //calculate sum
                int sum = nums[i] + nums[j] + nums[k];
                //if sum = target return the sum
                if (sum == target) {
                    return sum;
                }

                //update the closest distance, while update the closest distance, also update the result
                int distance = Math.abs(target-sum);
                if(distance<close){
                    close=distance;
                    res = sum;
                }

                if(sum<target){
                    j++;
                }else{
                    k--;
                }

            }
        }
        return res;
    }
}
