package ObjectsLab;

public interface Gambler {

    void bet(Team[] team);

    void winBet (Team winningTeam);

    double getBalance();

    Bet getCurrentBet();

    Bet[] getBetHistory();

}
