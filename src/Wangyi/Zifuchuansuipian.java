package Wangyi;

import java.util.Scanner;

public class Zifuchuansuipian {

    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        String string=null;
        string=in.nextLine();
        char s=string.charAt(0);
        double count=1,d;
        for (int i = 0; i < string.length(); i++) {
            if (s!=string.charAt(i)) {
                s=string.charAt(i);
                count++;
            }
        }
        d=string.length()/count;
        System.out.println(String.format("%.2f", d));
    }
}
