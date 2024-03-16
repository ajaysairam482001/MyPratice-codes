package Recursion;

import java.util.ArrayList;

//using linear search
public class FindTarget {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5,6};
        int target = 4;
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(find(arr,target,0));
        System.out.println(findindex(arr,target,0));
        System.out.println(findindexlast(arr,target, arr.length-1));
        findAllindex(arr,target,0);
        System.out.println(list);
        System.out.println(findAllindex2(arr,target,0,list2));
        System.out.println(findAllindex3(arr,target,0));
    }

    static boolean find(int[] arr,int target,int index){
        if(index == arr.length-1)
            return false;
//        if(arr[index] == target)
//            return true;
//        else
//            return find(arr,target,index+1);

        return arr[index] == target || find(arr,target,index+1);
    }

    static int findindex(int[] arr,int target,int index){
        if(index == arr.length)
            return -1;

        if(arr[index] == target)
            return index;
        else
            return findindex(arr,target,index+1);

    }

    static int findindexlast(int[] arr,int target,int index){
        if(index == -1)
            return -1;

        if(arr[index] == target)
            return index;
        else
            return findindexlast(arr,target,index-1);

    }

    static ArrayList<Integer> list = new ArrayList<>();
    // type 1 of creating list outside function
    static void findAllindex(int[] arr,int target,int index){
        if(index == arr.length)
            return;

        if(arr[index] == target)
            list.add(index);

        findAllindex(arr,target,index+1);

    }
//  type2 declaring the list inside the main and passing as an parameter so that anychanges done to list2
//  or its references will affect the list at any stage
    static ArrayList<Integer> findAllindex2(int[] arr,int target,int index,ArrayList<Integer> list){
        if(index == arr.length)
            return list;

        if(arr[index] == target)
            list.add(index);

        return findAllindex2(arr,target,index+1,list);

    }

    static ArrayList<Integer> findAllindex3(int[] arr,int target,int index){
        //type3 declare list inside method and send its return value upper side
        //if the methods have any value it get collect on the way up and gets displayed as final value
        ArrayList<Integer> list3 = new ArrayList<>();
        if(index == arr.length)
            return list3;

        if(arr[index] == target)
            list3.add(index);

        list3.addAll(findAllindex3(arr,target,index+1)); // collect values from below function calls
        return list3; // sending it upward to main

    }
}
