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

        solved = false;
        Turn tile = new Turn();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                tile.row = i;
                tile.column = j;

                if(board.isValidTurn(tile)){
                    int left = j > 0  ? j - 1 : 2;
                    int right = j == 2 ? 0 : j + 1;

                    if((board.getSign(tile.row, left) == this.sign) &&
                            (board.getSign(tile.row, right) == this.sign)) {
                        solved = true;
                        return tile;
                    }

                    int up = i > 0 ? i - 1 : 2;
                    int down = i == 2 ? 0 : i + 1;

                    if((board.getSign(up, tile.column) == this.sign) &&
                            (board.getSign(down, tile.column) == this.sign)) {
                        solved = true;
                        return tile;
                    }

                }
            }
        }

        for(int i = 0; i < 3; i++) {
            tile.row = i;
            tile.column = i;

            if(board.isValidTurn(tile)) {
                int nw = i > 0 ? i - 1 : 2;
                int se = i == 2 ? 0 : i + 1;

                if((board.getSign(nw, nw) == this.sign) &&
                        (board.getSign(se, se) == this.sign)) {
                    solved = true;
                    return tile;
                }
            }


            tile.row = i;
            tile.column = 2 - i;

            if(board.isValidTurn(tile)) {
                int row = tile.row;
                int col = tile.column;

                int neR = row > 0 ? row - 1 : 2;
                int neC = col == 2 ? 0 : col + 1;

                int swR = row == 2 ? 0 : row + 1;
                int swC = col > 0 ? col - 1 : 2;

                if((board.getSign(neR, neC) == this.sign) &&
                        (board.getSign(swR, swC) == this.sign)) {
                    solved = true;
                    return tile;
                }
            }

        }

        return null;
    }

    public boolean isSolved() {
        return solved;
    }
}
