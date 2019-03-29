package ObjectsLab;

import java.util.Random;

public class DumbGambler implements Gambler {
    private double balance;
    private Bet[] betHistory;
    private Bet currentBet;


    public DumbGambler(double balance) {
        this.balance = balance;
    }

    public void bet(Team[] team) {
        Random r = new Random();
        int teamSelect = r.nextInt(team.length), otherTeam = r.nextInt(team.length);

        while (otherTeam == teamSelect) {
            otherTeam = r.nextInt(team.length);
        }

        currentBet = new Bet(10, team[teamSelect], team[otherTeam]);
        //how do we determine how much money they bet
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
