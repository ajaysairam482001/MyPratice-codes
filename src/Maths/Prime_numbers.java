package Maths;
//https://www.youtube.com/watch?v=lmSpZ0bjCyQ&t=2617s (10.50)
public class Prime_numbers {
    public static void main(String[] args) {
        int num = 7;
        Prime_numbers obj = new Prime_numbers();
        System.out.println(obj.isPrime(num));
    }
    public boolean isPrime(int n){ //most optimize way to find prime for now
        if(n<=1)
            return false;
        int c=2;
        while(c*c <=n ){
            if(n % c == 0)
                return false;
            c++;
        }
        return true;
    }
}
