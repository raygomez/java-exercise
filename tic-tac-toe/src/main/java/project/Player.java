package project;

public class Player {

    InputStrategy strategy;

    void setStrategy(InputStrategy strategy) {
        this.strategy = strategy;
    }

    Turn getTurn() {
        return strategy.execute();
    }
}
