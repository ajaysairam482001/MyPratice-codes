import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner in = new Scanner(System.in);
        System.out.print("enter a number : ");
        int range = in.nextInt();
        for(int i=0;i<=range;i++){
            System.out.println(i);
        }
    }
}
