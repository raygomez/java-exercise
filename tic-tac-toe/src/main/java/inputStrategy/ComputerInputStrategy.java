package inputStrategy;

import GameStrategy.FindFirstEmptyTile;
import GameStrategy.GameStrategy;
import GameStrategy.GoForTheWinStrategy;
import project.Board;
import project.Turn;

import java.util.ArrayList;
import java.util.List;

public class ComputerInputStrategy implements InputStrategy {

    private Board board;
    private char sign;
    private List<GameStrategy> strategies = new ArrayList<GameStrategy>();

    public ComputerInputStrategy(Board board, char sign){
        this.board = board;
        this.sign = sign;
        strategies.add(new GoForTheWinStrategy(board, sign));
        strategies.add(new FindFirstEmptyTile(board));
    }

    public Turn execute() {

        Turn turn = null;
        for (GameStrategy s: strategies) {
            turn = s.execute();
            if(s.isSolved()) {
                break;
            }
        }

        if(turn != null) return turn;
        throw new RuntimeException("No possible turn.");
    }
}
