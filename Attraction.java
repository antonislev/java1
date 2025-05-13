import java.io.Serializable;
import java.util.ArrayList;

public abstract class Attraction implements Serializable {
    private String id;
    private String title;
    private String location;
    private double rating;
    private ArrayList<String> comments;

    public Attraction(String id, String title, String location, double rating) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.rating = rating;
        this.comments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public double getRating() {
        return rating;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public abstract String getDetails();

    @Override
    public String toString() {
        return id + " - " + title + " (" + location + ", Rating: " + rating + ")\n" + getDetails();
    }
}