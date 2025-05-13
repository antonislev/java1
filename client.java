import java.io.Serializable;

public class client implements Serializable {
    private String name;
    private String email;

    public client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " <" + email + ">";
    }
}
