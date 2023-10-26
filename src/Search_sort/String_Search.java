package Search_sort;

public class String_Search {
    public static void main(String[] args) {
        String s = "Hello world";
        char target = 'z';
        String_Search obj = new String_Search(); // when you didnt use Static for method use the name in Main (String_search) to
        //create the object of type Main and call it
        System.out.println(obj.search(s,target)); // checks if char is present in the string
    }
    boolean search(String str,char c){
        if(str.length() == 0)
            return false;

        for(char ch : str.toCharArray()){
            if(ch == c)
                return true;
        }
        return false;
    }
}
