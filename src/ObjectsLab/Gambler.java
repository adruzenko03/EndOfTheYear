package ObjectsLab;

public interface Gambler {

    double getMoney();

    boolean[] getWins_Losses();

    Team pickTeam(Team[] teams);

    void bet(int money, Team team);


}
