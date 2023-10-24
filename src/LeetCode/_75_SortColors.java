package LeetCode;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年10月16日 5:20 PM
 */
public class _75_SortColors {
    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int[] count = {0,0,0};
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[j]=0;
            j++;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[j]=1;
            j++;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[j]=2;
            j++;
        }
    }
}
