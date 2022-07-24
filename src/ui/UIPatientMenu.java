package ui;

import model.Doctor;

import java.util.Map;
import java.util.Scanner;

public class UIPatientMenu {
    public static void showPatientMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Paciente");
            System.out.println("Bienvenido: " + UIMenu.patientLogged);
            System.out.println("1. reservá turno");
            System.out.println("2. Mis turnos");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while(response!=0);

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
                Map<Integer>, Map<Integer, Doctor>
            } while(response != 0)
        }

    }

}
