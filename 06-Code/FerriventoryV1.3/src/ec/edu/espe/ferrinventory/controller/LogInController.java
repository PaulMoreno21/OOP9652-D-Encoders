package ec.edu.espe.ferrinventory.controller;

import ec.edu.espe.ferrinventory.model.User;

public class LogInController {

    private final UserDAOController userDAO;

    public LogInController(UserDAOController userDAO) {
        this.userDAO = userDAO;
    }

    public boolean authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
