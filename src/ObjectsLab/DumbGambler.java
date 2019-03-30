package ObjectsLab;

import java.util.ArrayList;
import java.util.Random;

public class DumbGambler implements Gambler {
    private double balance;
    private ArrayList<Bet> betHistory;
    private Bet currentBet;


    public DumbGambler(double balance) {
        this.balance = balance;
        betHistory=new ArrayList<Bet>();
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
