package virtusa.MultiThreading;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
class Q_6{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] att = new int[n];
        for(int i = 0;i<n;i++){
            att[i] = in.nextInt();
        }
        int threshold = 100;
        AtomicInteger win = new AtomicInteger();
        Thread t1 = new CountT(att,0,n/2,threshold,win);
        Thread t2 = new CountT(att,n/2,n,threshold,win);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Winners : "+win.get());
    }
}
class CountT extends Thread{
    private int[] att;
    private int s;
    private int e;
    private int threshold;
    private AtomicInteger win;

    public CountT(int[] att,int s,int e, int threshold,AtomicInteger win){
        this.att = att;
        this.s = s;
        this.e= e;
        this.threshold = threshold;
        this.win = win;
    }
    public void run(){
        for(int i =s;i<e;i++){
            if(att[i]==threshold){
                win.incrementAndGet();
            }
        }
    }
}
