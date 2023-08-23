package ec.edu.espe.ferrinventory.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.ferrinventory.model.Admin;
import ec.edu.espe.ferrinventory.model.User;
import ec.edu.espe.ferrinventory.utils.MongoConnection;
import ec.edu.espe.ferrinventory.utils.UserDAO;
import ec.edu.espe.ferrinventory.view.FrmLogin;
import ec.edu.espe.ferrinventory.view.FrmMainMenu;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController implements ActionListener {

    private static LogInController instance;
    
    private final FrmLogin view;
    private final UserDAO userDAO;
    private final MongoCollection<Document> userCollection;

    private LogInController(FrmLogin view, UserDAO userDAO) {
        this.view = view;
        this.userDAO = userDAO;
        this.view.getBtnLogIn().addActionListener(this);
        this.view.getBtnClose().addActionListener(this);
        
        userCollection = MongoConnection.getConnection("User");
        Admin admin = Admin.getInstance();
        if (!userCollection.find(Filters.eq("name", admin.getName())).iterator().hasNext()) {
            Document adminDocument = new Document()
                    .append("name", admin.getName())
                    .append("password", admin.getPassword())
                    .append("permissions", admin.isPermissions())
                    .append("typeUser", admin.getTypeUser());
            userCollection.insertOne(adminDocument);
        }
    }

    public static LogInController getInstance(FrmLogin view, UserDAO userDAO) {
        if (instance == null) {
            instance = new LogInController(view, userDAO);
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnLogIn()) {
            btnLogInActionPerformed();
        } else if (e.getSource() == view.getBtnClose()) {
            btnCloseActionPerformed();
        }
        // Agregar más casos para otros eventos aquí si es necesario
    }

    private void btnLogInActionPerformed() {
        String username = view.getTxtUser().getText();
        String password = new String(view.getPswUser().getPassword());

        User user = userDAO.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            openMainMenu();
        } else {
            showErrorMessage("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
        }
    }

    private void openMainMenu() {
        FrmMainMenu frmMainMenu = new FrmMainMenu();
        frmMainMenu.setVisible(true);
        view.dispose();
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(view, message, "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
    }

    private void btnCloseActionPerformed() {
        System.exit(0);
    }
}
