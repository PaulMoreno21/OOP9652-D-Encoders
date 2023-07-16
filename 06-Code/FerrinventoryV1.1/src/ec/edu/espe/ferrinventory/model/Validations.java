package ec.edu.espe.ferrinventory.model;

public class Validations {
    public static boolean validatePassword(String password, User user) {
        String storedPassword = user.getPassword();
        return password.equals(storedPassword);
    }
}
