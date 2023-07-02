package virtusa.MultiThreading;
import java.util.*;
class HB implements Runnable{
    private String hn;
    private double c;
    private int hc;
    private int sb;

    public HB() { }

    public HB(String hn,double c,int hc,int sb){
        this.hn = hn;
        this.c = c;
        this.hc = hc;
        this.sb = sb;

    }
    public String gethn(){ return hn;}
    public void sethn(String hn){this.hn = hn;}
    public double getc(){return c;}
    public void setc(double c){this.c = c;}
    public int gethc(){return hc;}
    public void sethc(int hc){this.hc = hc;}
    public int getsb(){return sb;}
    public void setsb(int sb){this.sb = sb;}

    public void run(){
        if(sb*100>c){
            System.out.println("Profit");
        }else{
            System.out.println("Loss");
        }
    }
}
class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        HB[] book = new HB[n];
        Thread[] th = new Thread[n];

        for(int i = 0;i<n;i++){
            String hn = in.nextLine();
            double c = in.nextDouble();
            int hc = in.nextInt();
            int sb = in.nextInt();
            in.nextLine();
            book[i] = new HB(hn,c,hc,sb);
            th[i] = new Thread(book[i]);
            th[i].start();
        }
    }
}
