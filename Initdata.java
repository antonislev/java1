import java.io.*;
import java.util.ArrayList;

public class Initdata {
    public static void main(String[] args) {
        ArrayList<Attraction> sampleAttractions = new ArrayList<>();

        sampleAttractions.add(new POI("p1", "Πλατεία Αριστοτέλους", "Θεσσαλονίκη", 4.7, "Αξιοθέατο"));
        sampleAttractions.add(new POI("p2", "Μοναστήρι Αγ. Γεωργίου", "Σύρος", 4.9, "Θρησκευτικό"));
        sampleAttractions.add(new POI("p3", "Αρχαίο Θέατρο Επιδαύρου", "Αργολίδα", 4.8, "Ιστορικό"));
        sampleAttractions.add(new POI("p4", "Παραλία Πλακιά", "Ρέθυμνο", 4.5, "Φυσικό Τοπίο"));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            out.writeObject(sampleAttractions);
            System.out.println("Αρχικά δεδομένα αποθηκεύτηκαν επιτυχώς στο data.ser.");
        } catch (IOException e) {
            System.out.println("Σφάλμα αποθήκευσης: " + e.getMessage());
        }
    }
}
