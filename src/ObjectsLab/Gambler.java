package ObjectsLab;

import java.util.ArrayList;

public interface Gambler {
    double beStolenFrom();

    void bet(Team[] team);

    void winBet (Team winningTeam);

    double getBalance();

    Bet getCurrentBet();

    ArrayList<Bet> getBetHistory();

}
