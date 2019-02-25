package cmput402.tdd.game;

import cmput402.tdd.User;

public abstract class Game {

    private int currentBet;

    abstract public void playGame();

    public final void winBet(User user) {
        user.addBalance(this.currentBet * 2);
        this.currentBet = 0;
    }

    public final boolean placeBet(User user, int amount) {
        boolean returnValue = user.placeBet(amount);
        if (returnValue) {
            currentBet = amount;
        }

        return returnValue;
    }

    public final int getBet() {
        return currentBet;
    }

    public final void promptBet() {

    }
}
