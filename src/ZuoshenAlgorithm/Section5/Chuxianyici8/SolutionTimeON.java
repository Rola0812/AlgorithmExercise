package ZuoshenAlgorithm.Section5.Chuxianyici8;

public class SolutionTimeON {

    public boolean isUnique(char[] chas){
        if(chas == null){
            return true;
        }
        int[] map = new int[256];
        for(int i = 0;i<chas.length;i++){
            if(++map[chas[i]]>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolutionTimeON solutionTimeON = new SolutionTimeON();
        System.out.println(solutionTimeON.isUnique(new char[]{'1','2','3'}));
    }

}
