package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointment = new ArrayList<>();

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //constructor por defecto con agregado:
    /*model.Doctor(){
        System.out.println("Construyendo el Objeto model.Doctor");
    }*/

    //constructor creado como ejemplo de la sobrecarga de métodos:

    public Doctor(String name, String email){
        super(name, email);
        //System.out.println("El nombre del doctor es "+ name);
        //this.speciality= speciality;

    }

    //Comportamientos
    /*public void showName(){
        System.out.println(name);
    }

    public void showId(){
        System.out.println("El ID del model.Doctor es " + id);
    }*/


    public void addAvailableAppointment(String date, String time){ //método público que agrega objetos del tipo específico a una lista, es void porque no devuelve nada
        availableAppointment.add(new Doctor.AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointment(){ //metodo público que devuelve la lista creada
        return availableAppointment;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nEspecialidad: " + speciality + "\nDisponible: "+availableAppointment.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado Hospital Rivadavia");
    }

    //AvailableAppointment Clase anidada
    public static class AvailableAppointment{ // clase anidada pública
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) { //esto es el constructor de una clase anidada pública
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public String getDate(String DATE) {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
        @Override
        public String toString() {
            return "Available Appointments\nFecha: " +date+"\nHora: "+time;
        }

    }
}
