package flowcontrol;

import java.util.*;
class Main{
    public static void main(String[]args){
        int a,b,c,t;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        a = (2*t)/7;
        b = (2*a);
        c = a/2;
        System.out.println("Number of attendees on day 1 : "+a);
        System.out.println("Number of attendees in day 2 : "+b);
        System.out.println("Number of attendees in day 3 : "+c);
    }
}
