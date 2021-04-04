package UI;

/**
 *
 * @author danielmora
 */
import Model.Doctor;
import Model.Paciente;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
    public static Doctor doctroRegistrado;
    public static Paciente pacienteRegistrado;

    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response=0;
                    autenticacionUsuario(1);
                    break;
                case 2:
                    response = 0;
                    autenticacionUsuario(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextInt());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i + ".-" + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }

    private static void autenticacionUsuario(int usuarioIngresado) {
        // Si ingresa 1 = Doctor.
        // Si ingresa 2 = Paciente.

        ArrayList<Doctor> doctores = new ArrayList<>();
        doctores.add(new Doctor("Maria Garcia", " "));
        doctores.add(new Doctor("Vanesa Ortega", "vanesaOG@gamil.com"));
        doctores.add(new Doctor("Roberto Bolaños", "robertoB@gamil.com"));
        
        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Daniel Mora","djkevindaniel@gamil.com"));
        pacientes.add(new Paciente("Rodrigo Zoto","rodrigoZ@gamil.com"));
        pacientes.add(new Paciente("Maria Hurtado","MariaH@gmail.com"));
        
        boolean correoCorrecto = false;
        do {
            System.out.println("Inserte su correo ");
            Scanner sc = new Scanner(System.in);
            String correo = sc.nextLine();
            if (usuarioIngresado == 1) {
                for (Doctor d : doctores) {
                    if (d.getCorreo().equals(correo)) {
                        correoCorrecto=true;
                        // Obtenemos el usuario Logueado
                        doctroRegistrado=d;
                        DoctorMenu.mostarMenuDoctor();
                    }
                }
            }
            if (usuarioIngresado == 2) {
                for (Paciente p : pacientes) {
                    if (p.getCorreo().equals(correo)) {
                        correoCorrecto=true;
                        pacienteRegistrado=p;
                    }
                }
            }
             
        } while (!correoCorrecto); // si correoCorrecto es falso se va ha estar ejecutando
        

    }
}
