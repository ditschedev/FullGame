/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scores;

import static fullgame.FullGame.addText;
import static gameFrame.mainFrame.startGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static scores.mainScores.*;
import static startscreen.startscreen.*;

/**
 *
 * @author tobias.dittmann
 */
public class scoreScreen {
    
    // rgb(52, 73, 94) BACKGROUND
    public static Color w = new Color(236, 240, 241);
    
    private static final JFrame score = new JFrame("Highscores");
    
    public static void startScores() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        score.setSize(400, 560);
        score.setLayout(null);
        score.getContentPane().removeAll();
        score.revalidate();
        score.repaint();
        score.getContentPane().setBackground(new Color(52, 73, 94));
        
        //Buttons
        JButton b1 = new JButton("Back");
        b1.setBounds(100, 340, 200, 40);
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                score.setVisible(false);
                startScreen();
            }
        });
        
        //Labels
        JLabel cp = new JLabel("Your best 10 scores:");
        cp.setFont(new Font("Dialog", 0, 30));
        cp.setForeground(w);
        cp.setBounds(50, 30, 300, 32);
        setHighscores();
        
        int yw = 80;
        for(int i = 0; i<highscore.length; i++){
            JLabel h;
            String arr = String.valueOf(highscore[i]);
            addText(arr, 50,yw,200,16,score);
            yw=yw+20;
        }
        
        //Frame setten
        score.add(b1);
        score.add(cp);
        score.setLocation((int)(dim.getWidth()-400)/2,(int)(dim.getHeight()-560)/2);
        score.setVisible(true);
    }

    private static void setHighscores() {
        for(int i = 0; i<highscore.length; i++){
            highscore[i] = 10;
        }
    }
}
