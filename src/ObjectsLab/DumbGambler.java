package ObjectsLab;

import java.util.ArrayList;
import java.util.Random;

public class DumbGambler implements Gambler {
    private double balance;
    private final double[] BETVALS={.5,.25,.1,.01,.30,.40};
    private ArrayList<Bet> betHistory;
    private Bet currentBet;


    public DumbGambler(double balance) {
        this.balance = balance;
        betHistory=new ArrayList<Bet>();
    }

    public void bet(Team[] team) {
        if(currentBet==null&&balance!=0) {
            Random r = new Random();
            int teamSelect = r.nextInt(team.length), otherTeam = r.nextInt(team.length);

            while (otherTeam == teamSelect) {
                otherTeam = r.nextInt(team.length);
            }

            currentBet = new Bet(balance * BETVALS[r.nextInt(BETVALS.length)], team[teamSelect], team[otherTeam]);
            //how do we determine how much money they bet
            //betval is percentage of balance betted
        }
        else{
            System.out.println("Bet already in play or you went broke");
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
    public double beStolenFrom(){

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
