package Search_sort;

import virtusa.poly.Main;

//https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/09-patterns.md
public class Patterns {
    public static void main(String[] args) {
        int n = 5;
        pattern31(n);
    }
    static void pattern31(int n){
        int N = n*2-1;//5
        for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){
                int left = col;
                int right = (N-1)-col;
                int up = row;
                int down = (N-1)-row;
                System.out.print((Math.max(Math.max(left,right), Math.max(up,down)))-4+" ");
            }
            System.out.println();
        }
    }
    static void pattern8(int n){
        for(int i=0;i<n;i++) {
            int spaces = n-i-1;
            for (int col = 0; col < spaces; col++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i+1); j++) {
                System.out.print("*");
            }
            for(int j = 0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern11(int n){
        for(int i=0;i<n;i++) {
            int spaces = i;
            for (int col = 0; col < spaces; col++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - spaces; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern7(int n){
        for(int i=0;i<n;i++) {
            int spaces = i;
            for (int col = 0; col < spaces; col++) {
                System.out.print("  "); //remove one space and it turns into an equilateral triangle
            }
            for (int j = 0; j < n - spaces; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern10(int n){
        for(int i=0;i<n;i++) {
            int spaces = n - i - 1;
            for (int col = 0; col < spaces; col++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - spaces; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for(int i=0;i<n;i++) {
            int spaces = n - i - 1;
            for (int col = 0; col < spaces; col++) {
                System.out.print("  "); //remove one space and it turns into an equilateral triangle
            }
            for (int j = 0; j < n - spaces; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        int temp = n;
        for(int i=0;i<=n*2-1;i++){
            int col = i<n ? i:temp--;
            for(int j=0;j<col;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
