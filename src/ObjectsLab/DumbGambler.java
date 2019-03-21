package ObjectsLab;

public class DumbGambler implements Gambler {
    private double balance;

    public DumbGambler(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return 0.0;
    }
}
