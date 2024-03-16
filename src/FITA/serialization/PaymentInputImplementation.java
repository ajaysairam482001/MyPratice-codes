package FITA.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
//deserialization
public class PaymentInputImplementation {
//refer PaymentoutImplementation
    void read() throws FileNotFoundException,IOException,ClassNotFoundException{
        //same as previous file refer it(PaymentoutImplementation)
        FileInputStream infile = new FileInputStream("C:\\Users\\AJAY SAI RAM\\FITA\\serial\\index.txt");
        ObjectInputStream ois = new ObjectInputStream(infile);

        //the below line is where de-serialization occurs
        //just creating pojo type class and assigning object(ois) which in separate format to the acc
        PaymentInfo acc = (PaymentInfo) ois.readObject();
        System.out.println("read successfully");
        System.out.println("Account Number: "+acc.getAccId());
        System.out.println("Account Name: "+acc.getAccName());
        System.out.println("Amount: "+acc.getAmount());
        System.out.println("Transaction Date: "+acc.getDate());
    }

    public static void main(String[] args) {
        //can either use try&catch or throws
        try{
            PaymentInputImplementation ii = new PaymentInputImplementation();
            ii.read();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
