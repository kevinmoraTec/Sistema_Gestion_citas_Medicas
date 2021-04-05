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

    public static void mostrarMenuPaciente() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Bienvenido" + UIMenu.pacienteRegistrado.getNombre());
            System.out.println("1. Reservar una Cita");
            System.out.println("2.Mis Citas");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    mostrarReservasMenuCitasPaciente();
                    break;
                case 2:
                    mostarMisCitasPaciente();   
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Seleccione una opcion Valida ");
            }
        } while (response != 0);

    }

    private  static void mostrarReservasMenuCitasPaciente() {
        int response = 0;

        do {
            System.out.println(":: Reseva una Cita");
            System.out.println("Seleccionar una Fecha");
            //numeracion de la lista de fechas.
            // Indice fecha seleccionada
            //[doctores]
            //1.- doctor1
            //-1 fecha
            //-2 fecha2
            //2.- doctor2
            //3.- doctor3

            Map<Integer, Map<Integer, Doctor>> doctores = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < DoctorMenu.doctoresDisponibleCitas.size(); i++) {
                ArrayList<Doctor.cita_Disponibles> disponiblesesCitas = DoctorMenu.doctoresDisponibleCitas.get(i).obtener_cita_Disponibles();

                Map<Integer, Doctor> doctorCitas = new TreeMap<>();

                for (int j = 0; j < disponiblesesCitas.size(); j++) {
                    // capturamos los indices de los arrys que tienes fechas asignadas
                    k++;
                    System.out.println(k + ". " + disponiblesesCitas.get(j).getDate());
                    doctorCitas.put(Integer.valueOf(j), DoctorMenu.doctoresDisponibleCitas.get(i));
                    doctores.put(Integer.valueOf(k), doctorCitas);
                }
            }
            Scanner sc = new Scanner(System.in);

            int respuestaFechaSeleccionada = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorDisponibleSeleccionado = doctores.get(respuestaFechaSeleccionada);
            Integer indexDate = 0;
            Doctor doctorSeleccionado = new Doctor("", "");
            for (Map.Entry<Integer, Doctor> doc : doctorDisponibleSeleccionado.entrySet()) { // Entryset nos da acceso para poder Recorrer un map

                indexDate = doc.getKey();//Obtenemos El indice de un doctor
                doctorSeleccionado = doc.getValue();// Obtenemos el valor en este caso es los datos del doctor
            }
            System.out.println("Seleccionaste este Doctor" + doctorSeleccionado.getNombre()
                    + "la fecha" + doctorSeleccionado.obtener_cita_Disponibles().get(indexDate).getDate()
                    + "y esta hora " + doctorSeleccionado.obtener_cita_Disponibles().get(indexDate).getTime());

            System.out.println("Conforma tu Cita : " + "\n 1.S   \n 2.No");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.pacienteRegistrado.addCita_con_Doctors(doctorSeleccionado, doctorSeleccionado.obtener_cita_Disponibles().get(indexDate).getDate(null),
                        doctorSeleccionado.obtener_cita_Disponibles().get(indexDate).getTime());
                        
                 mostrarMenuPaciente();
                 
            }
        } while (response != 0);

    }

    private static void mostarMisCitasPaciente(){
        int response=0;
        do {
            System.out.println(":: Mis Citas");
            if (UIMenu.pacienteRegistrado.getCita_con_Doctors().size() == 0) {
                System.out.println("No tienes Citas al momento");
                break;
            }
            for (int i = 0; i <UIMenu.pacienteRegistrado.getCita_con_Doctors().size(); i++) {
                System.out.println((i+1)+". "
                        +"Tienes Esta fecha"+UIMenu.pacienteRegistrado.getCita_con_Doctors().get(i).getDate()+""
                        + "Tienes Esta Fecha"+UIMenu.pacienteRegistrado.getCita_con_Doctors().get(i).getTime()+"\n"
                        + "Doctor: "+UIMenu.pacienteRegistrado.getCita_con_Doctors().get(i).getDoctor().getNombre());
                        
            }
            System.out.println("0. Salir");
        } while (response != 0);
        
    } 
}
