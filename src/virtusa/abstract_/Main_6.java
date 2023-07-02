package virtusa.abstract_;

import java.util.*;
interface Airfare{
    public double calculateAmount();
}
class AirIndia implements Airfare{
    private double hoursOfTravel;
    private double costPerHour;

    public AirIndia(double hoursOfTravel,double costPerHour){
        this.hoursOfTravel = hoursOfTravel;
        this.costPerHour = costPerHour;
    }

    public double calculateAmount(){
        return this.hoursOfTravel*this.costPerHour;
    }
}
class KingFisher implements Airfare{
    private double hoursOfTravel;
    private double costPerHour;

    public KingFisher(double hoursOfTravel,double costPerHour){
        this.hoursOfTravel = hoursOfTravel;
        this.costPerHour = costPerHour;
    }
    public double calculateAmount(){
        return(this.hoursOfTravel*this.costPerHour)*4;
    }
}

class Indigo implements Airfare{
    private double hoursOfTravel;
    private double costPerHour;

    public Indigo(double hoursOfTravel,double costPerHour){
        this.hoursOfTravel = hoursOfTravel;
        this.costPerHour = costPerHour;
    }
    public double calculateAmount(){
        return(this.hoursOfTravel* this.costPerHour)*8;
    }
}
class Main_6{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        double hot = in.nextDouble();
        double cph = in.nextDouble();
        Airfare obj;
        if(choice == 1){
            obj = new AirIndia(hot,cph);
        }
        else if(choice == 2){
            obj = new KingFisher(hot,cph);
        }
        else{
            obj = new Indigo(hot,cph);
        }
        double totalAmount = obj.calculateAmount();
        System.out.printf("%.2f",totalAmount);
    }
}
