
package ec.edu.espe.ferrinventory.model;

/**
 *
 * @author Moreno Paul,The encoders; DCCO-ESPE
 */
public class Client {
    private String name;
    private String phoneNumber;
    private String email;
    private String direction;

    public Client(String name, String phoneNumber, String email, String direction) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.direction = direction;
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
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
    
}
