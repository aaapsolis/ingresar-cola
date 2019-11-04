package Formulario;

import java.sql.*;
import Clases.*;
import javax.swing.JOptionPane;


public class Ingreso_Clientes extends javax.swing.JFrame {
    
    BdMysql cc = new BdMysql();
    Connection con= cc.conexion();
    ColaDinamica<Cliente> listado = new ColaDinamica<>();
    Cliente clie;

    public Ingreso_Clientes() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelNombre = new javax.swing.JLabel();
        LabelApellido = new javax.swing.JLabel();
        labelNit = new javax.swing.JLabel();
        TexfielNombre = new javax.swing.JTextField();
        TexfielApellido = new javax.swing.JTextField();
        Texfielnit = new javax.swing.JTextField();
        BotonEncolar = new javax.swing.JButton();
        BotonAtender = new javax.swing.JButton();
        NombreTienda = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(21, 93, 116));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelNombre.setForeground(java.awt.Color.white);
        LabelNombre.setText("Nombre");
        jPanel1.add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 60, 30));

        LabelApellido.setForeground(java.awt.Color.white);
        LabelApellido.setText("Apellido");
        jPanel1.add(LabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 60, 20));

        labelNit.setForeground(java.awt.Color.white);
        labelNit.setText("Nit");
        jPanel1.add(labelNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 30, 20));
        jPanel1.add(TexfielNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 254, -1));
        jPanel1.add(TexfielApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 254, -1));
        jPanel1.add(Texfielnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 254, -1));

        BotonEncolar.setText("Encolar");
        BotonEncolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEncolarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonEncolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 92, -1));

        BotonAtender.setText("Atender");
        BotonAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtenderActionPerformed(evt);
            }
        });
        jPanel1.add(BotonAtender, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 92, -1));

        NombreTienda.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        NombreTienda.setForeground(java.awt.Color.white);
        NombreTienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NombreTienda.setText("TIENDA CHATOS");
        jPanel1.add(NombreTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 450, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 130, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void NuevoCliente(){
    
        try {
            
            String SQL = "insert into clientes (nombre,apellido,nit) values (?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            while (!listado.isEmpty()) {
                clie = listado.dequeue();

            pst.setString(1, clie.getNombre());
            pst.setString(2, clie.getApellido());
            pst.setInt(3, clie.getNit());
            
            
            
            
            pst.execute();

            }
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error de Registo" + e.getMessage());
            
        }
    }
        
    
    private void BotonEncolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEncolarActionPerformed
        
        clie = new Cliente(TexfielNombre.getText(), TexfielApellido.getText(),Integer.parseInt(Texfielnit.getText()));
        listado.enqueue(clie);
        
        TexfielNombre.setText("");
        TexfielApellido.setText("");
        Texfielnit.setText("");    
    }//GEN-LAST:event_BotonEncolarActionPerformed

    private void BotonAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAtenderActionPerformed
            NuevoCliente();     
    }//GEN-LAST:event_BotonAtenderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ingreso_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso_Clientes().setVisible(true);
            }
        });
    }
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAtender;
    private javax.swing.JButton BotonEncolar;
    private javax.swing.JLabel LabelApellido;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel NombreTienda;
    private javax.swing.JTextField TexfielApellido;
    private javax.swing.JTextField TexfielNombre;
    private javax.swing.JTextField Texfielnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNit;
    // End of variables declaration//GEN-END:variables
}
