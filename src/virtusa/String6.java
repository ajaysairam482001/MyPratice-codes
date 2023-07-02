package virtusa;
import java.util.*;

public class String6 {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String line = scanner.nextLine();
            if (line.equals("q")) {
                break;
            }
            lines.add(line);
        }

        String text = "";
        for (String line : lines) {
            text += line + "\n";
        }
        int lineCount = countLines(text);
        System.out.println(lineCount);
    }

    public static int countLines(String text) {
        int lineCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                lineCount++;
            }
        }
        return lineCount;
}
}

