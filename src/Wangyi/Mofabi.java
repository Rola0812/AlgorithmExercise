package Wangyi;

import java.util.Scanner;

public class Mofabi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int objective = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(objective >=1) {
            if (objective % 2 == 0) {
                objective = (objective-2)/2;
                sb.insert(0,2);
            }else {
                objective = (objective-1)/2;
                sb.insert(0,1);
            }
        }
        System.out.print(sb.toString());

    }
}
