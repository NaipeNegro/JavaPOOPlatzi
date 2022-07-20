import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //constructor por defecto con agregado:
    /*Doctor(){
        System.out.println("Construyendo el Objeto Doctor");
    }*/

    //constructor creado como ejemplo de la sobrecarga de métodos:

    Doctor(String name, String email){
        super(name, email);
        System.out.println("El nombre del doctor es "+ name);
        this.speciality= speciality;

    }

    //Comportamientos
    /*public void showName(){
        System.out.println(name);
    }

    public void showId(){
        System.out.println("El ID del Doctor es " + id);
    }*/

    ArrayList<AvailableAppointment> availableAppointment = new ArrayList<>();
    public void addAvailableAppointment(Date date, String time){
        availableAppointment.add(new Doctor.AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointment(){
        return availableAppointment;
    }

    //AvailableAppointment Clase anidada
    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time) {
            this.date = date;
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

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
