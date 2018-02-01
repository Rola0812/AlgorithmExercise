package ZuoshenAlgorithm.Section5.Zifuchuantiaozheng10;

public class SolutionBuchong {

    public void modify(char[] chas){
        if(chas == null || chas.length == 0){
            return;
        }
        int j = chas.length-1;
        for(int i = chas.length-1;i>=0;i--){
            if (chas[i] != '*') {
                chas[j--] = chas[i];
            }
        }
        for(int k = j;k>=0;k--){
            chas[k]='*';
        }

    }

    public static void main(String[] args) {
        SolutionBuchong solutionBuchong = new SolutionBuchong();
        solutionBuchong.modify(new char[]{'1','2','*','*','3','4','5'});
    }
}
