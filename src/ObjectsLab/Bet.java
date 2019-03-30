package ObjectsLab;


public class Bet {
    private double money;
    private Team pickedTeam;
    private Team otherTeam;
    private Boolean betWon;

    public Bet(double money, Team pickedTeam,Team otherTeam){
        this.money=money;
        this.otherTeam=otherTeam;
        this.pickedTeam=pickedTeam;
    }
    public void winBet(Team winningTeam){
        if (pickedTeam.equals(winningTeam))
            betWon = true;
        else
            betWon = false;

    }
//    private Team winningTeam(){
//        if (pickedTeam.getScore != otherTeam.getScore())
//            return pickedTeam.getScore > otherTeam.getScore ? pickedTeam : otherTeam;
//
//        return (new Team[] {pickedTeam, otherTeam})[(new Random()).nextInt(2)];
//    }
    public double getMoney(){
        return money;
    }
    public boolean getBetStatus(){
        return betWon;
    }


}
