package Maths;
//https://www.youtube.com/watch?v=lmSpZ0bjCyQ&t=2617s (40.00)
public class BinarySearchSQRT {
    public static void main(String[] args) {
        int n = 40;
        int p = 3;
        System.out.println(bsSQRT(n,p));
        System.out.printf("pretty printing: %.3f",bsSQRT(n,p));
    }

    static double bsSQRT(int n,int p){
        int s = 0;
        int e = n;
        double root = 0.0;
        int m = 0;
        while(s<=e){
            m = s + (e-s)/2;
            if(m*m>n)
                e = m-1;
            else if(m*m == n)
                return m;
            else
                s = m+1;
        }

        double inc = 0.1;
    for(int i=0;i<p;i++){
        while(root*root<=n){
            root += inc;
        }
        root -=inc;
        inc /= 10;
    }
    return root;
    }
}
