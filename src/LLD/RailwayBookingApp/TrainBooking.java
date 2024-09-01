package LLD.RailwayBookingApp;

import java.util.*;

public class TrainBooking {
    private static int berthLimit = 2; // 6/3
    private static int racLimit = 1;
    private static int waitingLimit = 1;
    private static int upperSeatNumber = 1;
    private static int middleSeatNumber = 2;
    private static int lowerSeatNumber = 3;

     static List<Passenger> confirmedList = new ArrayList<>();

     static List<Passenger> upperList = new ArrayList<>();
     static List<Passenger> middleList = new ArrayList<>();
     static List<Passenger> lowerList = new ArrayList<>();

     static Queue<Passenger> racQueue = new LinkedList<>();
     static Queue<Passenger> waitingList = new LinkedList<>();

    public static void bookTicket(Passenger p){
        if(upperList.size()==berthLimit && middleList.size()==berthLimit && lowerList.size()==berthLimit){

            if(racQueue.size() == racLimit){

                if(waitingList.size()==waitingLimit){
                    p.setId(p.getId()-1);
                    System.out.println("Sorry! Tickets are not available");
                }
                else {
                    //add to waitingList(queue)
                    p.setTicket_type("Waiting");
                    waitingList.add(p);
                    System.out.println("Added to waiting list. Ticket No: "+p.getId());
                }

            }
            else {
                //add to racList
                p.setTicket_type("RAC");
                racQueue.add(p);
                System.out.println("Added to RAC list. Ticket No: "+p.getId());
            }

        } else if (checkAvailability(p)) {
            System.out.println("Ticket confirmed.\nYour Ticket Id is: "+p.getId());
            p.setTicket_type("berth");
            confirmedList.add(p);
        }
        else {
            p.setId(p.getId()-1);
            System.out.println("Sorry!"+p.getSeat_preference()+"-berth tickets are not available");
            displayavailableTickets();
        }
    }

     private static boolean checkAvailability(Passenger p){
        Map<Integer,Character> map = CancelTicket.getCanceledseats();

        if(p.getSeat_preference() == 'U'){
            if(upperList.size()<berthLimit){
                if(!map.isEmpty()){
                    getseatDetails(map,p);
                }
                else {
                    p.setSeat_number(upperSeatNumber);
                    upperSeatNumber +=3;
                }
                upperList.add(p);
                return true;
            }
        }
        else if(p.getSeat_preference() == 'M'){
            if(middleList.size()<berthLimit){
                if(!map.isEmpty()){
                    getseatDetails(map,p);
                }
                else {
                    p.setSeat_number(middleSeatNumber);
                    middleSeatNumber +=3;
                }
                middleList.add(p);
                return true;
            }

        }
        else if(p.getSeat_preference() == 'L'){
            if(lowerList.size()<berthLimit){
                if(!map.isEmpty()){
                    getseatDetails(map,p);
                }
                else {
                    p.setSeat_number(lowerSeatNumber);
                    lowerSeatNumber +=3;
                }
                lowerList.add(p);
                return true;
            }
        }
        return false;
    }

    private static void getseatDetails(Map<Integer,Character> map,Passenger p){
        int seatnumber = checkPreferenceAvailability(map,p.getSeat_preference());
        p.setSeat_number(seatnumber);
        map.remove(seatnumber);
    }

    private static int checkPreferenceAvailability(Map<Integer,Character> map, Character ch){
        int seatnumber = 0;
        //for this refer the video time (43:15) for explaination
        for(Map.Entry<Integer,Character> i : map.entrySet()){
            if(ch == (char)i.getValue()){
                seatnumber = (int)i.getKey();
                break;
            }
        }
        return seatnumber;
    }

    //display methods
    public static void displayavailableTickets(){
        System.out.println("Check out the no of seats available");
        System.out.println("Upper Berth "+(berthLimit - upperList.size()));
        System.out.println("Middle Berth "+(berthLimit - middleList.size()));
        System.out.println("Lower Berth "+(berthLimit - lowerList.size()));
    }

    public static void displayConfirmed()
    {
        System.out.println("-------------------------");
        for(Passenger p : confirmedList)
        {
            System.out.println(p.toString());
            System.out.println("-------------------------");
        }
    }

    public static void displayRAC()
    {
        System.out.println("-------------------------");
        for(Passenger p : racQueue)
        {
            System.out.println(p.toString());
            System.out.println("-------------------------");
        }
    }
    public static void displayWaiting()
    {
        System.out.println("-------------------------");
        for(Passenger p : waitingList)
        {
            System.out.println(p.toString());
            System.out.println("-------------------------");
        }
    }
}
