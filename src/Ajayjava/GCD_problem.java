package Ajayjava;

public class GCD_problem {
    int GCD(int a,int b){
        if(b == 0)
            return a;
        return GCD(b,a%b);
    }

    public static void main(String[] args) {
        GCD_problem obj = new GCD_problem();
        System.out.println(obj.GCD(199,20));
    }
}
