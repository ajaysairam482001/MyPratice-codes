package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//this will be using BACKTRACKING like word search prblm
//consider a 3X3 matrix where u want to go from on end to another
//kunal link: https://www.youtube.com/watch?v=zg5v2rlV1tM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=39
public class Maze {
    public static void main(String[] args) {
       // System.out.println(pathsTillEnd(3,3));
        boolean[][] obstical = {{true, true, true},
                                {true, false, true},
                                {true, true, true},
            };

        boolean[][] visit = new boolean[3][3]; //by default its false
        int[][] paths = new int[3][3];

        //pathsPrintwithObsticals("",3,3,obstical);
        //pathsPrintDiagonal("",3,3);
        //System.out.println(pathsAllPrint("",0,0,visit)); //this method uses backtracking
        printAllMatrix("",0,0,paths,0);
    }
    static int paths(int r,int c){ //when the pointer reaches to the last column it returns out its number of paths
        if(r==1 || c==1){
            return 1;
        }
        int left = paths(r-1,c);
        int right = paths(r,c-1);
        return left+right;
    }

    static int pathsTillEnd(int r,int c){ //when the pointer reaches to the last end element it returns out its number of paths
        if(r==1 && c==1){
            return 1;
        }
        int paths = 0;
        if(r>1) {
            paths += pathsTillEnd(r - 1, c);
        }
        if(c>1) {
            paths += pathsTillEnd(r, c - 1);
        }
        return paths;
    }

    static void pathsPrint(String asf, int r, int c){ //flow restricted to down and right
        //this method prints the paths
        if(r==1 && c==1){
            System.out.println(asf);
            return ;
        }

        if(r>1) {
            pathsPrint(asf+'D',r - 1, c);
        }
        if(c>1) {
            pathsPrint(asf+'R',r, c - 1);
        }
    //you can also modify this to return in a List<> (refer subseqCombinations)
    }

    static void pathsPrintDiagonal(String asf, int r, int c){ //considering you can also go diagonal
        //this method prints the paths
        if(r==1 && c==1){
            System.out.println(asf);
            return ;
        }
        //can also this method to print the number of paths
        if(r>1) {
            pathsPrintDiagonal(asf+'V',r - 1, c); //vertical
        }
        if(c>1) {
            pathsPrintDiagonal(asf+'H',r, c - 1); //horizontal
        }
        if(r>1 && c>1) {
            pathsPrintDiagonal(asf+'D',r-1, c - 1); //Diagonal
        }
        //you can also modify this to return in a List<> (refer subseqCombinations)
    }

    static void pathsPrintwithObsticals(String asf, int r, int c,boolean[][] obs){ // Lets say in array (2,2) has a hole and you cant pass through it
        //this method prints the paths
        if(r==1 && c==1){
            System.out.println(asf);
            return;
        }
        if(!obs[r-1][c-1]) // -1 for avoiding index bounds
            return;

        if(r>1) {
            pathsPrintwithObsticals(asf+'D',r - 1, c,obs);
        }
        if(c>1) {
            pathsPrintwithObsticals(asf+'R',r, c - 1,obs);
        }
        //you can also modify this to return in a List<> (refer subseqCombinations)
    }

    //this methods includes all paths
    static List<String> pathsAllPrint(String asf, int r, int c, boolean[][] visited){

        if(r==visited.length-1 && c==visited.length-1){
            List<String> list = new ArrayList<>();
            list.add(asf);
            return list;
        }
        List<String> list = new ArrayList<>();
        if(visited[r][c]){
            return list;
        }
        visited[r][c] = true;
        if(r<visited.length-1) {
            list.addAll(pathsAllPrint(asf+'D',r + 1, c,visited)); //down
        }
        if(c<visited[0].length-1) {
            list.addAll(pathsAllPrint(asf+'R',r, c + 1,visited)); //right
        }
        if(r>0){
            list.addAll(pathsAllPrint(asf+'U',r - 1, c,visited)); //up
        }
        if(c>0){
            list.addAll(pathsAllPrint(asf+'L',r,c - 1,visited)); //left
        }
        visited[r][c] = false; //like a thief marking that i didnt visit this path for other recursion calls to visit it
        return list;
    }

    static void printAllMatrix(String asf, int r, int c, int[][] path,int count){
        //this methods prints the path in the matrices
        // this also explores all sides too
        if(r==path.length-1 && c==path.length-1){
            count += 1;
            path[r][c] = count;
            for(int[]arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }
        if(path[r][c] != 0){ //first check it's not visited
            return;
        }
        count += 1;
        path[r][c] = count;
        if(r<path.length-1) {
            printAllMatrix(asf+'D',r + 1, c,path,count); //down
        }
        if(c<path[0].length-1) {
            printAllMatrix(asf+'R',r, c + 1,path,count); //right
        }
        if(r>0){
            printAllMatrix(asf+'U',r - 1, c,path,count); //up
        }
        if(c>0){
            printAllMatrix(asf+'L',r,c - 1,path,count); //left
        }
        path[r][c] = 0; //like a thief marking that i didn't visit this path for other recursion calls to visit it
        //reset
    }
}
