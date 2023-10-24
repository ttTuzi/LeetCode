package LeetCode;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年10月16日 2:55 PM
 */
public class _66_plusOne {
    public static void main(String[] args) {

    }

    /**
     * {1,2,3,4} -> {1,2,3,5}
     * {2,3,9,9} -> {2,4,0,0}
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0; i--) {
            if(digits[i]<9){
                digits[i] +=1;
                return digits;
            }else{
                digits[i]=0;
            }
        }

        int[] res = new int[digits.length+1];
        res[0]=1;
        return res;
    }
}
