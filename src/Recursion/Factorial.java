package Recursion;
//Recurrence Relation: Linear
//                    (time-consuming by computing the same values again and again)
// can be made faster using recursion X dynamic programming

//https://www.youtube.com/watch?v=M2uO2nMT0Bk (kunal video on types of recurrence) time: 1.27.57
public class Factorial {
    public static int fact(int num){ // product of 1 to n;
        if(num == 0)
            return 1;
        return num * fact(num-1);
    }

    public static int sum(int num){ // sum of 1 to n;
        if(num == 0)
            return 0;
        return num + sum(num-1);
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(sum(5));
    }
}
//It is a non-tail-recursive function. Although it looks like a tail recursive at first look.
// If we take a closer look, we can see that the value returned by fact(n-1) is used in fact(n).
// So the call to fact(n-1) is not the last thing done by fact(n).
