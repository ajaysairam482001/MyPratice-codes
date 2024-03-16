package FITA.serialization;

import java.io.Serializable;
import java.util.Date;

public class PaymentInfo implements Serializable {
    //creating a simple POJO class
    //difference between transient and static given to a variable basis
    //while using transient the variable does not hit db or store it
    //it is simply used in the program itself when certain conditions(to store in db) are not met
    private int accId;
    private String accName;
    private Date date;
    private transient float amount;

    public PaymentInfo() {
        //doesnt need any para or body
        //used for declaration empty objects  and assigning values later..
    }

    public PaymentInfo(int accId, String accName, Date date, float amount) {
        this.accId = accId;
        this.accName = accName;
        this.date = date;
        this.amount = amount;
    }

    public int getAccId() {
        return accId;
    }

    public String getAccName() {
        return accName;
    }

    public Date getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
