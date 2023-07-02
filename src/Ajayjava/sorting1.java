//   i/p:   5
//        Enter unsorted array : 2 5 3 1 4
 //    o/p:
//        The sorted arr : 1 2 3 4 5
//        The Return Value : 1 (consective)

package Ajayjava;
import java.util.*;
public class sorting1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];
        System.out.print("Enter unsorted array : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(function(arr));
    /*    int[] arr1={2,3,1,5,4};
        int[] arr2={2,0,1,4,8};
        System.out.println(function(arr1));

        System.out.println(function(arr2));*/
    }
    static int function(int[] arr){
        //1 2 3 4 5
        Arrays.sort(arr);
        System.out.print("The sorted arr : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("The Return Value : ");
        for (int i = 0; i <arr.length/2 ; i++) {
            //1   3    5
            //1!=2  &&   3!=4
            if(arr[i]!=arr[i]-1 && arr[i+1]!=arr[i+2]-1){
                return 0;
            }


        }
        return 1;
    }

}
