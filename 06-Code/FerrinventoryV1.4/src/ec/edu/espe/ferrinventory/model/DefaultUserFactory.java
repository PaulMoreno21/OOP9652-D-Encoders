package ec.edu.espe.ferrinventory.model;

public class DefaultUserFactory implements UserFactory {
    @Override
    public User createAdmin() {
        return Admin.getInstance();
    }

    @Override
    public User createManager() {
        return new Manager(2, "manager", "managerPassword", true, "managerType");
    }
}
