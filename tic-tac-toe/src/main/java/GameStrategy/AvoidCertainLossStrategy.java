package GameStrategy;

import project.Board;

public class AvoidCertainLossStrategy extends GoForTheWinStrategy {

    public AvoidCertainLossStrategy(Board board, char otherSign){
        super(board, otherSign);
    }
}
