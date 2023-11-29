package Maths;
//https://www.youtube.com/watch?v=fzip9Aml6og&t=2374s TimeSkip:2.00.16 (Question15 & Question 16)

public class RangeOfXOR {
    public static void main(String[] args) {
        int a = 3;
        int b = 9;
        int ans = xor(b) ^ xor(a-1); //(Q:16) 2.03.50
        System.out.println(ans);
    }
    private static int xor(int a){
        return switch (a % 4) { //follows a pattern (Q:15)
            case 0 -> a;
            case 1 -> 1;
            case 2 -> a + 1;
            case 3 -> 0;
            default -> -1;
        };
    }
}
