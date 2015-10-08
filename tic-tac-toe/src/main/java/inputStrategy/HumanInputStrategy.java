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
        return Integer.parseInt(userInput.next());
    }

    private int getColumn(){
        return Integer.parseInt(userInput.next());
    }

}
