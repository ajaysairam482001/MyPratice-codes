package virtusa;
//balls of challenge
import java.util.Scanner;

public class string10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        String c = "";
        int l = a.length();
        int t = 1;
        for(int i = 0;i<l;i++){
            if(a.charAt(i) == b.charAt(i)){
                if(a.charAt(i) == 'W')
                    c += 'B';
                else if(a.charAt(i) == 'B')
                    c += 'W';
            }
            else{
                if(t%2==1)
                    c += 'W';
                else
                    c += 'B';
            }
            t++;
        }
        System.out.println(c);
    }
}
// o/p BBBW  (testcase)
//     BWBB
//output : WBWB
