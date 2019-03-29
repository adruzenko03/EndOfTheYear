package ObjectsLab;

public class SmartGambler implements Gambler {
    private double balance;
    Bet[] betHistory;
    Bet currentBet;

    public SmartGambler(double balance) {
        this.balance = balance;
    }

    public void bet(Team[] team) {
        int bestTeamIndex = 0, highestScore = 0;
        for (int t = 0; t < team.length; t++) {
            if (team[t].score > highestScore) {
                highestScore = team[t].score;
                bestTeamIndex = t;
            }
        }

        //currentBet = new Bet(10, bestTeamIndex)

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
