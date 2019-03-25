package ObjectsLab;

public interface Gambler {

    double getBalance();

    Team pickTeam(Team[] teams);

    void addwin(int money);

    void addloss(int money);

    int getBalance();

}
