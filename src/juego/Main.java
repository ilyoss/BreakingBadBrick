/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import javax.swing.JFrame;
/**
 *
 * @author Iliana
 */
public class Main {
    
    public static void main(String[] args){
        juego.Juego jueJuego = new juego.Juego();
        jueJuego.setVisible(true);
        jueJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
