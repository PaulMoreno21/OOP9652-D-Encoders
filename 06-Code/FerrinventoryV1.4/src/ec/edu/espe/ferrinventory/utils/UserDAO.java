package ec.edu.espe.ferrinventory.utils;

import ec.edu.espe.ferrinventory.model.User;

public interface UserDAO {
    User findByUsername(String username);
}
