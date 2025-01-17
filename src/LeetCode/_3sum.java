package LeetCode;

import java.util.*;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2022年12月09日 8:22 PM
 */
public class _3sum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(Integer[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //if 2 element are same, skip to next
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            //if least 3 smallest number is less than 0, than no such case can > 0
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            //if current i and 2 largest number < 0, then move to next i.
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                continue;
            }

            //前后指针
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);

                    //check if duplicate
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    //check if duplicate
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        List<List<Integer>> output = new ArrayList<>();
        output.addAll(ans);
        return output;
    }
}
