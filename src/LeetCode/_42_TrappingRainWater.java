package LeetCode;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年10月05日 4:20 PM
 */
public class _42_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(height));

    }


    /**
     * solution 1
     * 思路:
     * 把每一个index看成一个水桶,水桶能装多少水取决于这个index之前的最大值和之后的最大值,取小的那个值-index的值
     * ex: 1,3,2,0,1,5
     * index3能装3个水,因为index3之前的最大值是3,之后的最大值是5,Min(3,5)-0
     *
     *
     * 需要:
     * 2个额外的数组,用来存储每个index的pre和suf的最大值
     *
     * time:O(n), space:O(n)
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int[] preMax = new int[height.length];
        int[] sufMax = new int[height.length];
        int max = 0;
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if(max<height[i]){
                max = height[i];
            }
            preMax[i] = max;
        }

        max=0;
        for (int i = height.length-1; i >=0; i--) {
            if(max<height[i]){
                max = height[i];
            }
            sufMax[i] = max;
        }
        System.out.println(Arrays.toString(preMax));
        System.out.println(Arrays.toString(sufMax));

        for (int i = 0; i < height.length; i++) {
            int currVal = Math.min(preMax[i],sufMax[i])-height[i];
            res = res+currVal;
        }
        return res;
    }

    /**
     * maintain 2pointer instead array
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int l=0;
        int r= height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while(l<=r){
            if(leftMax<rightMax){
                //when is this condition, that means there is a right max is greater then leftMax
                //so we only focus on leftMax
                //if the leftMaxt - height[l] has a positive value that means it can contain the water
                //if do not have a positive value, which cannot store the water, but may update the leftMax
                //next, we move l to the right
                res = res+ ((leftMax-height[l]) > 0? leftMax-height[l]: 0);
                leftMax = Math.max(leftMax,height[l]);
                l++;
            } else if(rightMax<=leftMax) {
                //same as the other condition
                res = res+ ((rightMax-height[r]) > 0? rightMax-height[r]: 0); //
                rightMax = Math.max(rightMax,height[r]);
                r--;
            }
        }
        return res;

    }


}
