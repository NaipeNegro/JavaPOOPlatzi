public class Patient extends User {
    //Atributos

    private String birthday;
    private String blood; // se pude "listar" los parámetros de cada tipo!
    private Double weight;
    private Double height;

    Patient(String name, String email){
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
}
