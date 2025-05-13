import java.io.Serializable;

public class cost implements Serializable {
    private double amount;
    private String description;

    public cost(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return amount + "€ - " + description;
    }
}
