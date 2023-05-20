package LeetCode.dynamicProgramming;

/**
 * @Description: TODO
 * @author: Wei Liang
 * @date: 2023年05月19日 2:02 PM
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp  =new int[m][n];
        //set destination as 1, meaning there is 1 way to get to the destination
        dp[m-1][n-1] = 1;

        //start from last row, last col
        for(int i =m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){

                //find its right and down blocks
                int right = j+1;
                int down = i+1;

                //if right and down blocks is out of range, and 0 to current path.
                if(right==n){
                    dp[i][j]= dp[i][j] +0;
                }
                if(down == m){
                    dp[i][j] = dp[i][j] +0;
                }

                //if not, add right and down way to current path
                if(right!=n){
                    dp[i][j] = dp[i][j] + dp[i][j+1];
                }
                if(down!=m){
                    dp[i][j] = dp[i][j] + dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
