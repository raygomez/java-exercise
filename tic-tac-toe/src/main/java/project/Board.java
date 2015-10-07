package project;

public class Board {

    char [][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

     boolean isFull(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++ ){
                if(board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    void set(char player, Turn turn){
        board[turn.row][turn.column] = player;
    }


    public boolean isValidTurn(Turn turn){
        return board[turn.row][turn.column] == ' ';
    }

    void display(){
        System.out.println("=============");
        System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("=============\n");
    }


    boolean hasWinner() {

//        [0,0][0,1][0,2]
//        [1,0][1,1][1,2]
//        [2,0][2,1][2,2]
        char scan = board[0][0];
        if (scan != ' ') {
            if(board[0][0] == board[0][1] && board[0][0] == board[0][2]) {
                return true;
            }
            if(board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
                return true;
            }
            if(board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                return true;
            }
        }

        scan = board[1][1];
        if (scan != ' '){
            if(board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
                return true;
            }
            if(board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
                return true;
            }
            if(board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                return true;
            }
        }

        scan = board[2][2];
        if (scan != ' '){
            if(board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
                return true;
            }
            if(board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
                return true;
            }
        }

        return false;
    }

    public char getSign(int row, int column) {
        return board[row][column];
    }
}
