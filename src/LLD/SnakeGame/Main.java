package LLD.SnakeGame;

import java.util.Scanner;
//https://github.com/B-Rajagopalan/CodingAtti-YouTube/blob/main/Zoho_AdvancedProgramming_Round3/src/snakeGame/SnakeIterative.java
//https://www.youtube.com/watch?v=Q8OLVseCSVA&list=PLjq3dI1OpGjj6jgnKx8RfIMDakH7rpSYR&index=5
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter board size(should be greater than 4): ");
        int n = in.nextInt();
//        SnakeGame game = new SnakeGame(n);
//        game.snakeMove(0,0);
        SnakeGameIterative game = new SnakeGameIterative(n);
        game.snakeGame();
    }
}
