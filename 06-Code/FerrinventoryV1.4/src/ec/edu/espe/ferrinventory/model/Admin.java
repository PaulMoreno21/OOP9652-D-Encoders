package ec.edu.espe.ferrinventory.model;

public class Admin extends User {
    private static Admin instance; // Instancia única de Admin

    private static final String DEFAULT_PASSWORD = "admin";

    private Admin(int id, String name, boolean permissions, String typeUser) {
        super(id, name, DEFAULT_PASSWORD, permissions, typeUser); 
    }

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin(1, "admin", true, "adminType");
        }
        return instance;
    }

    public void changePassword(String newPassword) {
        if (Validations.validatePassword(newPassword, this)) {
            setPassword(newPassword); // Cambiar la contraseña utilizando el método de User
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Invalid new password.");
        }
    }
}
