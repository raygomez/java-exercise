package GameStrategy;

import project.Turn;

public interface GameStrategy {

    Turn execute();
    boolean isSolved();
}
