package project;

import java.util.Random;

public class TicTacToe
{

    private Board board = new Board();
    Player players[]= new Player[2];
    Player currentPlayer = null;
    Player winner = null;

    public void start() {

        initializePlayer1();
        initializePlayer2();

        getFirstPlayer();

        while((winner == null) && !board.isFull()) {
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

    private void getFirstPlayer() {
        Random random = new Random();
        currentPlayer = random.nextBoolean() ? players[0] : players[1];
        System.out.format("%s is the first player.\n", currentPlayer.getName());
    }

    private void initializePlayer1() {
        Player p1 = new Player();
        p1.setStrategy(new HumanInputStrategy());
        p1.setSign('O');
        p1.setName("Player 1");
        players[0] = p1;
    }

    private void initializePlayer2() {
        Player p2 = new Player();
        p2.setStrategy(new ComputerInputStrategy(board));
        p2.setSign('X');
        p2.setName("Computer");
        players[1] = p2;
    }


    private void announcePlayerTurn() {
        System.out.format("It is %s's turn.\n", currentPlayer.getName());
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

    public Player getNextPlayer() {
        return currentPlayer == players[0] ? players[1] : players[0];
    }
}
