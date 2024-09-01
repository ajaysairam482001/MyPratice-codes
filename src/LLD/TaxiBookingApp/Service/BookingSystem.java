package LLD.TaxiBookingApp.Service;

import LLD.TaxiBookingApp.Entity.Taxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BookingSystem {
    private Map<Character,PriorityQueue<Taxi>> locationQueue;
    private ArrayList<Taxi> taxiList;

    public BookingSystem(int n){  //constructor
        locationQueue = new HashMap<>();
        for(char ch = 'A';ch<='F';ch++){
            locationQueue.put(ch,new PriorityQueue<>());
        }
        taxiList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            Taxi taxi = new Taxi(i+1);
            locationQueue.get('A').add(taxi);
            taxiList.add(taxi);
        }
    }

    public void bookTaxi(char pickUpLocation, char dropLocation, int pickupTime){
        PriorityQueue<Taxi> queue = locationQueue.get(pickUpLocation);
        Taxi assigned = null;
        if(queue.isEmpty()){
            assigned = nearestTaxi(pickUpLocation,pickupTime);
            if(assigned!=null) {
                allocate(assigned, pickUpLocation, dropLocation, pickupTime);
                System.out.println("Taxi number "+assigned.getId()+" is assigned");
            }
            else {
                System.out.println("No Taxis available \nTry again Later");
            }
        }
        else {
            Taxi taxi = queue.peek();
            if(taxi.getDropTime()<=pickupTime){ //availability
                assigned = queue.poll();
                assert assigned != null;
                allocate(assigned,pickUpLocation,dropLocation,pickupTime);
                System.out.println("Taxi number "+assigned.getId()+" is assigned");
            }
            else {
                assigned = nearestTaxi(pickUpLocation,pickupTime);
                if(assigned!=null) {
                    allocate(assigned, pickUpLocation, dropLocation, pickupTime);
                    System.out.println("Taxi number "+assigned.getId()+" is assigned");
                }
                else {
                    System.out.println("No Taxis available \nTry again Later");
                }
            }
        }
        return;
    }

    private Taxi nearestTaxi(char pickup, int pickupTime){
        int minDistance = Integer.MAX_VALUE;
        Taxi nearestTaxi = null;
        char nearestLocation = 'A';

        for (char loc = 'A'; loc <= 'F'; loc++) {
            PriorityQueue<Taxi> queue = locationQueue.get(loc);
            if (!queue.isEmpty()) {
                Taxi taxi = queue.peek();
                if(pickup > taxi.getDropTime()){ //check timings
                    int distance = Math.abs(loc - pickup);
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestTaxi = taxi;
                        nearestLocation = loc;
                    } else if (distance == minDistance && taxi.getEarnings() < nearestTaxi.getEarnings()) {
                        nearestTaxi = taxi;
                        nearestLocation = loc;
                    }
                }
            }
        }

        if (nearestTaxi != null) {
            locationQueue.get(nearestLocation).poll(); // Remove the nearest taxi from its queue
        }
        return nearestTaxi;
    }
//    private Taxi nearestTaxi(char location,int pickUpTime){
////        int min_distance = Integer.MAX_VALUE;
////        Taxi nearestTaxi = null;
////        for(Taxi taxi : taxiList){
////            if(taxi.getDropTime()<pickUpTime){ //is_available
////                int distance = Math.abs(location-taxi.getCurrentLocation());
////                if(min_distance>distance){
////                    min_distance = distance;
////                    nearestTaxi = taxi;
////                } else if (min_distance == distance && nearestTaxi.getEarnings()>taxi.getEarnings()) { //if same distance compare earnings
////                    nearestTaxi = taxi;
////                }
////            }
////        }
////        if(nearestTaxi != null){
////            return nearestTaxi;
////        }
////        else {
////            System.out.println("Taxi unavailable");
////        }
////        return null;
//    }

    private void allocate(Taxi taxi,char pickup, char drop,int pickTime){
        int distance = Math.abs(pickup - drop) * 15;
        int time = Math.abs(pickup - drop);
        int fare = 100 + (distance - 5)*10;
        taxi.setCurrentLocation(drop);
        taxi.setDropLocation(drop);
        taxi.setEarnings(taxi.getEarnings()+fare);
        taxi.setPickUpLocation(pickup);
        taxi.setPickUpTime(pickTime);
        taxi.setDropTime(pickTime+time);
        taxi.setRide_mileage(taxi.getRide_mileage()+distance);

        //add in the queue
        locationQueue.get(drop).add(taxi);
        return;
    }

    public void display(){
        for(Taxi taxi: taxiList){
            System.out.println("-----------------------------------------------");
            System.out.println(taxi.toString());
            System.out.println("-----------------------------------------------");
        }
    }
}
