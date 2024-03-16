package Recursion;
//the task is to eliminate the particular character in the given String and deploy the output
//Eg: I/P: "baccad"   ----> O/P: "bccd"
public class IgnoreLetterInString {
    public static void main(String[] args) {
        String str = "baccadappleAcappda";
        skip("",str);
        System.out.println(skip(str));
        System.out.println(skipApple(str));
        System.out.println(skipAppNotApple(str));
    }
    static void skip(String asf,String str){ //having two arguments
        if(str.isEmpty()) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        if(ch == 'a' || ch == 'A'){//for instance 'A' and 'a' should be removed
            skip(asf,str.substring(1));
        }
        else{
            skip(asf+ch,str.substring(1));
        }
    }

    static String skip(String str){ //having single argument
        if(str.isEmpty())
            return "";
        char ch = str.charAt(0);
        if(ch == 'a' || ch == 'A'){
            return skip(str.substring(1));
        }
        else{
            return ch + skip(str.substring(1));
        }
    }

    static String skipApple(String str){ //skipping an separate word
        if(str.isEmpty())
            return "";

        if(str.startsWith("apple")){
            return skipApple(str.substring(5));
        }
        else{
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }

    static String skipAppNotApple(String str){
        if(str.isEmpty())
            return "";

        if(str.startsWith("app") && !str.startsWith("apple")){
            return skipAppNotApple(str.substring(3));
        }
        else{
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }
}
