/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
  * @author Salsabila Firdausi
 */
public class HelloWorldMain {
    private static void createAndShowGUI() {
    JFrame frame = new JFrame("Hello World Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel label = new JLabel("Hello pacar aku");
    frame.getContentPane().add(label);
    
    frame.pack();
    frame.setVisible(true);
    }
    
    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}