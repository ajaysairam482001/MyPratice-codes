package FITA;


import java.util.Scanner;

public class LoginPage {

    public static void login() throws InvalidProduct{
        SignUpPOJO[] list = new SignUpPOJO[3];
        list[0] = new SignUpPOJO("Ajay","raja",994064657,"ajay@gmail.com", status.ordered,12);
        list[1] = new SignUpPOJO("Sai","raja",994064652,"sai@gmail.com",status.delivered,13);
        list[2] = new SignUpPOJO("Ram","pooja",994064651,"ram@gmail.com",status.shipped,14);
        Scanner in = new Scanner(System.in);

        System.out.println("Enter userEmail: ");
        String mail = in.next();
        System.out.println("Enter Password: ");
        String pwd = in.next();
        boolean ff = true;
        for(SignUpPOJO temp : list){
            if((mail.equals(temp.getEmail())) && (pwd.equals(temp.getPassword()))){
                System.out.println("Logged in successfully");
                System.out.print("Enter your product ID to check: ");
                int num = in.nextInt();
                if(num == temp.getProductid()){
                    System.out.println("Product delivery status: "+temp.getStat());
                    System.out.println("Product ID number: "+temp.getProductid());
                }else{
                    throw new InvalidProduct("Invalid product number");
                }

                ff = false;
                break;
            }
        }
        if(ff) {
            System.out.println("Invalid credentials");
        }
    }

    public static void main(String[] args) throws InvalidProduct {
        login();
//        expection (if you dont know excatly what exception to give)
//                parent for exception in throwable
//        there should be atleast one catch or finally
//        finally will not handle your exception(it doesnt care of the error) but what is does is that
//                it executes it block no matter what happens (like a pirority method)


//        throw handles compile time error
//                throws handle method error
    }
}
