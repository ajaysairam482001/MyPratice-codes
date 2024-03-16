package Recursion;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=9ByWqPzfXDU&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=35 (27.13)
//amazon question
public class Dice {
    public static void main(String[] args) {
        diceCombinattions("",4);
        //System.out.println(diceCombinattionsList("",4));
        //System.out.println(diceCombinattionsCount("",4));
    }
    static void diceCombinattions(String asf,int num){
        if(num == 0){
            System.out.println(asf);
            return;
        }
        for(int i=1;i<=6 && i<=num;i++){
            diceCombinattions(asf+i,num-i);
        }
    }


    //same function returning in ArrayList
    static ArrayList<String> diceCombinattionsList(String asf, int num){
        if(num == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(asf);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i=1;i<=6 && i<=num;i++){
            list.addAll(diceCombinattionsList(asf+i,num-i));
        }
        return list;
    }
// same function returning count
    static int diceCombinattionsCount(String asf,int num){
        if(num == 0){
            return 1;
        }
        int count = 0;
        for(int i=1;i<=6 && i<=num;i++){
            count += diceCombinattionsCount(asf+i,num-i);
        }
        return count;
    }
}
