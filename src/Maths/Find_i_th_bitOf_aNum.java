package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:49.50 (Question4)
// to find the ith bit of the given number
// create a mask value of left shifted '1' i-1 times and AND with the num
public class Find_i_th_bitOf_aNum {
    public static void main(String[] args) {
        int num = 6;
        int i = 2;
        System.out.println(ans(num,i));
    }
    private static int ans(int num,int i){
        if((num&(1<<(i-1))) == 0)
            return 0;
        else
            return 1;
    }
}
