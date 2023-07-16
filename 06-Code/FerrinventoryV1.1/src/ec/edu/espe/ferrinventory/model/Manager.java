package ec.edu.espe.ferrinventory.model;
        
public class Manager extends User {
    public Manager(int id, String name, String password, boolean permissions, String typeUser) {
        super(id, name, password, permissions, typeUser);
    }

    @Override
    public void setPassword(String newPassword) {
        if (Validations.validatePassword(newPassword, this)) {
            super.setPassword(newPassword);
        } else {
            System.out.println("Invalid password for manager.");
        }
    }
}
