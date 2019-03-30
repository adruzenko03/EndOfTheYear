package ObjectsLab;

import java.util.ArrayList;

public interface Gambler {

    void bet(Team[] team);

    void winBet (Team winningTeam);

    double getBalance();

    Bet getCurrentBet();

    ArrayList<Bet> getBetHistory();

}
