package flowcontrol;

import java.util.Scanner;

public class prblm_13 {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the range: ");
        int st = in.nextInt();
        int end = in.nextInt();
        for (int j = st; j <= end; j++) {
            int isPrime = 1;
            for (int i = 2; i <= j / 2; i++) {
                if (j == 2)
                    break;
                if (j % i == 0) {
                    isPrime = 0;
                    break;
                }
            }
            if (isPrime == 1)
                System.out.println(j);
        }
    }
}
