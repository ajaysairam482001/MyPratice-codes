package FITA;

public class Array {
    public static void main(String[] args) {
        String[] str = {"mallini","ravi","ravi","senthil","vicky"};
        int count = 0;
        long lo = 1234567899;
        boolean repeat = false;
        for(int i = 0;i< str.length;i++){
            for(int j = i+1;j<str.length;j++){
                if(str[i].equals(str[j])){
                    count++;
                    repeat = true;
                }
            }
            if(!repeat){
                System.out.println(str[i]);
            }
            repeat = false;
        }
        System.out.println("Count: "+ count);
        System.out.println(lo);
    }
}
