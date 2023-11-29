package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:53.00 (Question5)
// to set the ith bit of the given number
// create a mask value of left shifted '1' i-1 times and OR with the num
public class Set_ith_bit {
    public static void main(String[] args) {
        int num = 6;
        int i = 1;
        System.out.println(num|(1<<(i-1)));
    }

}
