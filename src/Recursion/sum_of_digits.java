package Recursion;

public class sum_of_digits {
    static int sumofdig(int n){ // sum of digits
        if(n%10 == n) {
            return n;
        }
        return (n%10) + sumofdig(n/10);
    }

    static int productsofdig(int n){ // product of digits
        if(n%10 == n) {
            return n;
        }
        return (n%10) * productsofdig(n/10);
    }
    public static void main(String[] args) {
        System.out.println(sumofdig(4325));
        System.out.println(productsofdig(4325));
    }
}
