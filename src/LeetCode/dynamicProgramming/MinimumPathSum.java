package LeetCode.dynamicProgramming;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年05月19日 4:41 PM
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {

                //find its right and down blocks
                int right = j + 1;
                int down = i + 1;

                if (right != n && down != m) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
                }
                else if (down != m) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                }
                else if(right != n){
                    dp[i][j] =grid[i][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
