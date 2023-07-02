package virtusa.MultiThreading;

import java.text.*;
import java.util.*;
class Item implements Runnable{
    private String n;
    private int p;
    private int q;
    private int d;
    private double ta;
    public void setn(String n){
        this.n = n;
    }
    public void setp(int p){this.p = p;}
    public void setq(int q){this.q = q;}
    public void setd(int d){this.d = d;}
    public double getta(){return ta;}
    @Override
    public void run(){
        this.ta = this.q*this.d;
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(this.ta));
    }
}
class Q_5{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = 0;
        try{
            num = in.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Invalid Input");
            return;
        }
        Thread[] th = new Thread[num];
        Item[] it = new Item[num];
        for(int i = 0;i<num;i++){
            in.nextLine();
            String n = in.nextLine();
            int p = 0;
            int q = 0;
            int d= 0;
            try{
                p = in.nextInt();
                q = in.nextInt();
                d= in.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Invalid Input");
                return;
            }
            it[i] = new Item();
            it[i].setn(n);
            it[i].setp(p);
            it[i].setq(q);
            it[i].setd(d);
        }
        for(int i =num-1;i>=0;i--){
            th[i] = new Thread(it[i]);
            th[i].start();
        }
        in.close();
    }
}

//2
//        Laptop
//        40000
//        30000
//        10
//        Mobile
//        25000
//        20000
//        20
//---------------------------------
//        400000.00
//        300000.00