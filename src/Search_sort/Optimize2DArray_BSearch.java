package Search_sort;

import java.util.Arrays;

public class Optimize2DArray_BSearch {

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4, 5},
                { 6, 7, 8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };                        // type 1 Input 5X5

//        int[][] mat = {
//                {1,2,3,4,5}
//        };                        //type 2 1D array (exception);

        System.out.println(Arrays.toString(search(mat,5)));
    }
    static int[] binarysearch(int[][] matrix,int row, int cStart, int cEnd, int target){
        int cMid = 0;
        while(cStart<=cEnd){
            cMid = cStart+(cEnd-cStart)/2;
            if(matrix[row][cMid]==target)
                    return new int[] {row,cMid};
            else if(target>matrix[row][cMid]){
                cStart = cMid + 1;
            }
            else
                cEnd = cMid - 1;
        }
        return new int[]{-1,-1};
    }


    static int[] search(int[][] matrix , int target) {
        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cStart = 0;
        int cEnd = matrix[rEnd].length - 1;
        if (matrix.length == 1) { // for 1D arrays
            return binarysearch(matrix, 0, cStart, matrix[0].length-1, target);
        }
        int rMid = rStart + (rEnd - rStart) / 2;
        int cMid = cStart + (cEnd - cStart) / 2;

        while (rStart < rEnd - 1) { //stops at last 2 row remaining
            rMid = rStart + (rEnd - rStart) / 2;
//            cMid = cStart + (cEnd - cStart) / 2;
            if (matrix[rMid][cMid] == target)
                return new int[]{rMid, cMid};
            if (matrix[rMid][cMid] < target) {
                rStart = rMid;
            } else
                rEnd = rMid;
        }
        //at last with 2 rows remaining
        rMid = rStart + (rEnd - rStart) / 2;

        // check for all the 4 parts and middle 2 parts too!
        if (matrix[rMid][cMid] == target) { //top mid
            return new int[]{rMid, cMid};
        }
        if (matrix[rMid][cMid] > target) { //part 1
            return binarysearch(matrix, rMid, cStart, cMid - 1, target);
        }

        if (matrix[rMid][cMid] < target && target <= matrix[rMid][cEnd]) //part 2
            return binarysearch(matrix, rMid, cMid + 1, cEnd, target);

        ++rMid;
        if (matrix[rMid][cMid] == target) { //down mid
            return new int[]{rMid, cMid};
        }

        if (matrix[rMid][cMid] > target) { //part 3
            return binarysearch(matrix, rMid, cStart, cMid - 1, target);
        }
        if (matrix[rMid][cMid] < target && target <= matrix[rMid][cEnd]) //part 4
            return binarysearch(matrix, rMid, cMid + 1, cEnd, target);

        return new int[]{-1, -1};

    }
}
