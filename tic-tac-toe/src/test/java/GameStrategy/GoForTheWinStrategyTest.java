package GameStrategy;

import GameStrategy.GoForTheWinStrategy;

import org.junit.Test;
import project.Board;
import project.Turn;

import static org.junit.Assert.*;

public class GoForTheWinStrategyTest {

    @Test
    public void testAtNECorner(){
        Board board = new Board();

        GoForTheWinStrategy strategy = new GoForTheWinStrategy(board, 'X');

        Turn turn = new Turn();
        turn.row = 1;
        turn.column = 1;
        board.set('X', turn);

        turn.row = 2;
        turn.column = 1;
        board.set('X', turn);

        Turn result = strategy.execute();

        assertTrue(strategy.isSolved());
        assertEquals(0, result.row);
        assertEquals(1, result.column);

    }
}