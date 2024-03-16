package zoho;

public class SpiralMatrix {
    public static void main(String[] args) {
        int n = 4;
        int[][] arr = new int[n][n];
        spiral(arr, n);
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
//        System.out.println(fibo(6));
    }
    static int fibo(int i){
        if(i<=1)
            return i;
        return fibo(i-2)+fibo(i-1);
    }

    static void  spiral(int[][] a,int n){
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int dir = 0;
        int value = 1;
//  done using simple pointers
        while(top<=bottom && left<=right){

            if(dir == 0){
                for(int i=left;i<=right;i++){
                    a[top][i] = fibo(value++);
                }
                top += 1;
                dir++;
            }
            else if(dir == 1){
                for(int i=top;i<=bottom;i++){
                    a[i][right] = fibo(value++);
                }
                right -= 1;
                dir++;
            }
            else if(dir == 2){
                for(int i=right;i>=left;i--){
                    a[bottom][i] = fibo(value++);
                }
                bottom -= 1;
                dir++;
            }
            else if(dir == 3){
                for(int i=bottom;i>=top;i--){
                    a[i][left] = fibo(value++);
                }
                left += 1;
                dir++;
            }
            else{
                dir = dir%4;
            }
        }

    }
}
