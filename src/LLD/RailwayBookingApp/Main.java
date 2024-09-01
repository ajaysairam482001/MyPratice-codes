package LLD.RailwayBookingApp;

import java.util.Scanner;
//(reference)
//https://github.com/B-Rajagopalan/CodingAtti-YouTube/tree/main/Zoho_AdvancedProgramming_Round3/src/railwayRerservation
//https://www.youtube.com/watch?v=HfuXCnA7P3Q&list=PLjq3dI1OpGjj6jgnKx8RfIMDakH7rpSYR&index=1
public class Main {
    public static void main(String[] args) {
        boolean loop = true;

        while (loop) {
            System.out.println("\nChoose any one \n 1.Book ticket \n 2.Cancel ticket"
                    + " \n 3.Display Confirmed list\n 4.Display RAC list"
                    + "\n 5.Display Waiting list\n 6.Exit");
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();

            switch (n) {
                case 1: {
                    System.out.println("Enter name : ");
                    String name = s.next();
                    System.out.println("Enter age : ");
                    int age = s.nextInt();
                    System.out.println("Enter berth : ");
                    char preference = s.next().charAt(0);
                    if (preference == 'U' || preference == 'M' || preference == 'L')
                        TrainBooking.bookTicket(new Passenger(name, age, preference));
                    else
                        System.out.println("Invalid berth");
                    break;
                }

                case 2: {
                    System.out.println("Enter your Ticket id : ");
                    int id = s.nextInt();
                    System.out.println(CancelTicket.cancel(id));
                    break;
                }

                case 3: {
                    TrainBooking.displayConfirmed();
                    break;
                }

                case 4: {
                    TrainBooking.displayRAC();
                    break;
                }

                case 5: {
                    TrainBooking.displayWaiting();
                    break;
                }

                case 6: {
                    System.out.println("\tThank you!");
                    s.close();
                    loop = false;
                    break;
                }
            }
        }
    }
}
