package LeetCode.dynamicProgramming;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年04月13日 11:51 AM
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = climbStairs(4);
        System.out.println(n);
    }

    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }

        int prev = 2;
        int pPrev =1;
        for(int i=3;i<=n;i++){
            int curr = prev + pPrev;
            pPrev = prev;
            prev= curr;
        }
        return prev;
    }
}
