/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFrame;

import static fullgame.FullGame.*;
import static gameActions.mainActions.createGame;
import static startscreen.startscreen.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Tobias
 */
public class mainFrame {
    public static void startGame(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("FrameAPI by Tobi");
        frame.setSize(1300,1030);
        frame.setLayout(null);
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        Color g = new Color(129,210,105);
        frame.getContentPane().setBackground(g);
        exitbtn.setBounds(1000, 600, 120, 40);
        exitbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(running){
                    timer.cancel();
                    System.out.println("Timer stopped");
                    running = false;
                }
                
                frame.setVisible(false);
                startScreen();
            }
        });
        runde.setBounds(1000, 120, 120, 40);
        frame.add(runde);
        frame.add(exitbtn);
        
        frame.setLocation((int)(dim.getWidth()-1300)/2,(int)(dim.getHeight()-1030)/2);
        frame.setVisible(true);
        
        createGame();
        
    }
    public static void clearFrame(){
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        exitbtn.setBounds(1000, 240, 120, 40);
        runde.setBounds(1000, 120, 120, 40);
        runde.setText("Aktuelle Runde: " + zustand);
        JLabel halive = new JLabel("Lebende Hasen: 0");
        halive.setBounds(1000, 160, 120, 40);
        frame.add(exitbtn);
        frame.add(runde);
        frame.add(halive);
    }
}
