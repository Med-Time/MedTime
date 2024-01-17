import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.util.*;

// Parent class
class Disease {
    int x = 5;
}

// Subclasses
class Fever extends Disease {
    List<String> medications = Arrays.asList("Paracetamol", "Dolopar");
}

class Cold extends Disease {
    List<String> medications = Arrays.asList("Sinex", "De-Cold");
}

class Headache extends Disease {
    List<String> medications = Arrays.asList("Dispirin", "Paracetamol");
}

class ThroatProblem extends Disease {
    List<String> medications = Arrays.asList("Alegra", "Avil");
}

class AlarmClock {
    private int reminder;
    private Timer timer;
    private TimerTask task;

    public AlarmClock(int reminder) {
        this.reminder = reminder;
    }

    public void startAlarm() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        try (Scanner scanner = new Scanner(System.in)) {
            File file = new File("sound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            
            //sound stop when enter is pressed
            System.out.println("Press enter to stop the alarm.");

            if (scanner.hasNextLine()) {
                scanner.nextLine(); // consume the next line of input
                // clip.stop();
                clip.close();
            }
        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }

    public void startTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Alarm ringing! Time to take medication.");
                try {
                    startAlarm();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, reminder * 60*60*1000); // Schedule the task with a fixed rate
    }

    public void removeAlarm() {
        timer.cancel();
    }
}

public class MedTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt for age input
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        int reminder = (age > 18) ? 8 : 12;

        // Display options for diseases
        System.out.println("Select the disease you are suffering from:");
        System.out.println("1. Fever");
        System.out.println("2. Cold");
        System.out.println("3. Headache");
        System.out.println("4. Throat Problem");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                Fever fever = new Fever();
                System.out.println("Medications for Fever: " + fever.medications);
                break;
            case 2:
                Cold cold = new Cold();
                System.out.println("Medications for Cold: " + cold.medications);
                break;
            case 3:
                Headache headache = new Headache();
                System.out.println("Medications for Headache: " + headache.medications);
                break;
            case 4:
                ThroatProblem throatProblem = new ThroatProblem();
                System.out.println("Medications for Throat Problem: " + throatProblem.medications);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

        // Create an AlarmClock instance with the appropriate reminder value
        AlarmClock alarmClock = new AlarmClock(reminder);
        alarmClock.startTimer();
        //can be deleted if we have to noumber of medicine and time to take it
        System.out.println("Enter 'stop' if you finished all medicine: ");
        String stop = sc.nextLine().toLowerCase();

        if (stop.equals("stop")) {
            System.out.println("Alarm Removed.");
            alarmClock.removeAlarm();
        }

        sc.close();
    }
}
