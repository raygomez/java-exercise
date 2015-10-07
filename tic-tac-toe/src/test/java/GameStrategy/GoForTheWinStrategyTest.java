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

        board.set('X', 0, 1);
        board.set('X', 0, 2);

        Turn result = strategy.execute();

        assertTrue(strategy.isSolved());
        assertEquals(0, result.row);
        assertEquals(0, result.column);

    }

    @Test
    public void testAtOtherNECorner(){
        Board board = new Board();

        GoForTheWinStrategy strategy = new GoForTheWinStrategy(board, 'X');

        board.set('X', 1, 0);
        board.set('X', 2, 0);

        Turn result = strategy.execute();

        assertTrue(strategy.isSolved());
        assertEquals(0, result.row);
        assertEquals(0, result.column);

    }

    @Test
    public void testAtNECornerWithOtherPlayer(){
        Board board = new Board();

        GoForTheWinStrategy strategy = new GoForTheWinStrategy(board, 'X');

        board.set('X', 1, 0);
        board.set('O', 2, 0);

        Turn result = strategy.execute();

        assertFalse(strategy.isSolved());
        assertNull(result);

    }

    @Test
    public void testAtOtherMissingCorner(){
        Board board = new Board();

        GoForTheWinStrategy strategy = new GoForTheWinStrategy(board, 'X');

        board.set('X', 1, 0);

        Turn result = strategy.execute();

        assertFalse(strategy.isSolved());
        assertNull(result);

    }

}