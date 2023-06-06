/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package especialista.Controlador;

import especialista.Vista.Login;
import especialista.Vista.Inicio;
import comons.negocio.Especialista;
import especialista.EspecialistaDao.EspecialistaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static java.util.Objects.hash;

/**
 *
 * @author Usuario
 */
public class ControladorLogin implements ActionListener, KeyListener {

    private EspecialistaDao especialistadao;
    private Especialista especialista;
    private Login login;
    private Inicio inicio;

    public ControladorLogin(EspecialistaDao especialistadao, Especialista especialista, Login login, Inicio inicio) {
        this.especialistadao = especialistadao;
        this.especialista = especialista;
        this.inicio = inicio;
        this.login = login;
        this.login.btnIniciarsesion.addActionListener(this);
        login.txtContraseña.setText("");
        limpiarCampos();
        this.login.txtCedula.addKeyListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login.btnIniciarsesion) {
            String cedulaDigitada = login.txtCedula.getText();
            String contraseñaDigitada = new String(login.txtContraseña.getPassword());

            if (!cedulaDigitada.isEmpty() && !contraseñaDigitada.isEmpty()) {

                if (especialistadao.verificarCredenciales(cedulaDigitada, contraseñaDigitada) != null) {
                    Especialista especialista = especialistadao.verificarCredenciales(cedulaDigitada, contraseñaDigitada);

                    if (especialista.getId_especialidad() == 1) {
                        // Realizar acciones para el administrador
                        inicio.menuInicio.setVisible(false);
                        inicio.menuCitas.setVisible(false);
                        inicio.menuReportes.setVisible(false);
                    } else {
                        
                    }

                    // Ocultar ventana de inicio de sesión y mostrar ventana de inicio
                    login.setVisible(false);
                    inicio.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(login, "Error: Credenciales incorrectas");
                }

            } else {
                JOptionPane.showMessageDialog(login, "Error: Debes ingresar la cédula y la contraseña");
            }
        }

    }

    private void limpiarCampos() {

        login.txtCedula.setText(null);
        login.txtContraseña.setText(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            char numeros = e.getKeyChar();
            if (Character.isLetter(numeros)) {
                JOptionPane.showMessageDialog(null, "No se permite letras en este campo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                e.consume();
                login.txtCedula.requestFocus();
            } else {
                if (login.txtCedula.getText().length() >= 10) {
                    e.consume();
                    login.txtCedula.requestFocus();

                }
            }
        } catch (Exception ex) {
            System.err.println("Error al validat Campo Cédula ");
            System.err.println("Mensaje de error:" + ex.getMessage());
            System.err.println("Detalle del Error:");
            ex.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Evaluar si se está presionando una tecla específica en el campo de texto txtCedula
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            // La tecla Enter está siendo presionada en el campo de texto txtCedula
            // Realizar acciones correspondientes
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Tecla liberada: " + e.getKeyChar());
    }

}
