package virtusa;
import java.util.*;
//This program is to remove unwanted spaces.
public class WhiteSpace {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String blogName = in.nextLine();

        String str = blogName.replaceAll("\\s+", " ");
//        "\\s+": This is a regular expression pattern. In regular expressions, \\s represents any whitespace character (spaces, tabs,
//        line breaks, etc.),and + means "one or more times". So, \\s+ matches one or more whitespace characters.
//
//        " ": This is the replacement string. It's what the matched patterns (whitespace
//        characters) will be replaced with. In this case, it's a single space.

        System.out.println( str.trim() );
    }
}
