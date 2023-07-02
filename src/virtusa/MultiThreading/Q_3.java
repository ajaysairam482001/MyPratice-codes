package virtusa.MultiThreading;

import java.util.*;
import java.lang.*;
public class Q_3{//Q_3
    int c = 1;
    static int n;
    public void Odd(){
        synchronized(this){
            while(c<n){
                while(c%2==0){
                    try{
                        wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread Odd: "+c);
                c++;
                notify();
            }
        }
    }
    public void Even(){
        synchronized(this){
            while(c<n){
                while(c%2==1){
                    try{
                        wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread even: "+c);
                c++;
                notify();
            }
        }
    }
    public static void main(String[] args){
        n = 20;
        Q_3 m = new Q_3();
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                m.Even();
            }
        });
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                m.Odd();
            }
        });
        t1.start();
        t2.start();
    }
}
