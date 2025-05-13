import java.util.ArrayList;

public class POI extends Attraction {
    private String category;
    private ArrayList<String> comments;

    public POI(String id, String title, String location, double rating, String category) {
        super(id, title, location, rating);
        this.category = category;
        this.comments = new ArrayList<>();
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    @Override
    public String getDetails() {
        return "Category: " + category + ", Comments: " + comments.size();
    }
}

