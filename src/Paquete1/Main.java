package Paquete1;


import static  UI.UIMenu.*;
import java.util.Date;


/**
 *
 * @author danielmora
 */
public class Main {
    public static void main(String[] args) {
        
       //showMenu();
       
//       Doctor myDoctor = new Doctor("Daniel","pediatria");
//       
//       myDoctor.agregar_cita_Disponibles(new Date(),"4:54 AM");
//       myDoctor.agregar_cita_Disponibles(new Date(),"5:45 PM ");
//        myDoctor.agregar_cita_Disponibles(new Date(),"7:55 PM");
//        System.out.println(myDoctor.obtener_cita_Disponibles());
       
       Paciente paciente = new Paciente("Karol Mora","djkevindaniel2@gamil.com");
       paciente.setPeso("45.5");
       paciente.getPeso();
        System.out.println(paciente);
        
        
}
    
}