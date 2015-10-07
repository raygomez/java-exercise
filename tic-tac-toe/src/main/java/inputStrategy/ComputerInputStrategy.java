package inputStrategy;

import GameStrategy.FindFirstEmptyTile;
import GameStrategy.GameStrategy;
import project.Board;
import project.Turn;

import java.util.ArrayList;

public class ComputerInputStrategy implements InputStrategy {

    private Board board;
    private ArrayList<GameStrategy> strategies = new ArrayList<GameStrategy>();

    public ComputerInputStrategy(Board board){
        this.board = board;
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
