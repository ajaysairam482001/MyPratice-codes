package flowcontrol;

import java.util.Scanner;

public class prblm_8 {
    public static void main(String[]args){
                System.out.print("Enter the color code(In CAPS): ");
                Scanner in = new Scanner(System.in);
                char c1 = in.next().charAt(0);
                switch (c1) {
                    case 'R' -> System.out.println("R->Red");
                    case 'B' -> System.out.println("B->Blue");
                    case 'G' -> System.out.println("G->Green");
                    case 'O' -> System.out.println("O->Orange");
            case 'Y' -> System.out.println("Y->Yellow");
            case 'W' -> System.out.println("W->White");
            default -> System.out.println("Invalid code");
        }
    }
}
