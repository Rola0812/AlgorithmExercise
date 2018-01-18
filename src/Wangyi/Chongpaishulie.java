package Wangyi;

import java.util.Scanner;

public class Chongpaishulie {

    public static void main(String[] args) {
        int t;
        int n;
        int num4;
        int num;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int i = 0;i<t;i++){
            n = sc.nextInt();
            num4 = 0;
            num = 0;
            for(int j = 0;j<n;j++){
                int temp = sc.nextInt();
                if(temp%4 == 0){
                    num4++;
                }
                else {
                    num++;
                }
            }
            if(num<=num4+1)
                System.out.println("Yes");

            else
                System.out.println("No");
        }

    }
}
