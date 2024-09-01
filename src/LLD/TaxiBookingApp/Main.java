package LLD.TaxiBookingApp;

import LLD.TaxiBookingApp.Service.BookingSystem;

import java.util.Scanner;

//https://wisdomoverflow.com/2020/08/07/call-taxi-booking-system-zoho-3rd-round-question/
//https://www.youtube.com/watch?v=zG7UjOtCvYI&list=PLjq3dI1OpGjj6jgnKx8RfIMDakH7rpSYR&index=2
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of taxi: ");
        int num = in.nextInt();
        BookingSystem book = new BookingSystem(num);
        boolean bool = true;

        while (bool){
            System.out.println("1.Book a Taxi.\n2.Taxi Details.\n3.Exit");
            int n = in.nextInt();

            switch (n){
                case 1: {
                    char pickup;
                    char drop;
                    int time;
                    System.out.println("//////////////////////");
                    System.out.println("Enter PickUpLocation: ");
                    pickup = in.next().trim().charAt(0);
                    System.out.println("Enter DropLocation: ");
                    drop = in.next().trim().charAt(0);
                    System.out.println("Enter PickUpTime: ");
                    time = in.nextInt();
                    System.out.println("//////////////////////");
                    book.bookTaxi(pickup, drop, time);
                    break;
                }
                case 2:{
                    book.display();
                    break;
                }
                case 3:{
                    bool = false;
                    break;
                }
                default:{
                    System.out.println("Invalid Input");
                }
            }
        }
    }
}

// the constrains this program wont address are
//1. taxi travelling from its currentloc to pickup wont affect the timeline ( i have assumed it would fast travel or spawn in the pickup location)) XD
//2. it handles for 24 hour shift (one day only) the next day complexity is not coded (after 23:00 if you add 1:00 it assumes that day)
//3. does not have full history log of taxi (but can create a list and add every time a texi is assigned)