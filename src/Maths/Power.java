package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:1.44.14 (Question13)
public class Power {
    public static void main(String[] args) {
        int base = 3;
        int power = 6;
        long ans = 1;

        while(power>0){
            if((power & 1) == 1){
                ans *= base;
            }
            base *= base;
            power = power >> 1;
        }
        System.out.println(ans);
    }
}
