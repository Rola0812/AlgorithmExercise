package ZuoshenAlgorithm.Section5.findString9;

public class Solution {

    public int getIndex(String[] strs,String str){
        if(strs == null || strs.length ==0 || str == null){
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = str.length()-1;

        int mid = 0;
        int i = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(strs[mid] != null && strs[mid].equals(str)){
                res = mid;
                right = mid-1;
            }else if(strs[mid] != null){
                if(strs[mid].compareTo(str)<0){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }else {
                i = mid;
                while(strs[i] == null && --i >=left);
                if(i<left || strs[i].compareTo(str)<0){
                    left = mid+1;
                }else {
                    res = strs[i].equals(str)?i:res;
                    right = i-1;
                }
            }
        }
        return res;
    }
}
