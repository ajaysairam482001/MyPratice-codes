package Ajayjava;
import java.util.*;
import java.lang.*;


public class rough {

        public static char solution(char[] arr,char target){
            if(target>=arr[arr.length-1] || target<arr[0])
                return arr[0];
            else{
                int index = search(arr,target);
                if(arr[index]==target) {
                    while (arr[index] == target)
                        index++;
                    if (index > arr.length - 1)
                        return arr[0];
                    else
                        return arr[index];
                }
                else{
                    return arr[index];
                }
            }
        }

        public static int search(char[] arr, char target){
            int start = 0;
            int end = arr.length-1;
            while(start<=end){
                int mid = start + (end - start)/2;
                if(target>arr[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
//            return (arr[start] == target) ? arr[start+1] : arr[start];
            if(arr[start] == target){
                if(start == arr.length-1)
                        return 0;
                else
                    return start+1;
            }
            else
                return start;

        }


    public static void main(String[] args) {
        char[] arr = {'b','c','e','e','f','j','k'};
        //System.out.println(findKthPositive(arr,2));
        System.out.println(solution(arr,'c'));
    }
    }

