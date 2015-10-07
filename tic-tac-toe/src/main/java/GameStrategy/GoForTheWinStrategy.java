package GameStrategy;

import project.Board;
import project.Turn;

public class GoForTheWinStrategy implements GameStrategy{

    private boolean solved = false;
    private Board board;
    private char sign;

    public GoForTheWinStrategy(Board board, char sign){
        this.board = board;
        this.sign = sign;
    }

    public Turn execute() {

        Turn tile = new Turn();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                tile.row = i;
                tile.column = j;

                if(board.isValidTurn(tile)){
                    int left = i > 0  ? i - 1 : 2;
                    int right = i == 2 ? 0 : i + 1;

                    if((board.getSign(tile.row, left) == this.sign) &&
                            (board.getSign(tile.row, right) == this.sign)) {
                        System.out.println("" + left + ","+ right);
                        solved = true;
                        return tile;
                    }

                    int up = j > 0 ? i - i : 2;
                    int down = j == 2 ? 0 : j + 1;

                    if((board.getSign(up, tile.column) == this.sign) &&
                            (board.getSign(down, tile.column) == this.sign)) {
                        System.out.println("" + up + ","+ down);
                        solved = true;
                        return tile;
                    }

                }
            }
        }

        return null;
    }

    public boolean isSolved() {
        return solved;
    }
}
