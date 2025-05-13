public class destination implements java.io.Serializable {
    private String start;
    private String end;
    private String transport;

    public destination(String start, String end, String transport) {
        this.start = start;
        this.end = end;
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "Από: " + start + " → Προς: " + end + " (Μέσο: " + transport + ")";
    }
}

