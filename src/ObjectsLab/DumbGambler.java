package ObjectsLab;

public class DumbGambler implements Gambler {
    private double balance;
    private Bet[] betHistory;
    private Bet currentBet;


    public DumbGambler(double balance) {
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
