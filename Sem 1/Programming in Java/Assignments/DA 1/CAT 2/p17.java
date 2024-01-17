class Clinic {
    private int patientCount = 0;

    public synchronized void enterClinic() {
        try {
            while (patientCount >= 2) {
                wait();
            }

            patientCount++;
            System.out.println("Patient " + patientCount + " entered the clinic.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void leaveClinic() {
        patientCount--;
        System.out.println("Patient left the clinic.");
        notifyAll();
    }
}

class Doctor extends Thread {
    private Clinic clinic;

    public Doctor(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            clinic.enterClinic();
            clinic.enterClinic();

            System.out.println("Doctor completed checkup for two patients.");

            clinic.leaveClinic();
            clinic.leaveClinic();
        }
    }
}

class Patient extends Thread {
    private Clinic clinic;

    public Patient(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { 
            clinic.enterClinic();
            System.out.println("Patient is being checked by the doctor.");
            clinic.leaveClinic();
        }
    }
}

public class p17 {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        Doctor doctor = new Doctor(clinic);
        Patient patient1 = new Patient(clinic);
        Patient patient2 = new Patient(clinic);

        doctor.start();
        patient1.start();
        patient2.start();
    }
}