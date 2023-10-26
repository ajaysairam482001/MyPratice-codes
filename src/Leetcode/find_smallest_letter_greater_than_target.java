package Leetcode;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
//  Qn: 744
public class find_smallest_letter_greater_than_target {
    public char nextGreatestLetter(char[] arr, char target) {
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
        char[] c = {'c','f','j'};
        find_smallest_letter_greater_than_target obj = new find_smallest_letter_greater_than_target();
        System.out.println(obj.nextGreatestLetter(c,'d'));
    }
}
