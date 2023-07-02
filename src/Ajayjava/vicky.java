package Ajayjava;

import java.util.Scanner;

public class vicky {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int[][] mat1=new int[row][col];
        int[][] mat2=new int[row][col];
        int[][] sum=new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat1[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat2[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                sum[i][j]=mat1[i][j] + mat2[i][j];
                System.out.print(sum[i][j]+" ");
            }
            System.out.println(" ");
        }


    }
}
//{1,2,7,5,4}
//find the least number and sell for the higest number and calculate the profit