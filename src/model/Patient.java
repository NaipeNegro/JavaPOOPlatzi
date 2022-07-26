package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    //Atributos

    private String birthday;
    private String blood; // se pude "listar" los parámetros de cada tipo!
    private Double weight;
    private Double height;

    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentDNurses = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentDNurses() {
        return appointmentDNurses;
    }

    public void setAppointmentDNurses(ArrayList<AppointmentNurse> appointmentDNurses) {
        this.appointmentDNurses = appointmentDNurses;
    }

    public Patient(String name, String email){
        super(name, email);
    }

    //setter:
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void setBlood(String blood) {
        this.blood = blood;
    }
    public void setHeight(Double height) {
        this.height = height;
    }

    //getter
    public String getWeight(){
        return this.weight + " Kg.";
    }
    public String getBirthday() {
        return birthday;
    }
    public String getBlood() {
        return blood;
    }
    public String getHeight() {
        return this.height+ " Mts.";
    }

    @Override
    public String toString() {
        return super.toString() +"\nEdad: " + birthday + "\nAltura: " +getWeight()+"\nPeso: "+getHeight()+ "\nTipo de sangre:"+blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente del Hospital Rivadavia");
    }
}
