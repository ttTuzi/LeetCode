package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年10月26日 11:28 AM
 */
public class _27_RemoveElement {
    public static void main(String[] args) {
        int[] test = {3,2,2,3};
        int val = 3;
        removeElement(test,val);
    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //count the number that num[i]!=val
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }

        }
        System.out.println(j);
        System.out.println(Arrays.toString(nums));
        return j;
    }
}
