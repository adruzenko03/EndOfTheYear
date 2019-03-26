package ObjectsLab;

public interface Gambler {

    double getBalance();

    boolean[] getWins_Losses();

    Team pickTeam(Team[] teams);

    void bet(int money, Team[] team);

}
