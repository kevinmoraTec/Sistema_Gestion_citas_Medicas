package Paquete1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author danielmora
 */
public class Doctor extends Usuario{
     // Atributo
    private String especialidad;

  

    Doctor(String name, String correo) {
        super(name,correo);
        System.out.println("El nomrbe del Doctor Asignado es :" + name);
        this.especialidad = especialidad;

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
    // Comportamientos
 
    ArrayList<cita_Disponibles> cita_disponibles = new ArrayList<>();
    public void agregar_cita_Disponibles(Date date, String time){ // Creamos nuevas citas
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

        public cita_Disponibles(Date date, String time) {
            this.date = date;
            this.time = time;
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

        @Override
        public String toString() {
            return "cita_Disponibles{" + "date=" + date + ", time=" + time + '}';
        }

        
        
    }

}
