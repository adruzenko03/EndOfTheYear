package ObjectsLab;

import java.util.ArrayList;
import java.util.Random;

public class SmartGambler implements Gambler {
    private double balance;
    private ArrayList<Bet> betHistory;
    private Bet currentBet;

    public SmartGambler(double balance) {
        this.balance = balance;
    }

    public void bet(Team[] team) {
        int[] teamdeathaverage=new int[team.length];
        int  currentcalculation=0;
        int teamSelect=0;
        int leastdeathChance=Integer.MAX_VALUE;
        Random r = new Random();
        int otherTeam = r.nextInt(team.length);

        if(currentBet==null) {
            /*HUGE PROBLEM wont work, score is entered after game played, should be done based on deathchance of player.
            int bestTeamIndex = 0, highestScore = 0;
            for (int t = 0; t < team.length; t++) {
                if (team[t].score > highestScore) {
                    highestScore = team[t].score;
                    bestTeamIndex = t;
                }
            }*/

            for (int teamloop = 0; teamloop < team.length; teamloop++) {
                for(int player =0;player<team[teamloop].amountOfPlayers();player++){
                    currentcalculation+=team[teamloop].getPlayer(player).getDeathChance();
                }
                currentcalculation/=team[teamloop].amountOfPlayers();
                teamdeathaverage[teamloop]=currentcalculation;
            }
            for(int teamloop2=0;teamloop2<teamdeathaverage.length;teamloop2++){
                if(teamdeathaverage[teamloop2]<leastdeathChance){
                    teamSelect=teamloop2;
                    leastdeathChance=teamdeathaverage[teamloop2];
                }
            }

            while (otherTeam == teamSelect) {
                otherTeam = r.nextInt(team.length);
            }
            currentBet = new Bet(10/*balance * BETVALS[r.nextInt(BETVALS.length)]*/, team[teamSelect], team[otherTeam]);
        }

        //currentBet = new Bet(10, bestTeamIndex)
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