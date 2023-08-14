package ec.edu.espe.ferrinventory.controller;

import ec.edu.espe.ferrinventory.model.User;

public interface UserDAOController {
    User findByUsername(String username);
}
