package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:54.00 (Question6)
// to Reset the ith bit of the given number
// create a mask value of left shifted '1' i-1 times and take the complement of the mask value and AND with the num
public class Reset_ith_bit {
    public static void main(String[] args) {
        int num = 6;
        int i = 2;
        //int mask = ~(1<<i-1);
    System.out.println(num&(~(1<<(i-1))));
    }
}
