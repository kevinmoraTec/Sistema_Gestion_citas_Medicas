package UI;

import Model.Doctor;
import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author danielmora
 */
public class PacienteMenu {
    
    public static void mostrarMenuDoctor(){
        int response=0;
        do {
             System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Bienvenido"+UIMenu.pacienteRegistrado.getNombre());
            System.out.println("1. Reservar una Cita");
            System.out.println("2.Mis Citas");
            System.out.println("0. Salir");
            
               Scanner sc = new Scanner(System.in);
            response=Integer.valueOf(sc.nextLine());
        
            switch (response) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 0:
                    
                    break;
                default:
                    System.out.println("Seleccione una opcion Valida ");
            }
        } while (response != 0);
        
    
}
    
    
    public static void mostrarReservasMenuCitasPaciente(){
        int response = 0;
        
        do {
            System.out.println(":: Reseva una Cita");
            System.out.println("Seleccionar una Fecha");
            //numeracion de la lista de fechas.
             // Indice fecha seleccionada
             //[doctors]
             //1.- doctor1
                        //-1 fecha
                        //-2 fecha2
            //2.- doctor2
            //3.- doctor3
                                            
            Map<Integer, Map<Integer,Doctor>> doctores = new TreeMap<>();
            int k=0;
            for (int i = 0; i < DoctorMenu.doctoresDisponibleCitas.size(); i++) {
                ArrayList<Doctor.cita_Disponibles> disponiblesesCitas = DoctorMenu.doctoresDisponibleCitas.get(i).obtener_cita_Disponibles();
                
                Map<Integer,Doctor> doctorCitas = new TreeMap<>();
                
                for (int j = 0; j < disponiblesesCitas.size() ; j++) {
                    // capturamos los indices de los arrys que tienes fechas asignadas
                    k++;
                    System.out.println(k +". "+disponiblesesCitas.get(j).getDate());
                    doctorCitas.put(Integer.valueOf(j),DoctorMenu.doctoresDisponibleCitas.get(i));
                   doctores.put(Integer.valueOf(k), doctorCitas);
                }
            }
             Scanner sc = new Scanner(System.in);
             
            int responseFechaSeleccionada=Integer.valueOf(sc.nextLine());
            
        } while (response != 0);
        
    
    }
    
}