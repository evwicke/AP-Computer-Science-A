import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CountdownClock {

    private long endTime; 
    private int durationInMillis;
    private Timer timer;
    private Bomb bomb;
    private BombGUI gui;
    private final int fps = 100;

    public CountdownClock(int startingSeconds, Bomb bomb, BombGUI gui) {
        // convert the starting seconds into milliseconds
        this.durationInMillis = startingSeconds * 1000;
        this.bomb = bomb;
        this.gui = gui;

        // Create a timer that refreshes the screen every 10 milliseconds.  (100 fps)
        timer = new Timer((1000 / fps), new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    updateDisplay();
                }
            });
    }

    public void start() {
        // Record the exact real-world millisecond this timer is supposed to hit 0
        endTime = System.currentTimeMillis() + durationInMillis;
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void forceTimeLeft(int seconds) {
        endTime = System.currentTimeMillis() + (seconds * 1000);
    }

    public void subtractTime(int secondsToLose) {
        endTime -= (secondsToLose * 1000);
    }

    public long getTimeLeft() {
        long timeLeft = endTime - System.currentTimeMillis();
        // no negative numbers
        return Math.max(0, timeLeft); 
    }
    
    private void updateDisplay() {

        long timeLeft = endTime - System.currentTimeMillis();

        // if time goes negative, make it 0 and explode.
        if (timeLeft <= 0) {
            timeLeft = 0;
            timer.stop();
            gui.updateTimerDisplay("00:00:000");
            bomb.explode(); 
            return; 
        }

        // math to extract the minutes, seconds, and milliseconds
        long minutes = (timeLeft / 1000) / 60;
        long seconds = (timeLeft / 1000) % 60;
        long milliseconds = timeLeft % 1000;

        String timeString = String.format("%02d:%02d:%03d", minutes, seconds, milliseconds);

        gui.updateTimerDisplay(timeString);
    }
}