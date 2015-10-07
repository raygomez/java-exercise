package project;

public class Player {

    private InputStrategy strategy;
    private char sign;
    private String name;


    void setSign(char sign) {
        this.sign = sign;
    }

    char getSign() {
        return sign;
    }

    void setStrategy(InputStrategy strategy) {
        this.strategy = strategy;
    }

    Turn getTurn() {
        return strategy.execute();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
