package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Paciente");
            System.out.println("Bienvenido: " + UIMenu.patientLogged.getName());
            System.out.println("1. reservá turno");
            System.out.println("2. Mis turnos");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while (response != 0);
    }

        private static void showBookAppointmentMenu(){
            int response = 0;
            do{
                System.out.println("Reserva de turno");
                System.out.println("Seleccioná una fecha: ");
                //Numeración de la lista de fechas
                //Indice de la fecha seleccionada
                //[doctors]
                // - doctor1
                //
                Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();

                int k = 0;

                for (int i = 0; i < UIDoctorMenu.doctorAvailablesAppointments.size(); i++) {
                    ArrayList<Doctor.AvailableAppointment> availableAppointments
                            = UIDoctorMenu.doctorAvailablesAppointments.get(i). getAvailableAppointment();
                    Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                    for (int j = 0; j <availableAppointments.size(); j++) {
                        k++;
                        System.out.println(k + ". " + availableAppointments.get(j).getDate());
                        doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorAvailablesAppointments.get(i));
                        doctors.put(Integer.valueOf(k), doctorAppointments);
                    }
                }
                Scanner sc = new Scanner(System.in);
                int responseDateSelected = Integer.valueOf(sc.nextLine());

                Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
                Integer indexDate = 0;
                Doctor doctorSelected = new Doctor("", "");

                for (Map.Entry<Integer, Doctor> doc :doctorAvailableSelected.entrySet()) {
                    indexDate = doc.getKey();
                    doctorSelected = doc.getValue();
                }

                System.out.println(doctorSelected.getName() +
                        ". Fecha: " +
                        doctorSelected.getAvailableAppointment().get(indexDate).getDate() +
                        ". Hora: " +
                        doctorSelected.getAvailableAppointment().get(indexDate).getTime());

                System.out.println("Confirma:\n1. Si \n2. Cambiar");
                response = Integer.valueOf(sc.nextLine());

                if (response == 1){
                    UIMenu.patientLogged.addAppointmentDoctors(
                            doctorSelected,
                            doctorSelected.getAvailableAppointment().get(indexDate).getDate(null),
                            doctorSelected.getAvailableAppointment().get(indexDate).getTime());
                    showPatientMenu();
                }

            } while(response != 0);
        }

        private static void showPatientMyAppointments() {
            int response = 0;
            do {
                System.out.println("Mis turnos");
                if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0 && UIMenu.patientLogged.getAppointmentDNurses().size() == 0){
                    System.out.println("No tenés turnos");
                    break;
                }
                for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                    int j = i + 1;
                    System.out.println(j + ". " +
                                    "Fecha: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                                    "Hora: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                            "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor()
                            );
                    
                }
                //System.out.println("0. Salir");
            } while (response != 0);

        }
}


