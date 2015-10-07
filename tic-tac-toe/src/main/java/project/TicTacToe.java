package project;

import java.util.Scanner;

public class TicTacToe
{
    static char [][] board = {{'-','-','-'},{'-','-','-'},{'-','-','-'}};
    static char winner;
    static char currentPlayer;

    public static void main( String[] args )
    {

        char human1 = 'X';
        char human2 = 'O';
        char winner = '-';

        Scanner userInput = new Scanner(System.in);

        currentPlayer = 'X';

        while((winner == '-') && !isFull()) {

            int row = Integer.parseInt(userInput.next());
            int column = Integer.parseInt(userInput.next());

            if(isEmpty(row, column)){
                set(currentPlayer, row, column);

                displayBoard();
                if(won()){
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

    static boolean isFull(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++ ){
                if(board[i][j] == '-') return false;
            }
        }
        return true;
    }
    static char nextPlayer() {
        return currentPlayer == 'O' ? 'X' : 'O';
    }
    static void set(char player, int row, int column){
        board[row][column] = player;
    }


    static boolean isEmpty(int row, int column){
        return board[row][column] == '-';
    }

    static boolean won()
    {
//        [0,0][0,1][0,2]
//        [1,0][1,1][1,2]
//        [2,0][2,1][2,2]

        boolean win = false;
        //Rows
        if(board[0][0] == board[0][1] && board[0][0] == board[0][2]) {
            win = getWinningPlayer(board[0][0]);
        }
        if(board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
            win = getWinningPlayer(board[1][0]);
        }
        if(board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
            win = getWinningPlayer(board[2][0]);
        }
        //Column
        if(board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
            win = getWinningPlayer(board[0][0]);
        }
        if(board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
            win = getWinningPlayer(board[0][1]);
        }
        if(board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
            win = getWinningPlayer(board[0][2]);
        }

        //First diagonal
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            win = getWinningPlayer(board[0][0]);
        }

        //Second diagonal
        if(board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            win = getWinningPlayer(board[0][2]);
        }
        return win;
    }

    static private boolean getWinningPlayer(char player) {
        boolean win = false;
        if(player != '-'){
            win = true;
            winner = player;
        }
        return win;
    }

    static void displayBoard(){
        System.out.println("Board:");
        System.out.println("" + board[0][0] + board[0][1] + board[0][2]);
        System.out.println("" + board[1][0] + board[1][1] + board[1][2]);
        System.out.println("" + board[2][0] + board[2][1] + board[2][2]);
    }
}
