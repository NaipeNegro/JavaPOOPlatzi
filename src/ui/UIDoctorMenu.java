package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorAvailablesAppointments = new ArrayList<>();
    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Bienvenido " + UIMenu.doctorLogged.getName());
            System.out.println("1. Agregar turno disponible");
            System.out.println("2. Mostrar turnos disponibles");
            System.out.println("0. Salir del Sistema");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do{
            System.out.println("\n::Agregar nuevo turno disponible");
            System.out.println("::Selecioná un mes");

            for (int i = 0; i < 3; i++) {
                int j = i+1;
                System.out.println(j + ". "+ UIMenu.MONTHS[i]);
            }
            System.out.println("0. Regresar");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if(response>0 && response<4){
                int monthSelected = response;
                System.out.println(monthSelected+ " . " + UIMenu.MONTHS[monthSelected-1]);
                System.out.println("Ingresá la fecha: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("La fecha es "+ date + "\n1. Correcto\n2. Cambiar mes");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insertá la hora para "+ date+ " [17:00]");
                    time= sc.nextLine();
                    System.out.println("La hora es "+ date + "\n1. Correcto\n2. Cambiar hora");
                    responseTime = Integer.valueOf(sc.nextLine());
                } while (responseTime==2);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);

            } else if(response ==0){
                showDoctorMenu();
            }
        } while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointment().size()>0
        && !doctorAvailablesAppointments.contains(doctor)){
            doctorAvailablesAppointments.add(doctor);
        }
    }
}
