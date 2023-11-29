package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:1.42.07 (Question12)
public class PowerOfTwo {
    public static void main(String[] args) {
        int num = 17;
        boolean ans = (num & (num-1)) == 0;
        System.out.println(ans);
    }
}
// 4 = 100
// 3 =  11 (4-1)
//AND=  0   so 4 is a power of two
