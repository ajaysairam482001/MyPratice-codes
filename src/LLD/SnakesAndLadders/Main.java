package LLD.SnakesAndLadders;

import LLD.SnakesAndLadders.Models.Dice;
import LLD.SnakesAndLadders.Service.PlayGame;
//(Github)
////https://github.com/lavakumarThatisetti/Machine-Coding-Round/blob/master/src/com/lavakumar/snakeandladder/service/PlaySnakeAndLadder.java
//Question Link:
//https://workat.tech/machine-coding/practice/snake-and-ladder-problem-zgtac9lxwntg
//https://www.youtube.com/watch?v=na3DQv8ZAD8

public class Main {
    public static void main(String[] args) throws Exception {
//        Dice dice = new Dice(6);
//        for(int i = 0;i<=20;i++){
//            System.out.print(dice.getNumberOfDice()+" ");
//        }

        PlayGame game = new PlayGame();
        game.play();
    }
}
