package model; 
 
/** 
 * 
 * @author GABRIEL GUZMÁN ALFARO
 */ 
public class Persona implements Comparable<Persona>  { 
    
    //Atributos
    private Integer cedula; 
    private String nombre; 
    private Integer edad; 
 
    /**
     * Constructor
     */
    public Persona() { 
    }
    
    /**
     * Constructor
     */
    public Persona(Integer cedula) {
        this.cedula=cedula;
    } 
 
    /**
     * 
     * @param cedula
     * @param nombre
     * @param edad 
     */
    public Persona(int cedula, String nombre, int edad) { 
        this.cedula = cedula; 
        this.nombre = nombre; 
        this.edad = edad; 
    } 
 
    /**
     * 
     * @return cedula 
     */
    public int getCedula() { 
        return cedula; 
    } 
 
    /**
     * 
     * @param cedula 
     */
    public void setCedula(int cedula) { 
        this.cedula = cedula; 
    } 
 
    /**
     * 
     * @return nombre 
     */
    public String getNombre() { 
        return nombre; 
    } 
 
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    } 
    
    /**
     * 
     * @return edad 
     */
    public int getEdad() { 
        return edad; 
    } 
 
    /**
     * 
     * @param edad 
     */
    public void setEdad(int edad) { 
        this.edad = edad; 
    } 

    @Override
    public int compareTo(Persona t) {
        return cedula.compareTo(t.getCedula());
    }

    @Override
    public String toString() {
        return "Persona: " + "cedula=" + cedula + ", nombre=" + nombre + ", edad=" + edad;
    }

    
}
