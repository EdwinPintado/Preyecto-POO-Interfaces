/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.principalview;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Usuario
 */
public class Fondo extends JDesktopPane {

    private Image imagen;

    public Fondo() {

        ImageIcon icono = new ImageIcon(
                getClass().getResource("/ec/edu/ups/sistemabiblioteca/pictures/fondoB.png"));

        imagen = icono.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(
                imagen,
                0,
                0,
                getWidth(),
                getHeight(),
                this
        );
    }
}
