package Recursion;

public class Print1to5 {
    public static void print(int num){
        if(num == 0){
            return;
        }
        print(num-1);
        System.out.println(num);
    }

    public static void main(String[] args) {
        print(5);
    }
}
