package ObjectsLab;

import java.util.ArrayList;

public interface Gambler {
    double stealFrom();

    void bet(Team[] team);

    void winBet (Team winningTeam);

    double getBalance();

    Bet getCurrentBet();

    ArrayList<Bet> getBetHistory();

}
