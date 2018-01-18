package DynamicProgramming.huobi;

public class huobi {

    public static void main(String[] args) {

        int[] arr = {5,10,25,1};
        int aim = 1000;

        int c[][] = huobi_Solution(arr,0,aim);

        for(int i = 0;i<4;i++){
            for(int j = 0;j<=aim;j++){
                System.out.print(c[i][j]+"\t");
                if(j==aim){
                    System.out.println();
                }
            }
        }

    }

    private static int[][] huobi_Solution(int[] arr,int index,int aim){

        if(arr == null || aim<0 ||arr.length == 0){
            return null;
        }
        //dp[n][m]为使用前n中货币凑成的m的种数
        int dp[][] = new int[arr.length][aim+1];

        for(int i = 0;i<arr.length;i++){
            dp[i][0]=1;
        }
        for(int i = 1;arr[0]*i<=aim;i++){
            dp[0][arr[0]*i] = 1;
        }


        for(int i = 1;i<arr.length;i++){
            for(int j = 1;j<=aim;j++){
                int num = 0;
                for(int k = 0;j-k*arr[i]>=0;k++){
                    num += dp[i-1][j-k*arr[i]];
                }
                dp[i][j] = num;
            }
        }
        return dp;


       /* for(int i = 1;i<5;i++){
            for(int j = 0;j<aim+1;j++){
                if(j>=arr[i-1]){//j比i的面值大
                    //System.out.println("i="+i+",j="+j);
                    //不使用第i种，则方法有dp[i-1][j]种，使用第i种，则方法有dp[i][j-arr[i]]种
                    dp[i][j] = dp[i-1][j]+dp[i][j-arr[i-1]];
                }else{
                    //j比i的面值小，那只能不使用第i种
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp;*/
    }
}
