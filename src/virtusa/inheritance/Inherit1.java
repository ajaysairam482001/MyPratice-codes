package virtusa.inheritance;

import java.util.Scanner;


    class Account{
        String accountNumber;
        Double balance;
        String accountHolderName;
        public void d(String accountNumber,Double balance,String accountHolderName){
            this.accountNumber=accountNumber;
            this.balance=balance;
            this.accountHolderName=accountHolderName;
        }
    }class SavingAccount extends Account{
        int minimumBalance;
    }
    class FixedAccount extends SavingAccount{
        int lockingPeriod;
        public void getAccountDetail(String detail){
            String[] temp=detail.split(",");
            String num = temp[0];
            String bal =temp[1];
            String accountHolderName=temp[2];
            int minimumBalance=Integer.parseInt(temp[3]);
            int lockingPeriod=Integer.parseInt(temp[4]);
            System.out.print("Account Number       Balance    Account holder name  Minimum balance      Locking period\n");
            System.out.format("%-21s",num);
            System.out.format("%-11s",bal);
            System.out.format("%-21s",accountHolderName);
            System.out.format("%-21d",minimumBalance);
            System.out.format("%d",lockingPeriod);
        }
    }class Inherits1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a;
        a = sc.nextLine();
        FixedAccount q = new FixedAccount();
        q.getAccountDetail(a);

    }
}
 // testcase : Acc01,1000,Ajay,500,10
 //Account Number       Balance    Account holder name  Minimum balance      Locking period
// Acc01                1000       Ajay                 500                  10
       // Process finished with exit code 0