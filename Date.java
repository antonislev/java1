import java.io.Serializable;
import java.time.LocalDate;

public class Date implements Serializable {
    private LocalDate date;
    private String description;

    public Date(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return date.toString() + " → " + description;
    }
}
