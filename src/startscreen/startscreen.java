/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startscreen;

import static fullgame.FullGame.running;
import static fullgame.FullGame.timer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import static gameFrame.mainFrame.*;
import java.awt.Color;
import static scores.scoreScreen.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Tobias
 */
public class startscreen {
    
    private static int step;
    private static boolean timerrun = false;
    
    // rgb(155, 90, 182) BACKGROUND
    // TURQ rgb(26, 188, 156)
    // ORAGNE rgb(230, 126, 34)
    // YELL rgb(243, 156, 18)
    // GREEN rgb(46, 204, 113)
    // rgb(236, 240, 241) TITLE
    
    public static void startScreen() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        final JFrame start = new JFrame("Game Menu");
        start.setSize(400, 560);
        start.setLayout(null);
        start.getContentPane().removeAll();
        start.revalidate();
        start.repaint();
        
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
                if(timerrun == true){
                    timer.cancel();
                }
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
                if(timerrun == true){
                    timer.cancel();
                }
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
        
        startTimer(start);
    }

    private static void startTimer(final JFrame start) {
        timerrun = true;
        step = 0;
        timer = new Timer();
        TimerTask setFields = new TimerTask() {

            @Override
            public void run() {
                Color bg = new Color(155, 90, 182);
                if(step == 0){
                    bg = new Color(155, 90, 182);
                } else if(step == 1){
                    bg = new Color(26, 188, 156);
                } else if(step == 2){
                    bg = new Color(230, 126, 34);
                } else if(step == 3){
                    bg = new Color(243, 156, 18);
                } else if(step == 4){
                    bg = new Color(46, 204, 113);
                    step = 0;
                }
                step++;
                start.getContentPane().setBackground(bg);
            }
        };

        timer.schedule(setFields, 0, 1000);
    }
    
}
