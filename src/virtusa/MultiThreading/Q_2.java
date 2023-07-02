package virtusa.MultiThreading;

import java.util.*;
class MatMul{
    static int[][] mat1,mat2,result;
    static int r1,r2,c1,c2;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        r1 = in.nextInt();
        c1 = in.nextInt();
        r2 = in.nextInt();
        c2 = in.nextInt();

        mat1 = new int[r1][c1];
        mat2 = new int[r2][c2];
        for(int i = 0;i<r1;i++){
            for(int j =0;j<c1;j++){
                mat1[i][j] = in.nextInt();
            }
        }
        for(int i = 0;i<r2;i++){
            for(int j = 0;j<c2;j++){
                mat2[i][j]= in.nextInt();
            }
        }
        if(c1 != r2){
            System.out.println("Error");
            return;
        }
        result = new int[r1][c2];

        int numT = r1*c2;
        MulT[] threads = new MulT[numT];
        int threadCount = 0;
        for(int i = 0;i<r1;i++){
            for(int j = 0;j<c2;j++){
                threads[threadCount] = new MulT(i,j);
                threads[threadCount].start();
                threadCount++;
            }
        }

        for(int i=0;i<numT;i++){
            try{
                threads[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        for(int i = 0;i<r1;i++){
            for(int j = 0;j<c2;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class MulT extends Thread{
    int r,c;
    public MulT(int r,int c){
        this.r = r;
        this.c = c;
    }
    @Override
    public void run(){
        for(int k =0;k<MatMul.c1;k++)
            MatMul.result[r][c]+=MatMul.mat1[r][k]*MatMul.mat2[k][c];
    }
}