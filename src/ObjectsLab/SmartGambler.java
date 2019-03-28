package ObjectsLab;

public class SmartGambler implements Gambler {
    private double balance;
    Bet[] betHistory;
    Bet currentBet;

    public SmartGambler(double balance) {
        this.balance = balance;
    }

    public void bet(Team[] team) {

    }

    public void winBet (Team winningTeam) {

    }

    public Bet getCurrentBet() {
        return currentBet;
    }

    public Bet[] getBetHistory() {
        return betHistory;
    }

    public double getBalance() {
        return balance;
    }

}
