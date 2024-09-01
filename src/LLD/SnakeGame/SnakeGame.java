package LLD.SnakeGame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeGame {
    private char[][] board = null;
    private Queue<Node> queue;
    private Queue<Node> food;

    public SnakeGame(int n){
        board = new char[n][n];
        queue = new LinkedList<>();
        queue.add(new Node(0,0)); //starting point

        food = new LinkedList<>();
        //add the food to be spawned after each eaten by snake
        food.add(new Node(1,1));
        food.add(new Node(5,4));
        food.add(new Node(3,3));
        food.add(new Node(0,5));
        displayFood(food.poll());
    }

    public void snakeMove(int r,int c){
        //inbounds check
        if(r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
            queue.add(new Node(r, c));

            //if there is no food
            if (board[r][c] != '0') {
                //remove the tail
                Node temp = queue.poll();
                assert temp != null;
                board[temp.getRow()][temp.getColumn()] = '\0';
            }


            //display the next food
            if (board[r][c] == '0') {
                if (food.isEmpty()) { //if empty terminate the program
                    System.out.println("Game Over!");
                    //move forward and end game
                    board[r][c] = '*';
                    printBoard();
                    System.exit(0);
                }
                displayFood(food.poll());
            }

            //snake biting itself
            if (board[r][c] == '*') {
                System.out.println("Game Over!");
                System.exit(0);
            }
            board[r][c] = '*';
            //After all checks print the board and proceed for next move
            printBoard();

            if (!queue.isEmpty()) {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter the position: ");
                char pos = in.next().charAt(0);
                System.out.println();
                if (pos == 'u' || pos == 'U') {
                    snakeMove(r-1, c);
                }
                if (pos == 'd' || pos == 'D') {
                    snakeMove(r+1, c);
                }
                if (pos == 'l' || pos == 'L') {
                    snakeMove(r, c-1);
                }
                if (pos == 'r' || pos == 'R') {
                    snakeMove(r, c+1);
                }
                else{
                    System.out.println("Enter valid direction.");
                    System.out.println();
                    snakeMove(r,c);
                }
            }
        }
        else {
            System.out.println("Invalid Move");
            System.exit(0);
        }

    }

    private void displayFood(Node node){
        board[node.getRow()][node.getColumn()] = '0';
    }

    private void printBoard(){
        for(char[] ch: board){
            for(int cj=0;cj< board.length;cj++){
                System.out.print(ch[cj]+" ");
            }
            System.out.println();
        }
    }
}
