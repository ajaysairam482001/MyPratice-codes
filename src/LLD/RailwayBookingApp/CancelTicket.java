package LLD.RailwayBookingApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CancelTicket extends TrainBooking{
    private static Map<Integer,Character> canceledseats = new HashMap<>();
    private static char preferenceTracker = '\0';
    private static int seattracker = 0;

    public static String cancel(int id){
        for(Passenger p : confirmedList){
            if(p.getId() == id){
                cancelTicket(p);
                return "Success";
            }
        }
        for(Passenger p : racQueue){
            if(p.getId() == id){
                cancelTicket(p);
                return "Success";
            }
        }
        for(Passenger p : waitingList){
            if(p.getId() == id){
                cancelTicket(p);
                return "Success";
            }
        }
        return "Invalid ID";
    }
    public static void cancelTicket(Passenger p) {
        if(p.getTicket_type() == "berth"){
            preferenceTracker = p.getSeat_preference();
            seattracker = p.getSeat_number();
            canceledseats.put(seattracker,preferenceTracker);
            //remove the cancelled p from all lists available
            deleteFromAllList(p);
            System.out.println("Ticket ID "+p.getId()+" got cancelled from "+p.getTicket_type()+".");
            if(!racQueue.isEmpty()){
                Passenger temp = addRacToBerth();
                addtoList(temp);
                //reset
                canceledseats.remove(seattracker);
            }
            preferenceTracker = '\0';
            seattracker = 0;
        } else if (p.getTicket_type() == "RAC") {
            Passenger temp = racQueue.poll();
            System.out.println("Ticket ID "+p.getId()+" got cancelled from "+p.getTicket_type()+".");
            addWaitingToRAC();
        }else if(p.getTicket_type() == "Waiting"){
            Passenger temp = waitingList.poll();
            System.out.println("Ticket ID "+p.getId()+" got cancelled from "+p.getTicket_type()+".");
        }
    }
    private static Passenger addRacToBerth(){
        //promotion
        Passenger temp = racQueue.poll();
        assert temp != null;
        temp.setTicket_type("berth");
        temp.setSeat_number(seattracker);
        temp.setSeat_preference(preferenceTracker);
        confirmedList.add(temp);
        System.out.println("Ticket ID "+temp.getId()+" added to berth.");
        if(!waitingList.isEmpty()){
            addWaitingToRAC();
        }
        return temp;
    }
    private static void addWaitingToRAC(){
        Passenger temp = waitingList.poll();
        temp.setTicket_type("RAC");
        racQueue.add(temp);
        System.out.println("Ticket ID "+temp.getId()+" added to RAC.");
    }
    private static void deleteFromAllList(Passenger p){
        confirmedList.remove(p);
        if(p.getSeat_preference() == 'U'){
            upperList.remove(p);
        }
        if(p.getSeat_preference() == 'M'){
            middleList.remove(p);
        }
        if(p.getSeat_preference() == 'L'){
            lowerList.remove(p);
        }
    }

    private static void addtoList(Passenger p){
        if(p.getSeat_preference() == 'U'){
            upperList.add(p);
        }
        if(p.getSeat_preference() == 'M'){
            middleList.add(p);
        }
        if(p.getSeat_preference() == 'L'){
            lowerList.add(p);
        }
    }

    public static Map<Integer,Character> getCanceledseats(){
        return canceledseats;
    }
}
