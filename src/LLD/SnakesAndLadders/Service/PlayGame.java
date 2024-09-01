package LLD.SnakesAndLadders.Service;

import LLD.SnakesAndLadders.Models.Dice;
import LLD.SnakesAndLadders.Models.Entities;
import LLD.SnakesAndLadders.Models.Player;

import java.util.Scanner;

public class PlayGame extends Exception{
    private Entities props;
    private Dice dice;
    public PlayGame(){
        props = Entities.getInstance();
        dice = new Dice(6); // give it in input if you want
    }

    public void play () throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of snakes and its positions");
        int snake =  in.nextInt();
        int key;
        for(int i = 0;i<snake;i++){
            key = in.nextInt();
            props.setSnakes(key,in.nextInt());
        }
        System.out.println();

        System.out.println("Enter the number of ladders and its positions");
        int ladder =  in.nextInt();
        for(int i = 0;i<ladder;i++){
            key = in.nextInt();
            props.setLadders(key,in.nextInt());
        }
        System.out.println();

        System.out.println("Enter the number of players and their names");
        int players = in.nextInt();
        if(players == 0){
            throw new Exception("Player count can be 0");
        }
        for(int i=0;i<players;i++){
            Player player = new Player(in.next());
            props.setPlayers(player);
        }
        System.out.println();

        //game starts
        do {
            Player player = props.getPlayers().poll();
            int roll = dice.getNumberOfDice();
            assert player != null; //This assertion checks that the variable player is not null at this point in the code
            System.out.print(player.getPlayername()+" rolled a "+ roll);
            int newPosition = roll+ player.getPosition();

            if(juristiction(newPosition)){
                if(props.getSnakes().get(newPosition)!=null){ //eaten by snake
                    System.out.print(" and moved from "+ player.getPosition()+ " to ");
                    player.setPosition(props.getSnakes().get(newPosition));
                    System.out.print(player.getPosition()+" snake dinner");
                }
                else if (props.getLadders().get(newPosition)!=null) { //ladder ride
                    System.out.print(" and moved from "+ player.getPosition()+ " to ");
                    player.setPosition(props.getLadders().get(newPosition));
                    System.out.print(player.getPosition()+" ladder ride");
                }
                else{ //normal ride
                    System.out.print(" and moved from "+ player.getPosition()+ " to ");
                    player.setPosition(newPosition);
                    System.out.print(player.getPosition());
                }
            }
           props.setPlayers(player); //add in the back of the queue

        }while(!gameEnded(props.getPlayers().getLast()));


    }
    public boolean juristiction(int num){ //check if inbound of the board
        return num <= 100;
    }
    public boolean gameEnded(Player player){
        if(player.getPosition() == 100){
            System.out.println();
            System.out.print(player.getPlayername()+" won the game!");
            return true;
        }
        System.out.println();
        return false;
    }
}
