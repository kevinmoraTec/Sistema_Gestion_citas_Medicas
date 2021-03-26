package Paquete1;

/**
 *
 * @author danielmora
 */

public class Paciente extends Usuario {

    private String cumpleaños;
    private String peso;
    private String altura;
    private String sangre;

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

 
   
    
            
}
