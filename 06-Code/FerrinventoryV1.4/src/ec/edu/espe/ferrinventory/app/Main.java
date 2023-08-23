package ec.edu.espe.ferrinventory.app;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ferrinventory.controller.LogInController;
import ec.edu.espe.ferrinventory.utils.MongoConnection;
import ec.edu.espe.ferrinventory.utils.MongoUserDAO;
import ec.edu.espe.ferrinventory.utils.UserDAO;
import ec.edu.espe.ferrinventory.view.FrmLogin;
import org.bson.Document;

public class Main {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            FrmLogin frmLogin = new FrmLogin();
            MongoCollection<Document> userCollection = MongoConnection.getConnection("User");
            UserDAO userDAO = new MongoUserDAO(userCollection);
            LogInController loginController = LogInController.getInstance(frmLogin, userDAO);
            frmLogin.setVisible(true);
        });
    }
}
