package project;

import java.util.Scanner;

public class HumanInputStrategy implements InputStrategy {

    Scanner userInput = new Scanner(System.in);

    public Turn execute() {

        Turn turn = new Turn();

        turn.row = Integer.parseInt(userInput.next());
        turn.column = Integer.parseInt(userInput.next());

        return turn;
    }
}
