package ec.edu.espe.ferrinventory.view;
import ec.edu.espe.ferrinventory.controller.SuplierController;
import javax.swing.JOptionPane;

public class FrmSuplier extends javax.swing.JFrame {

   public FrmSuplier() {
        initComponents();
        btnAddSuplier.addActionListener(this::btnAddSuplierActionPerformed);
        btnDeleteSuplier.addActionListener(this::btnDeleteSuplierActionPerformed);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Nombre = new javax.swing.JLabel();
        Telefono = new javax.swing.JLabel();
        Correo = new javax.swing.JLabel();
        Direccion = new javax.swing.JLabel();
        txtNameSuplier = new javax.swing.JTextField();
        txtPhoneSuplier = new javax.swing.JTextField();
        txtEmailSuplier = new javax.swing.JTextField();
        txtDirectionSuplier = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAddSuplier = new javax.swing.JButton();
        btnSearchSuplier = new javax.swing.JButton();
        btnDeleteSuplier = new javax.swing.JButton();
        BtnModifySuplier = new javax.swing.JButton();
        btnCancelSuplier = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Nombre.setText("Nombre:");

        Telefono.setText("Telefono");

        Correo.setText("Correo:");

        Direccion.setText("Dirección");

        txtNameSuplier.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNameSuplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameSuplierKeyTyped(evt);
            }
        });

        txtPhoneSuplier.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPhoneSuplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneSuplierKeyTyped(evt);
            }
        });

        txtEmailSuplier.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtDirectionSuplier.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Titulo.setText("MENU PROVEEDORES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Nombre)
                    .addComponent(Telefono)
                    .addComponent(Correo)
                    .addComponent(Direccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPhoneSuplier, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(txtNameSuplier)
                        .addComponent(txtEmailSuplier))
                    .addComponent(txtDirectionSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtNameSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPhoneSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Correo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmailSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(txtDirectionSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        btnAddSuplier.setText("Agregar");

        btnSearchSuplier.setText("Buscar");

        btnDeleteSuplier.setText("Borrar");

        BtnModifySuplier.setText("Modificar");

        btnCancelSuplier.setText("Cancelar");
        btnCancelSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelSuplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnModifySuplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelSuplier)
                            .addComponent(btnSearchSuplier)
                            .addComponent(btnDeleteSuplier)
                            .addComponent(btnAddSuplier))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnAddSuplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchSuplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteSuplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnModifySuplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelSuplier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  



private void btnAddSuplierActionPerformed(java.awt.event.ActionEvent evt) {                                               
    String name = txtNameSuplier.getText();
    String phone = txtPhoneSuplier.getText();
    String address = txtDirectionSuplier.getText();
    String email = txtEmailSuplier.getText();
    
    SuplierController.addSuplier(name, phone, address, email);
    
    txtNameSuplier.setText("");
    txtPhoneSuplier.setText("");
    txtDirectionSuplier.setText("");
    txtEmailSuplier.setText("");
}


private void btnDeleteSuplierActionPerformed(java.awt.event.ActionEvent evt) {                                                
    String nameToDelete = JOptionPane.showInputDialog("Ingrese el nombre del proveedor a eliminar:");
    
    if (nameToDelete != null && !nameToDelete.isEmpty()) {
        SuplierController.removeSuplierByName(nameToDelete);
    }
}    
   
    
    
    private void txtNameSuplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameSuplierKeyTyped
        if(!(Character.isLetter(evt.getKeyChar()))){
            evt.consume();
        }
    }//GEN-LAST:event_txtNameSuplierKeyTyped

    private void txtPhoneSuplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneSuplierKeyTyped
        int key = evt.getKeyChar();
        
        boolean number = key >= 48 && key <= 57;
        
        if (!number){
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneSuplierKeyTyped

    private void btnCancelSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelSuplierActionPerformed
        FrmBuyMenu frmBuyMenu= new FrmBuyMenu();
        frmBuyMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelSuplierActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSuplier().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnModifySuplier;
    public javax.swing.JLabel Correo;
    public javax.swing.JLabel Direccion;
    public javax.swing.JLabel Nombre;
    public javax.swing.JLabel Telefono;
    private javax.swing.JLabel Titulo;
    public javax.swing.JButton btnAddSuplier;
    public javax.swing.JButton btnCancelSuplier;
    public javax.swing.JButton btnDeleteSuplier;
    public javax.swing.JButton btnSearchSuplier;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField txtDirectionSuplier;
    public javax.swing.JTextField txtEmailSuplier;
    public javax.swing.JTextField txtNameSuplier;
    public javax.swing.JTextField txtPhoneSuplier;
    // End of variables declaration//GEN-END:variables

}
