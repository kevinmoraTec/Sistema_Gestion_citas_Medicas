package UI;
import Model.Doctor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danielmora
 */
public class DoctorMenu {
    public static ArrayList<Doctor> doctoresDisponibleCitas = new ArrayList<>();
    

    public static void mostarMenuDoctor() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Bienvenido " + UIMenu.doctroRegistrado.getNombre());
            System.out.println("1.Fecha Disponible cita");
            System.out.println("2.Mis citas Programadas");
            System.out.println("0. Salir");
            
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response) {
                case 1:
                    mostrarMenuAgregarCitasDisponibles();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    throw new AssertionError();
            }
            

        } while (response != 0);

    }
    
    private static void mostrarMenuAgregarCitasDisponibles (){
        int response = 0;
        
        do {
            System.out.println("::Añadir Citas Disponibles");
            System.out.println(":: Seleccione un Mes ");
            for (int i = 0; i < 3; i++) {
              int j = i+1;
                System.out.println(j+". "+UIMenu.MONTHS[i]) ;
            }
            System.out.println("0. Volver");
            
            Scanner sc = new Scanner(System.in);
            response=Integer.valueOf(sc.nextLine());
            
            if (response > 0 && response < 4) {
                //1,2,3
                int mesSeleccionado = response;
                System.out.println(mesSeleccionado+". "+UIMenu.MONTHS[mesSeleccionado-1]);
                System.out.println("Ingesa la fecha Disponible: [dd/mm/yyyy]");
                String fecha = sc.nextLine();
                
                System.out.println(" Tu fecha es :"+fecha+"\n1.Correct  \n 2.Cambiar fecha");
                int respuestaFecha= Integer.valueOf(sc.nextLine());
                if (respuestaFecha == 2) {
                    continue;
                }
                int respuestaTiempo=0;
                String hora;
                do {
                    System.out.println("Inserte la Hora para la Fecha :"+fecha+"[16:00]");
                    hora= sc.nextLine();
                    System.out.println("Tu hora es :"+hora+"\n 1. Es correcto \n 2.Cambiar Hora");
                    respuestaTiempo=Integer.valueOf(sc.nextLine());
                    
                } while (respuestaTiempo == 2);
                
                UIMenu.doctroRegistrado.agregar_cita_Disponibles(fecha, hora);
                revisarDoctorDisponible(UIMenu.doctroRegistrado);
            }else if(response == 0){
                mostarMenuDoctor();
            }
            
        } while (response != 0);
        
    }
    
    private static void revisarDoctorDisponible(Doctor doctor){
        if (doctor.obtener_cita_Disponibles().size() > 0 && !doctoresDisponibleCitas.contains(doctor)) {
            doctoresDisponibleCitas.add(doctor);
            
        }
    
    }

}
