package GameStrategy;

import project.Board;
import project.Turn;

public class FindFirstEmptyTile implements GameStrategy {

    private boolean solved = false;
    private final Board board;

    public FindFirstEmptyTile(Board board) {
        this.board = board;
    }

    public Turn execute() {

        solved = false;
        Turn turn = new Turn();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                turn.row = i;
                turn.column = j;
                if (board.isValidTurn(turn)) {
                    solved = true;
                    return turn;
                }
            }
        }
        return null;
    }

    public boolean isSolved() {
        return solved;
    }
}
