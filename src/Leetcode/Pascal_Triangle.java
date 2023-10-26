package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//https://leetcode.com/problems/pascals-triangle/   Qn:118
public class Pascal_Triangle {
    public List<List<Integer>> pascal(int numRows){
        List<List<Integer>> list = new ArrayList<>();  // create one to return
        if(numRows == 0){ // []
            return list;
        }
        for(int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i){ // first and last element of a row
                    row.add(1);
                }
                else{ // adding previous adjecnt elements
                    row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(row);
        }
        return list;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Pascal_Triangle obj = new Pascal_Triangle();
        System.out.print("Enter the number of rows: ");
        System.out.println(obj.pascal(in.nextInt()));
    }
}
