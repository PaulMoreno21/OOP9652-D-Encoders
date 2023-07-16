package ec.edu.espe.ferrinventory.model;

public class Admin extends User {
    private String adminPassword = "1234password";

    public Admin(int id, String name, String password, boolean permissions, String typeUser) {
        super(id, name, password, permissions, typeUser);
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
}