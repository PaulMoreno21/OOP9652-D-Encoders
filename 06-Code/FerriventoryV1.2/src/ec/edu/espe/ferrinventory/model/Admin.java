package ec.edu.espe.ferrinventory.model;

public class Admin extends User {
    private String adminPassword;

    public Admin(int id, String name, String password, boolean permissions, String typeUser) {
        super(id, name, password, permissions, typeUser);
        this.adminPassword = password; // El password se toma del constructor
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public void setPassword(String newPassword) {
        if (Validations.validatePassword(newPassword, this) || newPassword.equals(adminPassword)) {
            super.setPassword(newPassword);
        } else {
            System.out.println("Invalid password for admin.");
        }
    }

    @Override
    public String toString() {
        return super.toString(); // Usar la implementación de User o personalizar según necesites
    }
}
