
package ec.edu.espe.ferrinventory.model;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Suplier {
    private String name;
    private String PhoneNumber;
    private String email;
    private String direccion;

    public Suplier(String name, String PhoneNumber, String email, String direccion) {
        this.name = name;
        this.PhoneNumber = PhoneNumber;
        this.email = email;
        this.direccion = direccion;
    }

    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * @param PhoneNumber the PhoneNumber to set
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
