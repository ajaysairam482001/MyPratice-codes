package Maths;
//https://www.youtube.com/watch?v=lmSpZ0bjCyQ&t=2617s (53.00)
public class NetwonSQRT {
    public static void main(String[] args) {
        int num = 6;
        System.out.println(sqrt(121));
    }
    static double sqrt(double n){
        double x = n; //(x-> guess value)
        double root;
        while(true){
            root = 0.5 * (x + (n/x)); //formula

            if(Math.abs(root-x)<1) //condition check (<1 is for the accuracy level can also put .1,.2,.0001)
                break;
            x=root; // update the guess value
        }
        return root;
    }
}
