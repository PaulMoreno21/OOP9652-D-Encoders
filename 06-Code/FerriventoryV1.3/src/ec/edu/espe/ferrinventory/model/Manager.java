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

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", permissions=" + isPermissions() +
                ", typeUser='" + getTypeUser() + '\'' +
                '}';
    }

    public static Manager createManager() {
        return new Manager(2, "managerName", "managerPassword", true, "managerType");
    }
}
