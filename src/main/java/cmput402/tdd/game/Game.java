package cmput402.tdd.game;

import cmput402.tdd.User;

public abstract class Game {

    private int currentBet;

    abstract public void playGame();

    public final void giveBalance(User user, int amount) {
    }

    public final boolean placeBet(User user, int amount) {
        return true;
    }

    public final int getBet() {
        return 0;
    }
}
