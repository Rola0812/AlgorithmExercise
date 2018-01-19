package Wangyi;


import java.util.Scanner;

public class Jiaocuo01chuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] inputChar = input.toCharArray();
        int res = 1;
        int maxres = res;
        for(int i = 0;i<input.length()-1;i++){
            if((inputChar[i]+inputChar[i+1])=='1'+'0'){
                res++;
                if(res>maxres){
                    maxres = res;
                }
            }else {
                res = 1;
            }

        }


            System.out.println(maxres);

    }
}
