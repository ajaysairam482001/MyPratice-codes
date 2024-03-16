package Recursion;

public class CountofZeros {
    static int counting(int n,int count){
        if(n/10 == 0){
            return count;
        }
        if(n%10 == 0){
            return counting(n/10,count+1);
        }
        return counting(n/10,count);
    }
    public static void main(String[] args) {
        System.out.println(counting(100,0));
    }
}
