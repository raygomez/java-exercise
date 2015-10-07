package project;

import java.util.Scanner;

public class TicTacToe
{

    private char winner;
    private char currentPlayer;
    private Board board = new Board();

    public void start() {

        char human1 = 'X';
        char human2 = 'O';
        char winner = '-';

        Scanner userInput = new Scanner(System.in);

        currentPlayer = 'X';

        while((winner == '-') && !board.isFull()) {

            int row = Integer.parseInt(userInput.next());
            int column = Integer.parseInt(userInput.next());

            if(board.isEmpty(row, column)){
                board.set(currentPlayer, row, column);
                board.display();
                if(board.hasWinner()){
                    winner = currentPlayer;
                } else {
                    currentPlayer = nextPlayer();
                }

            } else {
                System.out.println("Invalid input");
            }
        }
        if(winner != '-') {
            System.out.println("Winner is:" + winner);
        } else {
            System.out.println("It's a draw.");
        }

    }


    public static void main( String[] args )
    {
        TicTacToe ttt = new TicTacToe();
        ttt.start();
    }

    public char nextPlayer() {
        return currentPlayer == 'O' ? 'X' : 'O';
    }
}
