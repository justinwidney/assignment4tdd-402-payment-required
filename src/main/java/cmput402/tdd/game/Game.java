package cmput402.tdd.game;

import cmput402.tdd.App;
import cmput402.tdd.IntegerAsker;
import cmput402.tdd.User;

public abstract class Game {

    private int currentBet;
    public User user;

    abstract public void playGame();

    public final void winBet() {
        this.user.addBalance(this.currentBet * 2);
        this.currentBet = 0;
    }

    public final void loseBet() {
        this.currentBet = 0;
    }

    public final boolean placeBet(int amount) {
        boolean returnValue = this.user.placeBet(amount);
        if (returnValue) {
            currentBet = amount;
        }
        return returnValue;
    }

    public final int getBet() {
        return currentBet;
    }

    public final void promptBet() {
        int bet = App.getUserBet(new IntegerAsker(System.in, System.out), this.user);
        boolean finished = false;
        while (!finished) {
            finished = this.user.placeBet(bet);
            if (finished) {
                break;
            }
            bet = App.getUserBet(new IntegerAsker(System.in, System.out), this.user);
        }
        this.currentBet = bet;
    }

}
