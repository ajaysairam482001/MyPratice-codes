package FITA.serialization;


import java.io.*;
import java.util.Date;
//serialization
public class PaymentoutImplementation {

    void write()throws IOException {
        //this fileoutstream traces the path and stores it in its format in file variable (create the file in the location)
        FileOutputStream file = new FileOutputStream("C:\\Users\\AJAY SAI RAM\\FITA\\serial\\indexex.csv");


        //the oos uses the path from the file variable and creates an object to be stored in the location
        ObjectOutputStream oos = new ObjectOutputStream(file);

        //creates the pojo object to store
        PaymentInfo pay = new PaymentInfo(123,"Ajay",new Date(),10000);

        //writes it via oos to that txt file with the given path
        oos.writeObject(pay);

        //if the above line executes then alone sout executes or else exceptions occur
        System.out.println("Object Created successfully");

        //this can usually throw a IOException error and whereas in main either try&catch or throws used to handle exceptions
    }

    public static void main(String[] args){
        try {
            PaymentoutImplementation acc = new PaymentoutImplementation();
            acc.write();
            System.out.println("try done");
        }catch (Exception e){
            e.printStackTrace(); //used for practices purposes
            //used to show the line where error is occurred
            //not recommended when going to production
        }



    }
}
