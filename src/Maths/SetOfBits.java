package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:1.51.49 (Question14)
// find the number of ones ( set bits ) in a number
public class SetOfBits {
    public static void main(String[] args) {
        int num = 4;
        System.out.println(Integer.toBinaryString(num));

        System.out.println(setbits(num));
        System.out.println(setbits2(num));
        System.out.println(setbits3(num));
    }
    private static int setbits3(int n) {
        int count = 0;
        while(n>0){
            count++;
            n = (n & n-1);
        }
        return count;
    }

    private static int setbits2(int n) {
        int count = 0;
        while(n>0){
            count++;
            n -= (n & -n);
        }
        return count;
    }

    private static int setbits(int n) {
        int count = 0;
        while(n>0){
            if((n & 1) == 1)
                count++;
            n = n>>1;
        }
        return count;
    }
}
//choose any method
