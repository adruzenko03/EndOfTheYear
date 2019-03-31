package ObjectsLab;

import java.util.ArrayList;

public class SmartGambler implements Gambler {
    private double balance;
    private ArrayList<Bet> betHistory;
    private Bet currentBet;

    public SmartGambler(double balance) {
        this.balance = balance;
    }

    public void bet(Team[] team) {
        if(currentBet==null) {
            /*HUGE PROBLEM wont work, score is entered after game played, should be done based on deathchance of player.
            int bestTeamIndex = 0, highestScore = 0;
            for (int t = 0; t < team.length; t++) {
                if (team[t].score > highestScore) {
                    highestScore = team[t].score;
                    bestTeamIndex = t;
                }
            }*/
            int bestTeamIndex=0;
            for (int t = 0; t < team.length; t++) {

            }
        }

        //currentBet = new Bet(10, bestTeamIndex)
        else{
            System.out.println("Bet in play, only make one bet at a time");
        }
    }

    public void winBet (Team winningTeam) {
        if(currentBet==null)
            throw new NullPointerException();
        currentBet.winBet(winningTeam);
        if(currentBet.getBetStatus()){
            balance+=currentBet.getMoney();
        }
        else{
            balance-=currentBet.getMoney();
        }
        if(balance<0)
            balance=0;
        betHistory.add(currentBet);
        currentBet=null;
    }
    public double stealFrom(){

        double moneystolen=balance*.25;
        balance-=moneystolen;
        if(balance<0)
            balance=0;
        return moneystolen;
    }

    public Bet getCurrentBet() {
        return currentBet;
    }

    public ArrayList<Bet> getBetHistory() {
        return betHistory;
    }

    public double getBalance() {
        return balance;
    }

}
