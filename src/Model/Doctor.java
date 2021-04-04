package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielmora
 */
public class Doctor extends Usuario{
     // Atributo
    private String especialidad;

  

    public  Doctor(String name, String correo) {
        super(name,correo);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
    // Comportamientos
 
    ArrayList<cita_Disponibles> cita_disponibles = new ArrayList<>();
    public void agregar_cita_Disponibles(String date, String time){ // Creamos nuevas citas
        cita_disponibles.add(new Doctor.cita_Disponibles(date, time));
    }
        
    public ArrayList<cita_Disponibles> obtener_cita_Disponibles(){//Obtenemos los datos de todas las citas 
        return cita_disponibles;
    }

    @Override
    public String toString() {
        return super.toString() + "Especialidad: " +especialidad + "Disponible: " +cita_disponibles.toString();
    }
    
    
    
    public static class cita_Disponibles { // Implementamos una Clase anidad Static

        private int citas_disponibles;
        private Date date;
        private String time;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        public cita_Disponibles(String date, String time) {
            try {
                this.date = formato.parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.time = time;
        }
        public Date getDate(String DATE) {
            return date;
        }                               
        public String getDate() {
            return formato.format(date);
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
            return "cita_Disponibles{" + "date=" + date + ", time=" + time + '}';
        }

     
    }

    @Override
    public void mostrarDatosUsuario_Doctor_Enfermera_paciente() {
        
        System.out.println(" Empleado del Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerologia");
    }
    
    

}
