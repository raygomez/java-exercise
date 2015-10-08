package GameStrategy;

import GameStrategy.GoForTheWinStrategy;

import org.junit.Before;
import org.junit.Test;
import project.Board;
import project.Turn;

import static org.junit.Assert.*;

public class GoForTheWinStrategyTest {


    private Board board;
    private GoForTheWinStrategy strategy;

    @Before
    public void setUp(){
        board = new Board();
        strategy = new GoForTheWinStrategy(board, 'X');
    }

    @Test
    public void testAtNECorner(){

        board.set('X', 0, 1);
        board.set('X', 0, 2);

        Turn result = strategy.execute();

        assertTrue(strategy.isSolved());
        assertEquals(0, result.row);
        assertEquals(0, result.column);

    }

    @Test
    public void testAtOtherNECorner(){
        board.set('X', 1, 0);
        board.set('X', 2, 0);

        Turn result = strategy.execute();

        assertTrue(strategy.isSolved());
        assertEquals(0, result.row);
        assertEquals(0, result.column);

    }

    @Test
    public void testAtNECornerWithOtherPlayer(){
        board.set('X', 1, 0);
        board.set('O', 2, 0);

        Turn result = strategy.execute();

        assertFalse(strategy.isSolved());
        assertNull(result);

    }

    @Test
    public void testAtOtherMissingCorner(){
        board.set('X', 1, 0);

        Turn result = strategy.execute();

        assertFalse(strategy.isSolved());
        assertNull(result);

    }

    @Test
    public void testMiddleInDiagonal(){
        board.set('X', 0, 0);
        board.set('X', 2, 2);

        Turn result = strategy.execute();

        assertTrue(strategy.isSolved());
        assertEquals(1, result.row);
        assertEquals(1, result.column);

    }

    @Test
    public void testMiddleInOtherDiagonal(){
        board.set('X', 0, 2);
        board.set('X', 2, 0);

        Turn result = strategy.execute();

        assertTrue(strategy.isSolved());
        assertEquals(1, result.row);
        assertEquals(1, result.column);

    }

}