package Search_sort;

public class Linear_Search {
    public static void main(String[] args) {
        int[] a = {1,5,8,56,-8,6,7,10};
        System.out.println(linearSearch_index(a,56));//returns the index of the founded element in the array
        System.out.println(linearSearch_element(a,56));//returns the element of the founded element in the array
        System.out.println(linearSearch_trueOrFalse(a,56)); // return found or not (true or false)
    }
    static int linearSearch_index(int[] arr,int target){
        if(arr.length == 0)
            return Integer.MAX_VALUE;

        for(int index = 0; index<= arr.length;index++){ //iterate to find the index of the target
            if(arr[index]==target)
                return index; //returns the index
        }
        return Integer.MAX_VALUE; // if you didn't find the target in the array return MaxIntValue
    }

    static int linearSearch_element(int[] arr,int target){
        if(arr.length == 0)
            return Integer.MAX_VALUE;

        for(int element : arr){ //iterate through every element of the array to find the element and returns the element value
            if(element == target)
                return element; //returns the element
        }
        return Integer.MAX_VALUE; // if you didn't find the target in the array return MaxIntValue
    }

    static boolean linearSearch_trueOrFalse(int[] arr,int target){
        if(arr.length == 0)
            return false;

        for(int element : arr){ //iterate through every element of the array to find the element and returns the element value
            if(element == target)
                return true; //returns the true
        }
        return false; // if you didn't find the target in the array return false
    }
}
