/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fullgame;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import static startscreen.startscreen.*;
/**
 *
 * @author Tobias
 */
public class FullGame {
    
    private static ClassLoader cl = FullGame.class.getClassLoader();
    
    // Game Frame Settings
    public static JFrame frame;
    public static int zustand = 1;
    public static JLabel runde = new JLabel("Aktuelle Runde: " + zustand);
    public static JButton exitbtn = new JButton("Exit To Menu");
    
    //Timer Settings
    public static java.util.Timer timer;
    public static boolean running = false;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Call the Launching Screen
        startScreen();
    }
    
    public static int randomInt(int max){ 
        Random rand = new Random();
        int randInt = rand.nextInt(max++);
        
        return randInt;
    }
    
    public static void addText(String text, int x, int y, int w, int h, JFrame f){
        if(f == frame){
            ImageIcon icon = new ImageIcon(cl.getResource("images/grass.png"));
             if(text.equals("H")){
                icon = new ImageIcon(cl.getResource("images/bunny.png"));
            } else if(text.equals(".")) {
                 icon = new ImageIcon(cl.getResource("images/grass.png"));
            } else if(text.equals("F")){
                icon = new ImageIcon(cl.getResource("images/fox.png"));
            }
            JLabel label = new JLabel(icon);
            frame.add(label);
            label.setBounds(x, y, w, h);
        } else {
            JLabel label = new JLabel(text);
            label.setFont(new Font("Dialog", 0, 12));
            label.setForeground(new Color(236, 240, 241));
            f.add(label);
            label.setBounds(x, y, w, h);
        }
    }
    
}
