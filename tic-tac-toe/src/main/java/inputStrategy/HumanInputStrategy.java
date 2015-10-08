package inputStrategy;

import project.Turn;

import java.util.Scanner;

public class HumanInputStrategy implements InputStrategy {

    Scanner userInput = new Scanner(System.in);

    public Turn execute() {


        Turn turn = new Turn();
        turn.row = getRow();
        turn.column = getColumn();

        return turn;
    }

    private int getRow(){


        int row;

        String input;
        while(true) {
            System.out.print("Enter row:");
            input = userInput.nextLine();

            if(input.matches("\\d")) {
                row = Integer.parseInt(input);
                if((row < 3) && (row > -1)){
                    break;
                }
            }
        }
        return row;
    }

    private int getColumn(){

        int column;

        String input;
        while(true) {
            System.out.print("Enter column:");
            input = userInput.nextLine();

            if(input.matches("\\d")) {
                column = Integer.parseInt(input);
                if((column < 3) && (column > -1)){
                    break;
                }
            }

        }
        return column;
    }
}
