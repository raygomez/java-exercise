package project;

import inputStrategy.ComputerInputStrategy;
import inputStrategy.HumanInputStrategy;

import java.util.Random;
import java.util.Scanner;

class TicTacToe
{

    private final Board board = new Board();
    private final Player[] players= new Player[2];
    private Player currentPlayer = null;
    private Player winner = null;

    public void start() {

        initializeHumanPlayer();
        initializeComputerPlayer();

        selectFirstPlayer();

        while(!hasWinner() && !board.isFull()) {
            announcePlayerTurn();
            Turn turn = currentPlayer.getTurn();
            if(board.isValidTurn(turn)){
                board.set(currentPlayer.getSign(), turn);
                board.display();
                if(board.hasWinner()){
                    winner = currentPlayer;
                } else {
                    currentPlayer = getNextPlayer();
                }
            } else {
                logInvalidTurn(turn);
            }
        }
        if(hasWinner()) {
            announceWinner();
        } else {
            announceDraw();
        }

    }

    private void selectFirstPlayer() {
        Random random = new Random();
        currentPlayer = random.nextBoolean() ? players[0] : players[1];
        System.out.format("%s is the first player.\n", currentPlayer.getName());
    }

    private void initializeHumanPlayer() {
        Player p1 = new Player();
        p1.setStrategy(new HumanInputStrategy());
        p1.setSign(getPreferredSign());
        p1.setName("Player 1");
        players[0] = p1;
    }

    private char getPreferredSign() {

        System.out.print("Please select your sign [X or O]: ");
        Scanner userInput = new Scanner(System.in);

        char sign;
        while(true) {
            String input = userInput.nextLine();

            if(input.length() == 1) {
                sign = input.charAt(0);
                if(sign == 'X' || sign == 'O' ) break;
            }
            System.out.print("Please select your sign [X or O]: ");
        }

        return sign;
    }

    private void initializeComputerPlayer() {
        Player p2 = new Player();
        p2.setSign(getComputerSign());
        p2.setStrategy(new ComputerInputStrategy(board, p2.getSign()));
        p2.setName("Computer");
        players[1] = p2;
    }

    private char getComputerSign() {
        return players[0].getSign() == 'X' ? 'O' : 'X';
    }


    private void announcePlayerTurn() {
        System.out.format("It is %s's turn.\n\n", currentPlayer.getName());
    }

    private void logInvalidTurn(Turn turn) {
        System.out.format("Invalid input: %d %d\n", turn.row, turn.column);
    }

    private void announceWinner() {
        System.out.format("Winner is %s.\n", winner.getName());
    }

    private void announceDraw() {
        System.out.println("It's a draw.");
    }

    private boolean hasWinner() {
        return winner != null;
    }

    private Player getNextPlayer() {
        return currentPlayer == players[0] ? players[1] : players[0];
    }
}
