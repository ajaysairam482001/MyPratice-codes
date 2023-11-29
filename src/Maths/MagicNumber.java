package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:1.23.00 (Question9)(amazon)
public class MagicNumber {
    public static void main(String[] args) {
        int n = 5;
        int ans = 0;
        int base = 5;
        while(n>0){
            int last = n&1;
            n = n>>1;
            ans += last*base;
            base = base * 5;
        }
        System.out.println(ans);
    }
}
//refer video

//and also Question 10 -> to find the number of digits of a number in base 2
//
//formula-> int(log n)(base)+1
//base->2(binary)
//try it out in calci
//code: int ans = (int)(Math.log(n) / Math.log(b)) + 1;