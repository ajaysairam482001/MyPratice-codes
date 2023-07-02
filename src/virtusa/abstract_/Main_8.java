package virtusa.abstract_;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

abstract class Account{
    String name;
    int number;
    int balance;
    Date startDate;

    public Account(String name,int number,int balance, Date startDate){
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.startDate = startDate;
    }
    abstract double calculateInterest(Date dueDate);
}
class CurrentAccount extends Account{
    public CurrentAccount(String name,int number,int balance,Date startDate){
        super(name,number,balance,startDate);
    }
    @Override
    double calculateInterest(Date dueDate){
        long diff = dueDate.getTime()-startDate.getTime();
        int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        double interest = balance*0.12*(days/365.345);
        double roundOff = Math.round(interest);
        return roundOff;
    }
}
class SavingsAccount extends Account{
    public SavingsAccount(String name,int number,int balance,Date startDate){
        super(name,number,balance,startDate);
    }
    @Override
    double calculateInterest(Date dueDate){
        long diff = dueDate.getTime()-startDate.getTime();
        int days = (int) TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
        double interest = balance*0.05*days/365.34;
        double roundOff = Math.round(interest);
        return roundOff;
    }
}
class Main{
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        int accountType = in.nextInt();
        String name = in.next();
        int number = in.nextInt();
        int balance = in.nextInt();
        String startDateStr = in.next();
        String endDateStr = in.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = sdf.parse(startDateStr);
        Date endDate = sdf.parse(endDateStr);

        Account account = null;
        if(accountType == 1){
            account = new CurrentAccount(name,number,balance,startDate);
        }
        else if(accountType == 2){
            account = new SavingsAccount(name,number,balance,startDate);
        }
        double interest = account.calculateInterest(endDate);
        System.out.println(interest);
    }
}