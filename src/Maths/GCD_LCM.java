package Maths;

public class GCD_LCM {
    int GCD(int a,int b){
        if(b == 0)
            return a;
        return GCD(b,a%b);
    }
    int LCM(int a,int b){
        return (a*b)/GCD(a,b);
    }

    public static void main(String[] args) {
        GCD_LCM obj = new GCD_LCM();
        System.out.println(obj.GCD(10,20));
        System.out.println(obj.LCM(9,18));
    }
}
