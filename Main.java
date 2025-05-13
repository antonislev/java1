import java.io.*;
import java.util.*;

public class Main {
    private static final String FILE_NAME = "data.ser";
    private static ArrayList<Attraction> attractions = new ArrayList<>();

    public static void main(String[] args) {
        loadData();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- ΜΕΝΟΥ ΠΡΟΟΡΙΣΜΩΝ ΓΙΑ ΤΟ ΠΑΣΧΑ ---");
            System.out.println("1. Προβολή Αξιοθεατων");
            System.out.println("2. Προσθήκη POI");
            System.out.println("3. Αναζήτηση ανά Όνομα");
            System.out.println("4. Διαγραφή POI");
            System.out.println("5. Προβολή Κριτικών");
            System.out.println("6. Έξοδος & Αποθήκευση");
            System.out.print("Επιλογή: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: displayAttractions(); break;
                case 2: addPOI(sc); break;
                case 3: searchByName(sc); break;
                case 4: deletePOI(sc); break;
                case 5: viewComments(sc); break;
                case 6: saveData(); break;
                default: System.out.println("Μη έγκυρη επιλογή.");
            }
        } while (choice != 6);
    }

    private static void displayAttractions() {
        if (attractions.isEmpty()) System.out.println("Κανένα διαθέσιμο αξιοθέατο.");
        for (Attraction a : attractions) System.out.println(a);
    }

    private static void addPOI(Scanner sc) {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Τίτλος: ");
        String title = sc.nextLine();
        System.out.print("Τοποθεσία: ");
        String location = sc.nextLine();
        System.out.print("Rating: ");
        double rating = Double.parseDouble(sc.nextLine());
        System.out.print("Κατηγορία: ");
        String category = sc.nextLine();

        POI poi = new POI(id, title, location, rating, category);
        attractions.add(poi);
        System.out.println("Το POI προστέθηκε.");
    }

    private static void searchByName(Scanner sc) {
        System.out.print("Όνομα για αναζήτηση: ");
        String name = sc.nextLine();
        for (Attraction a : attractions) {
            if (a.getTitle().equalsIgnoreCase(name)) {
                System.out.println(a);
                return;
            }
        }
        System.out.println("Δεν βρέθηκε.");
    }

    private static void deletePOI(Scanner sc) {
        System.out.print("ID προς διαγραφή: ");
        String id = sc.nextLine();
        attractions.removeIf(a -> a.getId().equals(id));
        System.out.println("Διαγράφηκε αν υπήρχε.");
    }

    private static void viewComments(Scanner sc) {
        System.out.print("ID αξιοθέατου: ");
        String id = sc.nextLine();
        for (Attraction a : attractions) {
            if (a.getId().equals(id)) {
                if (a.getComments().isEmpty()) System.out.println("Χωρίς σχόλια.");
                else for (String comment : a.getComments()) System.out.println("- " + comment);
                System.out.print("Νέο σχόλιο (Enter για παράλειψη): ");
                String newComment = sc.nextLine();
                if (!newComment.isEmpty()) a.addComment(newComment);
                return;
            }
        }
        System.out.println("Δεν βρέθηκε το αξιοθέατο.");
    }

    private static void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(attractions);
            System.out.println("Αποθήκευση επιτυχής.");
        } catch (IOException e) {
            System.out.println("Σφάλμα αποθήκευσης.");
        }
    }

    private static void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            attractions = (ArrayList<Attraction>) in.readObject();
            System.out.println("Δεδομένα φορτώθηκαν.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Χωρίς προηγούμενα δεδομένα.");
        }
    }
}
