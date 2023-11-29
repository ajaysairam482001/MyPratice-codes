package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:33.05 (Question1)
//given number find whether its Even or Odd
//12 in base 2 is -> 1100
//7 in base 2 is-> 0111
//12+7=19 -> 10011(which is base 2 of 19)
// if last digit is 0 it is even else it is Odd
public class OddOrEven {
    public static void main(String[] args) {
        int n = 7;
        if((n&1) == 1)
            System.out.println("odd");
        else
            System.out.println("even");

    }
}
