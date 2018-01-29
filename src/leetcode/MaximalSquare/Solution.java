package leetcode.MaximalSquare;

public class Solution {

    public int maximalSquare(char[][] a){
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        //b[i][j]代表在以i，j为右下角的正方形边长
        //如果这一格的值也是1，那这个正方形的边长就是他的上面，左手边，和斜向上的值的最小边长+1，如果有一边短了缺了，就构不成正方形
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        Solution solution = new Solution();
        System.out.println(solution.maximalSquare(matrix));
    }
}
