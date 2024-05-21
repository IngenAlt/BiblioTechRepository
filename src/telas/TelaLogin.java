package telas;

import Dados.BiblioDao;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        txtUsuario.requestFocus();
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnCriarConta = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();
        btnEsqueceuSenha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BiblioTech");
        getContentPane().setLayout(null);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(46, 185, 217, 45);

        txtEmail.setVerifyInputWhenFocusTarget(false);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail);
        txtEmail.setBounds(46, 236, 217, 46);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(46, 294, 217, 46);

        btnCriarConta.setBackground(new java.awt.Color(153, 153, 255));
        btnCriarConta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCriarConta.setForeground(new java.awt.Color(255, 255, 255));
        btnCriarConta.setText("CADASTRE-SE");
        btnCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarContaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCriarConta);
        btnCriarConta.setBounds(50, 430, 220, 50);

        btnEntrar.setBackground(new java.awt.Color(153, 153, 255));
        btnEntrar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Login");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(60, 380, 190, 40);

        lblEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblEmail.setText("Email:");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(0, 240, 37, 30);

        lblNome.setForeground(new java.awt.Color(0, 0, 0));
        lblNome.setText("Nome:");
        getContentPane().add(lblNome);
        lblNome.setBounds(0, 190, 37, 30);

        lblSenha.setForeground(new java.awt.Color(0, 0, 0));
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(0, 300, 37, 30);

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/TelaLogin(Biblio).jpg"))); // NOI18N
        getContentPane().add(lblImagem);
        lblImagem.setBounds(0, 0, 323, 580);

        btnEsqueceuSenha.setText("Esqueceu senha");
        btnEsqueceuSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsqueceuSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEsqueceuSenha);
        btnEsqueceuSenha.setBounds(80, 347, 150, 23);

        setSize(new java.awt.Dimension(335, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // Códigos do botão:
        try {
            ResultSet resultado = BiblioDao.fazerLogin (txtUsuario.getText(), txtEmail.getText(), txtSenha.getText());
            
            if (resultado.next()) {
                dispose();
                new TelaMenu().setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog (null,"usuário, email e/ou senha inválidos");
            }
            
        } catch (ClassNotFoundException x) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado " + x.getMessage());
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados " + x.getMessage());
        }

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSenhaKeyPressed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnEntrarKeyPressed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here: 
        
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarContaActionPerformed
        // TODO add your handling code here:
        new TelaCadastro().setVisible(true);
    }//GEN-LAST:event_btnCriarContaActionPerformed

    private void btnEsqueceuSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsqueceuSenhaActionPerformed
        // TODO add your handling code here:
        new TelaEsqueceuSenha().setVisible(true);
    }//GEN-LAST:event_btnEsqueceuSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarConta;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnEsqueceuSenha;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
