package inputStrategy;

import org.junit.Test;
import project.Board;
import project.Turn;

import static org.junit.Assert.*;

public class ComputerInputStrategyTest {


    @Test
    public void testUseStrategies(){

        Board board = new Board();
        ComputerInputStrategy strategy = new ComputerInputStrategy(board, 'X');

        Turn turn = strategy.execute();
        assertEquals(0, turn.row);
        assertEquals(0, turn.column);
        board.set('X', turn);

        board.set('O', 1, 1);

        turn = strategy.execute();
        assertEquals(0, turn.row);
        assertEquals(1, turn.column);
        board.set('X', turn);

        board.set('O', 0, 2);

        turn = strategy.execute();
        assertEquals(2, turn.row);
        assertEquals(0, turn.column);
        board.set('X', turn);

        board.set('O', 1, 0);

        turn = strategy.execute();
        assertEquals(1, turn.row);
        assertEquals(2, turn.column);
        board.set('X', turn);

        board.set('O', 2, 1);

        turn = strategy.execute();
        assertEquals(2, turn.row);
        assertEquals(2, turn.column);
        board.set('X', turn);

    }

}