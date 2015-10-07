package project;

public class ComputerInputStrategy implements InputStrategy {

    private Board board;

    public ComputerInputStrategy(Board board){
        this.board = board;
    }

    public Turn execute() {
        Turn turn = new Turn();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                turn.row = i;
                turn.column = j;
                if (board.isValidTurn(turn))
                    return turn;
            }
        }

        throw new RuntimeException("No possible turn");
    }
}
