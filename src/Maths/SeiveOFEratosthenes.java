package Maths;
//https://www.youtube.com/watch?v=lmSpZ0bjCyQ&t=2617s (21.30)
//to find prime number from range of 2toN (effectively)
public class SeiveOFEratosthenes {
    public static void main(String[] args) {
        int num = 40;
        boolean[] arr = new boolean[num+1];
        seive(num,arr);
    }

    static void seive(int n,boolean[] num){ // in boolean array initially all indexes are set to 'false'
        for(int i=2; i*i <= n;i++){
            if(!num[i]){
                for(int j = i*2;j<=n;j+=i)
                    num[j] = true;
            }
        }
        for(int i = 2;i<=n;i++){
            if(!num[i])
                System.out.print(i+" ");
        }
    }
}
