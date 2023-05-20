package LeetCode.dynamicProgramming;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年05月19日 10:09 PM
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //set destination as 1, meaning there is 1 way to get to the destination
        dp[m - 1][n - 1] = 1;

        if(obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        //start from last row, last col
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                //find its right and down blocks
                int right = j + 1;
                int down = i + 1;

                //if not, add right and down way to current path
                if (right != n && obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j] + dp[i][j + 1];
                }
                if (down != m && obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j] + dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}