package ObjectsLab;

import java.util.ArrayList;
import java.util.Random;

public class AddictedGambler implements Gambler {
    private double balance;
    private ArrayList<Bet> betHistory;
    private Bet currentBet;
    private ArrayList<Gambler> stealoptions=null;

    public AddictedGambler(double balance) {
        this.balance = balance;
        stealoptions=new ArrayList<Gambler>();
    }

    public void bet(Team[] team) {
        if(currentBet==null) {
            //teamselect copied from gambler, we need to make it unique.
            Random r = new Random();
            int teamSelect = r.nextInt(team.length), otherTeam = r.nextInt(team.length);

            while (otherTeam == teamSelect) {
                otherTeam = r.nextInt(team.length);
            }

            currentBet = new Bet(balance, team[teamSelect], team[otherTeam]);
\
        }
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
        if(balance==0)
            steal();

        betHistory.add(currentBet);
        currentBet=null;
    }
    private void steal(){
        Gambler unlucky=stealoptions.get(new Random().nextInt(stealoptions.size()));
        balance+=unlucky.stealFrom();
        //we need to add a thing in each gambler to steal from them.
    }
    public void addStealOptions(Gambler g){
        stealoptions.add(g);
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

    //public boolean stealMoney()
}
