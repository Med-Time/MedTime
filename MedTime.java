
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.util.*;
// Parent class
 class Disease {
    private String name;
    private int age;
    Disease(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void getdetails(){
        System.out.println("Hello! "+name+","+age);
    }
 }

// Subclasses
class Fever extends Disease{
   Fever(String name, int age){
    super(name,age);
    super.getdetails();
   }
   int dose=6;
   public void description()
   {
System.out.println("Fever is a high body temperature due to an infection, with symptoms like sweating, chills, headache, etc. Paracetamol and Dolopar are painkillers that also lower fever by blocking inflammation and reducing congestion. They should be taken as prescribed, not more than 3 days, and without alcohol or other paracetamol products. They can harm the liver and may not suit people with allergies or other conditions. Always consult a doctor before taking any medicine");
   }
   List<String> medications = Arrays.asList("Paracetamol", "Dolopar","Advil","Motrin","Antibiotics");
    public int getdose(){
        return dose;
    }
}

class Cold extends Disease {
    Cold(String name, int age){
        super(name,age);
        super.getdetails();
       }
       int dose=6;
       public int getdose(){
        return dose;
       }
       public void description()
    {
System.out.println("A cold is a common viral infection that affects the upper respiratory tract. It can cause symptoms such as a runny or stuffy nose, sneezing, sore throat, cough, and headache. There is no cure for a cold, but you can treat the symptoms at home by resting, drinking fluids, and taking over-the-counter medicines. Sinex and De-Cold are two examples of medicines that can help relieve nasal congestion and pain. However, you should always follow the label directions and consult your doctor before using any medication.");
    }
    List<String> medications = Arrays.asList("Sinex", "De-Cold","Dextromethorphan","Cetirizine");

}

class Headache extends Disease {
    Headache(String name, int age){
        super(name,age);
        super.getdetails();
       }
       int dose=5;
       public int getdose(){
        return dose;
       }
       public void description()
    {
System.out.println("A headache is a pain in your head or face that can have various causes and symptoms1. Some common types of headaches are tension, migraine, cluster, and sinus2. Headaches can be triggered by factors such as stress, dehydration, alcohol, caffeine, or certain foods34. Dispirin and paracetamol are two medicines that can help reduce pain and inflammation in mild to moderate headaches5. However, they should be taken with caution and as directed by your doctor, as they may have side effects or interactions with other drugs5.");
    }
    List<String> medications = Arrays.asList("Dispirin", "Paracetamol","Ibuprofen","Naproxen");
}

class ThroatProblem extends Disease {
    ThroatProblem(String name, int age){
        super(name,age);
        super.getdetails();
       }
       int dose=6;
       public int getdose(){
        return dose;
       }
    public void description(){
        System.out.println("Throat problems include various conditions that affect the throat, causing symptoms like pain, fever, or difficulty swallowing. They can be caused by infections, allergies, or other factors. Alegra and Avil are antihistamines that can relieve some symptoms, such as itching or swelling, by blocking histamine. They are not effective against infections or inflammation, and may have side effects or interactions. They should be used only as directed, and not instead of proper diagnosis and treatment.");
    }
    List<String> medications = Arrays.asList("Alegra", "Avil","Benzocaine lozenges","Acetaminophen");
}
class Diabetes extends Disease {
     Diabetes(String name, int age){
        super(name,age);
        super.getdetails();
       }
       int dose=12;
       public int getdose(){
        return dose;
       }
       public void description(){
        System.out.println("Diabetes is a condition that affects how the body uses glucose, a type of sugar that provides energy for the cells. There are different types of diabetes, such as type 1, type 2, gestational, and prediabetes. Diabetes can cause various symptoms, such as increased thirst, frequent urination, fatigue, blurred vision, and slow-healing sores. Diabetes can also lead to serious complications, such as nerve damage, kidney failure, heart disease, and stroke.Diabetes affects how the body uses glucose and can cause serious complications. To manage it, use medications, eat healthily, exercise moderately, check blood sugar, avoid smoking, and see doctor.");
       }
    List<String> medications = Arrays.asList("Insulin Injections", "Metformin","Gilimpiride","Linagliptin");
}
class Asthma extends Disease {
    Asthma(String name, int age){
        super(name,age);
        super.getdetails();
       }
       int dose=10;
       public int getdose(){
        return dose;
       }
       public void description(){
        System.out.println("Asthma is a chronic condition that affects the airways in your lungs, making them inflamed and swollen. This can cause difficulty breathing, coughing, wheezing, and chest tightness. Asthma can be triggered by various factors, such as allergens, irritants, infections, stress, and exercise. There is no cure for asthma, but it can be managed with medications and lifestyle changes. Asthma can also be improved by regular exercise, which can strengthen the lungs, reduce inflammation, and boost the immune system.");
       }
    List<String> medications = Arrays.asList("Albuterol", "Advair","Symbicort","Omalizumab");
}
class Hypertension extends Disease {
    Hypertension(String name, int age){
        super(name,age);
        super.getdetails();  
       }
       int dose=8;
       public int getdose(){
        return dose;
       }
       public void description(){
        System.out.println("Hypertension, or high blood pressure, is a condition that occurs when the force of blood against the artery walls is too high. It can cause complications such as heart disease, stroke, and kidney damage. Hypertension often has no symptoms, but some people may experience headaches, nosebleeds, or shortness of breath. To prevent or lower hypertension, it is recommended to adopt healthy lifestyle habits, such as eating a balanced diet, reducing salt intake, exercising regularly, quitting smoking, managing stress, and limiting alcohol consumption. Some people may also need medications to control their blood pressure, such as diuretics, beta blockers, or ACE inhibitors. It is important to check your blood pressure regularly and consult your doctor for the best treatment plan.");
       }
    List<String> medications = Arrays.asList("Hydrochlorothiazide", "Spironolactone","Enalapril","Verapamil");
}

class AlarmClock {
    private int reminder;
    private Timer timer;
    private TimerTask task;
    private int dose;
    int count=0;
    public AlarmClock(int reminder, int dose) {
        this.reminder = reminder;
        this.dose=dose;
    }

    public void startAlarm() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        try (Scanner scanner = new Scanner(System.in)) {
            File file = new File("sound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();


            //sound stop when enter is pressed
           // System.out.println("Press enter to stop the alarm.");

            if (scanner.hasNextLine()) {
                scanner.nextLine(); // consume the next line of input
                clip.stop();
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
                if(count<dose){
                    count = count+1;
                    System.out.println("Alarm ringing! Time to take medication.");
                    try {
                        startAlarm();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                        e.printStackTrace();
                    }
                }else{
                    removeAlarm();
                }
               
            }
        };
            timer.scheduleAtFixedRate(task, 5000, reminder * 1000); // Schedule the task with a fixed rate
    }

    public void removeAlarm() {
        System.out.println("Timer Done");
        timer.cancel();
    }
}

public class MedTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to MedTime -Your Medication Buddy");
        // Prompt for age input
        System.out.print("Enter your name: ");
        String name=sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        int reminder = (age > 18) ? 5 : 12;

        // Display options for diseases
        System.out.println("Select the disease you are suffering from:");
        System.out.println("1. Fever");
        System.out.println("2. Cold");
        System.out.println("3. Headache");
        System.out.println("4. Throat Problem");
        System.out.println("5. Diabetes");
        System.out.println("6. Asthma");
        System.out.println("7. Hypertension");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character
         int dose=0;
        switch (choice) {
            case 1:
                Fever fever = new Fever(name,age);
                fever.description();
                System.out.println("Medications for Fever: " + fever.medications);
                System.out.println("Enter number of doses if unknown enter -1:");
                dose= sc.nextInt();
                if(dose==-1){
                    dose= fever.getdose();
                }
                System.out.println(dose);
                break;
            case 2:
                Cold cold = new Cold(name,age);
                cold.description();
                System.out.println("Medications for Cold: " + cold.medications);
                System.out.println("Enter number of doses if unknown enter -1:");
                dose= sc.nextInt();
                if(dose==-1){
                    dose= cold.getdose();
                }
                break;
            case 3:
                Headache headache = new Headache(name,age);
                headache.description();
                System.out.println("Medications for Headache: " + headache.medications);
                System.out.println("Enter number of doses if unknown enter -1:");
                dose= sc.nextInt();
                if(dose==-1){
                    dose= headache.getdose();
                }
                break;
            case 4:
                ThroatProblem throatProblem = new ThroatProblem(name,age);
                throatProblem.description();
                System.out.println("Medications for Throat Problem: " + throatProblem.medications);
                System.out.println("Enter number of doses if unknown enter -1:");
                dose= sc.nextInt();
                if(dose==-1){
                    dose= throatProblem.getdose();
                }
                break;
            case 5:
                Diabetes Diabetes = new Diabetes(name,age);
                Diabetes.description();
                System.out.println("Medications for Diabetes: " + Diabetes.medications);
                System.out.println("Enter number of doses if unknown enter -1:");
                dose= sc.nextInt();
                if(dose==-1){
                    dose= Diabetes.getdose();
                }
                break;
            case 6:
                Asthma Asthma = new Asthma(name,age);
                Asthma.description();
                System.out.println("Medications for Asthma: " + Asthma.medications);
                System.out.println("Enter number of doses if unknown enter -1:");
                dose= sc.nextInt();
                if(dose==-1){
                    dose= Asthma.getdose();
                }
                break;
            case 7:
                Hypertension Hypertension = new Hypertension(name,age);
                Hypertension.description();
                System.out.println("Medications for Hypertension: " + Hypertension.medications);
                System.out.println("Enter number of doses if unknown enter -1:");
                dose= sc.nextInt();
                if(dose==-1){
                    dose= Hypertension.getdose();
                }
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

        // Create an AlarmClock instance with the appropriate reminder value
        AlarmClock alarmClock = new AlarmClock(reminder,dose);
        alarmClock.startTimer();
    //    alarmClock.removeAlarm();
        //can be deleted if we have to noumber of medicine and time to take it
        // System.out.println("Enter 'stop' if you finished all medicine: ");
        // String stop = sc.nextLine().toLowerCase();

        // if (stop.equals("stop")) {
        //     System.out.println("Alarm Removed.");
        //     alarmClock.removeAlarm();
        // }

        sc.close();
    }
}


