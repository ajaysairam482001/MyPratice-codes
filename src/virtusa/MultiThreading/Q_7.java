package virtusa.MultiThreading;

import java.util.*;
import java.lang.*;
class R extends Thread{
    ArrayList<String> la = new ArrayList<String>();
    public ArrayList<String> getLa(){
        return la;
    }
    public void run(){
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        in.nextLine();
        for(int i = 0;i<n1;i++){
            String s = in.nextLine();
            char[] s2 = s.toCharArray();
            List<Character> chars = new ArrayList<Character>();
            for(char c : s2){
                chars.add(c);
            }
            Set<Character>charset = new LinkedHashSet<Character>(chars);
            Iterator<Character> hs = charset.iterator();
            while(hs.hasNext()){
                char k = hs.next();
                int count = 0;
                for(int j=0;j<s2.length;j++){
                    if(k==s2[j]){
                        count++;
                    }
                }
                la.add(k+""+count);
            }
            if(i==n1-1){
                for(int l=0;l<la.size();l++){
                    System.out.println(la.get(l));
                }
            }
            la.add("");
        }
    }
}
public class Q_7{
    public static void main(String args[]){
        R r = new R();
        System.out.print("\n");
        r.start();
    }
}
