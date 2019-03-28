package ObjectsLab;

public class SmartGambler implements Gambler {
    private double balance;
    Bet[] wins_losses;
    Bet currentBet;

    public SmartGambler(double balance) {
        this.balance = balance;
    }

    public void bet(Team[] team) {

    }

    public void winBet (Team winningTeam) {

    }

    public Bet getCurrentBet() {

    }

    public Bet[] getBetHistory() {

    }

    public double getBalance() {
        return 0.0;
    }

}
