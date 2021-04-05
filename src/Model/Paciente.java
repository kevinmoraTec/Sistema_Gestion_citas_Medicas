package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author danielmora
 */

public class Paciente extends Usuario {

    private String cumpleaños;
    private String peso;
    private String altura;
    private String sangre;
    private ArrayList<Cita_con_Doctor> cita_con_Doctors = new ArrayList<>();
    private ArrayList<Cita_con_Enfermera> cita_con_Enfermeras = new ArrayList<>();

    public ArrayList<Cita_con_Doctor> getCita_con_Doctors() {
        return cita_con_Doctors;
    }

    public void addCita_con_Doctors(Doctor doctor,Date date,String time) {
        Cita_con_Doctor cita_con_Doctor1 = new Cita_con_Doctor(this,doctor);
        cita_con_Doctor1.schedule(date, time);
        cita_con_Doctors.add(cita_con_Doctor1);
        
    }

    public ArrayList<Cita_con_Enfermera> getCita_con_Enfermeras() {
        return cita_con_Enfermeras;
    }

    public void setCita_con_Enfermeras(ArrayList<Cita_con_Enfermera> cita_con_Enfermeras) {
        this.cita_con_Enfermeras = cita_con_Enfermeras;
    }
    
    

    public Paciente(String nombre, String correo) {// Metodo de constructor se encarga de definir los parametros obligatorios para que el objeto exista nos ayuda a validar los datos para que el objeto exista 
        super(nombre,correo);

    }
    // Los get y set nos van ayudar a validar todo dato que se quiera agrgar: 
   
 
    public String getCumpleaños() {
        return cumpleaños;
    }

    public void setCumpleaños(String cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso +"kg.";
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura +"Mts";
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEdad: " + cumpleaños +"\nPeso: "+getPeso() + ""
                + "\nAltura: "+getAltura() +"\nTipo de Sangre: "+sangre;
    }

    @Override
    public void mostrarDatosUsuario_Doctor_Enfermera_paciente() {
        System.out.println("Paciente:");
        System.out.println("Historial completo del Paciente");
    }

 
   
    
            
}
