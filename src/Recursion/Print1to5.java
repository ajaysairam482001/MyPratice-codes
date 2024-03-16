package Recursion;

public class Print1to5 {
    public static void print(int num){ //print 1 to n
        if(num == 0){
            return;
        }
        print(num-1);
        System.out.println(num);
    }

    public static void print2(int num){ //print n to 1
        if(num == 0){
            return;
        }
        System.out.println(num);
        print2(num-1);
    }

    public static void main(String[] args) {
        print2(5);
    }
}
