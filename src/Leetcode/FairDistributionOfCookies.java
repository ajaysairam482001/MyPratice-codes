package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FairDistributionOfCookies {
    public static int distributeCookies(int[] cookies, int k) {
        int start = 0;
        int end = 0;
        List<Integer> list = new ArrayList<>();
        for (int j : cookies) {
            start = Math.max(start, j);
            end += j;
        }
        while(start!=end){
            int piece = 1;
            int mid = start + (end - start)/2;
            int sum = 0;
            for(int num : cookies){
                if(sum + num > mid){
                    piece++;
                    sum=num;
                }
                else{
                    sum += num;
                }
            }
            if(piece <= k)
                end = mid;
            else
                start = mid + 1;
        }
        int s = 10;
        end = 0;
        for(int num : cookies){
            if(num+end<=start){
                end+= num;
            }
            else{
                list.add(end);
                end = num;
            }
        }
        end = 0;
        for(int num : list){
            end = Math.max(end,num);
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {8,15,10,20,8};
        System.out.println(distributeCookies(arr,2));
    }
}
