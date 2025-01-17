package LeetCode;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年09月29日 12:12 PM
 */
public class _26_RemoveDuplicateFromSortArray {
    public static void main(String[] args) {
        int[] num = {0,0,1,1,1,2,2,3,3,4};

        removeDuplicates(num);
    }

    public static int removeDuplicates(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return 1;
        }

        //if first element not equal to next element, then store the first element to index result, then result+=1
        //not consider the last element, because whether last element is equal or not, it will not store it the array
        //for example:  1,2,2,2,2
        //it will only store 1 in the loop
        //therefore we add last element manually
        int res = 0;git config --global --add safe.directory D:/LeetCode
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]!=nums[i+1]){
                nums[res]=nums[i];
                res++;
            }
        }
        nums[res] = nums[nums.length-1];
        res++;
        return res;
    }
}
