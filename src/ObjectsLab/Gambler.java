package ObjectsLab;

public interface Gambler {

    double getBalance();

    Team pickTeam(Team[] teams);

    void addwin(double money);

    void addloss(double money);


}
