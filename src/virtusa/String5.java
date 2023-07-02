package virtusa;



import java.util.*;
public class  String5{
    public static ArrayList<String> createGroups(String string){
        ArrayList<String> gg = new ArrayList<>();
        String cg = "";
        boolean fr = true;
        for(int i = 0;i <string.length();i++){
            char c = string.charAt(i);
            if(Character.isAlphabetic(c)){
                //c = Character.toLowerCase(c);
                if(fr){
                    if(cg.length()>0&&c - cg.charAt(cg.length()-1)!=1){
                        gg.add(cg);
                        cg = "";
                        fr = false;
                    }
                }
                else{
                    if(cg.length()>0&&cg.charAt(cg.length()-1) - c!=1){
                        gg.add(cg);
                        cg = "";
                        fr = true;
                    }
                }
                cg += c;
            }
            else{
                if(cg.length()>0){
                    gg.add(cg);
                    cg = "";
                }
                gg.add(Character.toString(c));
            }
        }
        if(cg.length()>0){
            gg.add(cg);
        }
        return gg;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        ArrayList<String> groups = createGroups(str);
        for(int i = 0;i<groups.size();i++)
            System.out.println(groups.get(i));
    }
}