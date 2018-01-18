package DynamicProgramming.packet01;

public class packet01 {

    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = BackPack_Solution(m, n, w, p);
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=m; j++) {
                System.out.print(c[i][j]+"\t");
                if(j==m){
                    System.out.println();
                }
            }
        }
    }

    private static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {

        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n+1][m+1];

        //初始化第一行和第一列
        for(int i=0;i<n+1;i++){
            c[i][0] = 0;
        }
        for(int j=0;j<m+1;j++){
            c[0][j] = 0;
        }

        for(int i= 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(w[i-1]<=j){
                    if(c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1])){
                        //放，物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    }else {
                        //不放，物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                        c[i][j] = c[i - 1][j];
                    }
                }else {
                    c[i][j] = c[i-1][j];
                }
            }
        }
        return c;
    }
}
