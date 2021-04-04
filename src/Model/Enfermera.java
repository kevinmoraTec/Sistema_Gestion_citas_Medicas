package Model;

/**
 *
 * @author danielmora
 */

public class Enfermera extends Usuario{

    private String especialidad;
            
    public Enfermera(String name,String correo) {
        super(name, correo);
    
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarDatosUsuario_Doctor_Enfermera_paciente() {
        System.out.println("Empleado del Hospital: Cruz Verde");
        System.out.println("Departamentos: Nutriologia,Pediatria");
    
    }
    
}
