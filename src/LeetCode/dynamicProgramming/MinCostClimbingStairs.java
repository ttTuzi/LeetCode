package LeetCode.dynamicProgramming;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年04月13日 12:03 PM
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int solution = minCostClimbingStairs(cost);
        System.out.println(solution);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}
