/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startscreen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import static gameFrame.mainFrame.*;
import java.awt.Color;
import static scores.scoreScreen.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Tobias
 */
public class startscreen {
    
    // rgb(155, 90, 182) BACKGROUND
    // rgb(236, 240, 241) TITLE
    
    public static void startScreen() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        final JFrame start = new JFrame("Game Menu");
        Color bg = new Color(155, 90, 182);
        start.setSize(400, 560);
        start.setLayout(null);
        start.getContentPane().removeAll();
        start.revalidate();
        start.repaint();
        start.getContentPane().setBackground(bg);
        //Buttons
        JButton b1 = new JButton("Start Game");
        b1.setBounds(100, 160, 200, 40);
        b1.setBackground(new Color(236, 240, 241));
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                start.setVisible(false);
                startGame();
            }
        });
        
        JButton b2 = new JButton("Highscores");
        b2.setBounds(100, 240, 200, 40);
        b2.setBackground(new Color(236, 240, 241));
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                start.setVisible(false);
                startScores();
            }
        });
        
        JButton b3 = new JButton("Exit");
        b3.setBounds(100, 420, 200, 40);
        b3.setBackground(new Color(231, 76, 60));
        b3.setForeground(new Color(236, 240, 241));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        //Labels
        JLabel cp = new JLabel("Game coded by Tobias Dittmann");
        cp.setFont(new Font("Dialog", 0, 12));
        cp.setBounds(5, 500, 200, 12);
        
        JLabel title = new JLabel("Hasengame 2.0!");
        title.setFont(new Font("Dialog", 0, 32));
        title.setBounds(84, 60, 300, 34);
        title.setForeground(new Color(236, 240, 241));
        
        //Frame setten
        start.add(b1);
        start.add(b2);
        start.add(b3);
        start.add(cp);
        start.add(title);
        start.setLocation((int)(dim.getWidth()-400)/2,(int)(dim.getHeight()-560)/2);
        start.setVisible(true);
    }
    
}
