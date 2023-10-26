package Ajayjava;

import java.util.Scanner;
//Enter password: password
//InValid
public class Password_ValidityCheck {

    public static boolean isValid(String password)
    {
        if (!((password.length() > 8)
                && (password.length() < 31))) {
            return false;
        }

        // to check space
        if (password.contains(" ")) {
            return false;
        }
        if (true) {
            int count = 0;


            for (int i = 0; i <= 9; i++) {

                // to convert int to string
                String str1 = Integer.toString(i);

                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }

        // for special characters
        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|"))) {
            return false;
        }
        if(password.contains("password") || password.contains("passWord") || password.contains("PASSWORD")||
        password.contains("Password")||password.contains("pAssword")||password.contains("paSsword")||
                password.contains("pasSword")||password.contains("passwOrd")||password.contains("passwoRd")||password.contains("passworD")){
                return false;
        }
        if (true) {
            int count = 0;

            // checking capital letters
            for (int i = 65; i <= 90; i++) {

                // type casting
                char c = (char)i;

                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }

        if (true) {
            int count = 0;


            for (int i = 97; i <= 122; i++) {

                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);

                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }


        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password1 = in.nextLine();

        if (isValid(password1)) {
            System.out.println("Valid");
        }
        else {
            System.out.println("InValid");
        }


    }
}
