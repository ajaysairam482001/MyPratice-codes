package zoho;

import java.util.Scanner;

public class WhiteSpace_removal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.replaceAll("\\s+"," ");
        System.out.println(str.trim());
    }

}

//str = str.replaceAll("\\s+"," ");   //Line 9 is explained below.

//        "\\s+": This is a regular expression pattern. In regular expressions, \\s represents any whitespace character (spaces, tabs,
//        line breaks, etc.),and + means "one or more times". So, \\s+ matches one or more whitespace characters.
//
//        " ": This is the replacement string. It's what the matched patterns (whitespace
//        characters) will be replaced with. In this case, it's a single space.