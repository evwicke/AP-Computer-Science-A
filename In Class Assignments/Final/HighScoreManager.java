import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HighScoreManager {
    
    private final String FILE_NAME = "highscore.txt"; 

    public long getHighScoreTime() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                if (sc.hasNext()) {
                    sc.next(); // Skip the initials
                    long score = sc.nextLong(); // Grab the score
                    sc.close();
                    return score;
                }
                sc.close();
            }
        } catch (Exception e) {
            System.out.println("Error reading high score.");
        }
        return 0; // base case if theres an error
    }
    
    public String getHighScoreInitials() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                if (sc.hasNext()) {
                    String initials = sc.next(); // Grab the initials
                    sc.close();
                    return initials;
                }
                sc.close();
            }
        } catch (Exception e) {
            System.out.println("Error reading high score.");
        }
        return "---"; // base case if theres an error
    }

    public void saveScore(String initials, long timeRemainingMs) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME); // found this class from Chat and
                                                          // i had it explain how to use it.
            writer.write(initials + " " + timeRemainingMs);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing high score.");
        }
    }

    public String formatTime(long millis) {
        long minutes = (millis / 1000) / 60;
        long seconds = (millis / 1000) % 60;
        long ms = millis % 1000;
        return String.format("%02d:%02d:%03d", minutes, seconds, ms);
    }
}