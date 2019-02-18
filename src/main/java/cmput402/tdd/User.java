package cmput402.tdd;


import cmput402.tdd.game.Game;

public class User {


    private int balance;
    private Game currentGame;

    public User() {
        balance = 0;
    }

    public int getBalance() {
        return this.balance;
    }

    public void addBalance(int addition) {
        this.balance += addition;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game nextGame) {
        this.currentGame = nextGame;
    }
}
