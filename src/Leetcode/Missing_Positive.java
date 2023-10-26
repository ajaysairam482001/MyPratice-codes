package Leetcode;
//https://leetcode.com/problems/first-missing-positive/
//Qn: 41
public class Missing_Positive {

    public int firstMissingPositive(int[] nums) {
            int i = 0;
            while(i<nums.length){
                int crt = nums[i]-1;
                if(crt>=0 && crt<nums.length){
                    if(nums[i]!=nums[crt] && nums[i]>0 && nums[i]<nums.length){
                        swap(nums,i,crt);
                    }
                    else{
                        i++;
                    }
                }
                else
                    i++;
            }
            for(i=0;i<nums.length;i++){
                if(nums[i]!=i+1)
                    return i+1;
            }
            return nums.length+1;

        }
        public void swap(int[] arr,int start,int end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};
        Missing_Positive obj = new Missing_Positive();
        System.out.println(obj.firstMissingPositive(arr));
    }

    }

