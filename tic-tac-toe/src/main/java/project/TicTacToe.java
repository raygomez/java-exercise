package project;

public class TicTacToe
{

    private Board board = new Board();
    Player players[]= new Player[2];
    Player player = null;
    Player winner = null;

    public void start() {

        initializePlayer1();
        initializePlayer2();

        player = players[1];

        while((winner == null) && !board.isFull()) {
            announcePlayerTurn();
            Turn turn = player.getTurn();
            if(board.isValidTurn(turn)){
                board.set(player.getSign(), turn);
                board.display();
                if(board.hasWinner()){
                    winner = player;
                } else {
                    player = getNextPlayer();
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

    private void logInvalidTurn(Turn turn) {
        System.out.format("Invalid input: %d %d\n", turn.row, turn.column);
    }

    private void announceWinner() {
        System.out.format("Winner is %s.\n" + winner.getName());
    }

    private void announceDraw() {
        System.out.println("It's a draw.");
    }

    private void initializePlayer2() {
        Player p2 = new Player();
        p2.setStrategy(new HumanInputStrategy());
        p2.setSign('X');
        p2.setName("Player 2");
        players[1] = p2;
    }

    private void initializePlayer1() {
        Player p1 = new Player();
        p1.setStrategy(new HumanInputStrategy());
        p1.setSign('O');
        p1.setName("Player 1");
        players[0] = p1;
    }

    private void announcePlayerTurn() {
        System.out.format("It is %s's turn\n", player.getName());
    }

    private boolean hasWinner() {
        return winner != null;
    }

    public Player getNextPlayer() {
        return player == players[0] ? players[1] : players[0];
    }
}
