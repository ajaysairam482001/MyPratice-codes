package virtusa.MultiThreading;

import java.util.*;

class Stall implements Runnable{
    private String sn;
    private String d;
    private double sa;
    private String ow;
    private double sc;

    public Stall(String sn,String d,double sa,String ow){
        this.sn = sn;
        this.d = d;
        this.sa = sa;
        this.ow = ow;
    }

    public String getsn(){
        return sn;
    }
    public void setsn(String sn){
        this.sn = sn;
    }
    public String getd(){
        return d;
    }
    public void setd(String d){
        this.d = d;
    }
    public double getsa(){
        return sa;
    }
    public void setsa(double sa){
        this.sa = sa;
    }
    public String getow(){
        return ow;
    }
    public void setow(String ow){
        this.ow = ow;
    }
    public double getsc(){
        return sc;
    }
    public void setsc(double sc){
        this.sc = sc;
    }
    @Override
    public void run(){
        sc = sa*150;
    }
}
class Q_1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numS = in.nextInt();
        Stall[] stall = new Stall[numS];
        Thread[] th = new Thread[numS];
        for(int i=0;i<numS;i++){
            in.nextLine();
            String sn = in.nextLine();
            String d = in.nextLine();
            double sa = in.nextDouble();
            String ow = in.next();
            stall[i] = new Stall(sn,d,sa,ow);
            th[i] = new Thread(stall[i]);
        }
        for(int i=0;i<numS;i++){
            th[i].start();
        }
        for(int i = 0;i<numS;i++){
            try{
                th[i].join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        double tr = 0;
        for(int i = 0;i<numS;i++){
            System.out.print(stall[i].getsc()+"\n");
            tr += stall[i].getsc();
        }
    }
}
//Testcase
//3
 //       Book Stall
 //       Stall for Books
 //       25
  //      john
 //       Food Stall
 //       Stall for thini
 //       60
 //       Peter
 //       Snack Stall
 //       Stall for kalaan
 //       30
 //       bhai
  // op-  3750.0
  //      9000.0
 //       4500.0