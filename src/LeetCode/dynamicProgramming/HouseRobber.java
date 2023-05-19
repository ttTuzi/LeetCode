package LeetCode.dynamicProgramming;

import LeetCode.MaxSubArray;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年05月18日 12:56 AM
 */

/*
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length<=1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        // first house got rob
        int rob1 = 0;
        // second house got rob
        int rob2 = 0;
        //cost of current house is current house is current house + first house, or second house(1 previous house)
        for(int i = 0; i<nums.length;i++){
            dp[i] = Math.max(nums[i]+rob1,rob2);
            rob1 = rob2;
            rob2 = dp[i];
        }
//        return Math.max(dp[dp.length-1],dp[dp.length-2]);
        return rob2;
    }
}
