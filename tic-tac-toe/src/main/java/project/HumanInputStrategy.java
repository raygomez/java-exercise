package project;

import java.util.Scanner;

public class HumanInputStrategy implements InputStrategy {

    public Turn execute() {

        Scanner userInput = new Scanner(System.in);

        Turn turn = new Turn();
        turn.row = Integer.parseInt(userInput.next());
        turn.column = Integer.parseInt(userInput.next());

        return turn;
    }
}
