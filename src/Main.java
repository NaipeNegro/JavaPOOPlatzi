import java.sql.SQLOutput;
import java.util.Date;

import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {

        /*Doctor myDoctor = new Doctor();
        myDoctor.name = "Alejandro Rodriguez";
        myDoctor.showName();
        myDoctor.showId();

        Doctor myDoctorAnn = new Doctor();
        myDoctor.showId();
        myDoctorAnn.showId();

        System.out.println();
        System.out.println(myDoctor.name);
        System.out.println(myDoctor.id);
        System.out.println(myDoctorAnn.name);
        System.out.println(myDoctorAnn.id);*/

        //showMenu();

        Doctor myDoctor = new Doctor("Anahí Salgado","Pediatría");
        //System.out.println(myDoctor.name);
        System.out.println(myDoctor.speciality);

        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10pm");
        myDoctor.addAvailableAppointment(new Date(), "1pm");

        for (Doctor.AvailableAppointment aA: myDoctor.getAvailableAppointment()){
            System.out.println(aA.getDate() + " " + aA.getTime());
        }

        Patient patient = new Patient("Alejandra", "alejandra@mail.com");
        patient.setWeight(54.6);
        System.out.println(patient.getWeight());

        patient.setPhoneNumber("12345678");
        System.out.println(patient.getPhoneNumber());

    }
}
