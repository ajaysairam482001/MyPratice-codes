package LLD.SnakesAndLadders.Models;

import java.util.*;

//https://github.com/lavakumarThatisetti/Machine-Coding-Round/blob/master/src/com/lavakumar/snakeandladder/service/PlaySnakeAndLadder.java
public class Entities {
    private static HashMap<Integer,Integer> snakes;
    private static HashMap<Integer,Integer> ladders;
    private static Deque<Player> players;

    private static Entities instance = null;

    public Entities(){
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        players = new LinkedList<>();
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(int startplace,int endplace) {
        snakes.put(startplace,endplace);
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(int startplace,int endplace) {
        ladders.put(startplace,endplace);
    }

    public Deque<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player player) {
        players.addLast(player);
    }

    public static Entities getInstance(){ //creating a single instance and avoiding multiple entity creations
        if(instance == null){
            instance = new Entities();
        }
        return instance;
    }
}
