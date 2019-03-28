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


}
