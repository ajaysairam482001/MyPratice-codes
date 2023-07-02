package virtusa;
import java.util.*;

public class WhiteSpace {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String blogName = in.nextLine();

        String str = blogName.replaceAll("\\s+", " ");

        System.out.println( str.trim() );
    }
}
