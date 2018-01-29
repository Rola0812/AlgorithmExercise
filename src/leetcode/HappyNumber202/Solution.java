package leetcode.HappyNumber202;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    int sumOfSquares(int n) {
        int sum = 0;

        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set= new HashSet<>();

        while(!set.contains(n)) {
            if(n == 1)
                return true;
            set.add(n);
            n = sumOfSquares(n);
        }

        return false;
    }

//    public boolean isHappy(int n){
//        Set<Integer> inLoop = new HashSet<Integer>();
//        int squareSum,remain;
//        while (inLoop.add(n)) {
//            squareSum = 0;
//            while (n > 0) {
//                remain = n;
//                squareSum += remain*remain;
//                n /= 10;
//            }
//            if (squareSum == 1)
//                return true;
//            else
//                n = squareSum;
//
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));

    }
}
