package virtusa;

import java.util.*;
public class chera_chola_pandya {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        String str1;
        ArrayList<String>l1 = new ArrayList<>();
        ArrayList<String>l2 = new ArrayList<>();
        ArrayList<String>l3 = new ArrayList<>();
        ArrayList<String>l4 = new ArrayList<>();
        ArrayList<String>l5 = new ArrayList<>();

        for(int i = 0;i<c;i++){
            //consuming the <enter> from input above
            in.nextLine();
            str1 = in.nextLine();
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            if(n1>0&&n2>0)
                l1.add(str1);
            else if(n1>0&&n2<0)
                l4.add(str1);
            else if(n1<0&&n2>0)
                l2.add(str1);
            else if(n1<0&&n2<0)
                l3.add(str1);
            else
                l5.add(str1);
        }
        System.out.println("chola");
        System.out.println(l1);
        System.out.println("chera");
        System.out.println(l2);
        System.out.println("pallava");
        System.out.println(l3);
        System.out.println("pandya");
        System.out.println(l4);
        System.out.println("renounce");
        System.out.println(l5);
    }
}
