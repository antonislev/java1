public class Food extends Attraction {
    private String type;

    public Food(String id, String title, String location, double rating, String type) {
        super(id, title, location, rating);
        this.type = type;
    }

    @Override
    public String getDetails() {
        return "Τύπος φαγητού: " + type;
    }
}
