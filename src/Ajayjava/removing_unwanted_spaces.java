package Ajayjava;
import java.util.Scanner;

public class removing_unwanted_spaces {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder result = new StringBuilder();
        boolean isSpace = true; // Initialize as true to handle leading spaces

        for (char ch : str.toCharArray()) {
            if (ch != ' ') {
                result.append(ch);
                isSpace = false;
            } else {
                if (!isSpace) {
                    result.append(ch);
                    isSpace = true;
                }
            }
        }

        if (isSpace) {
            result.deleteCharAt(0); // Remove leading space, if any
        }

        System.out.println(result.toString());
    }
}
