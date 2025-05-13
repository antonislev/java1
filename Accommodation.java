public class Accommodation extends Attraction {
    private double costPerNight;

    public Accommodation(String id, String title, String location, double rating, double costPerNight) {
        super(id, title, location, rating);
        this.costPerNight = costPerNight;
    }

    @Override
    public String getDetails() {
        return "Κόστος/Βραδιά: " + costPerNight + "€";
    }
}

