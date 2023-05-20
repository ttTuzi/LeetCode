package LeetCode.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年05月18日 11:36 PM
 */
public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        int i = deleteAndEarn(nums);
        System.out.println(i);
    }

    public static int deleteAndEarn(int[] nums) {
        //sort
        Arrays.sort(nums);

        HashMap<Integer,Integer> hashtable = new HashMap<>();

        int uniqueIndex = 0;

        hashtable.put(nums[0],1);
        for (int i = 1; i < nums.length; i++) {

            //store count of each number
            if(!hashtable.containsKey(nums[i])){
                hashtable.put(nums[i],1);
            }else {
                hashtable.put(nums[i],hashtable.get(nums[i])+1);
            }

            //remove duplicate
            if (nums[i] != nums[i-1]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        int[] newNums = Arrays.copyOf(nums, uniqueIndex + 1);

        int first = 0;
        int second = 0;
        int[] dp = new int[newNums.length];
        for(int i = 0;i< newNums.length;i++){
            //if current value equals previous value+1, then chosen between (current value + first value) or (second value)
            if(i!=0 && newNums[i]==newNums[i-1]+1){
                Integer amount = hashtable.get(newNums[i]);
                int value =  amount * newNums[i];
                dp[i] = Math.max(value+first,second);
                first = second;
                second = dp[i];
            }else {
                //if current value not equals previous value+1, then add (current value) and (second value)
                Integer amount = hashtable.get(newNums[i]);
                int value =  amount * newNums[i];
                dp[i] = second+value;
                first = second;
                second = dp[i];
            }
        }
        return second;
    }

}
