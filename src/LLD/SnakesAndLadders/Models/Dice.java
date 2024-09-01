package LLD.SnakesAndLadders.Models;

import java.util.Random;

public class Dice {
    Random random;
    int numberOfDice;
    public  Dice(int number){
        random = new Random();
        this.numberOfDice = number;
    }

    public int getNumberOfDice(){
        return random.nextInt(this.numberOfDice) + 1;
        //return random.nextInt((this.numberOfDice - MIN) + 1) + 1; ??
    }


}
