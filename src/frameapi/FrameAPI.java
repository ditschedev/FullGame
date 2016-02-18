/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameapi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author tobias.dittmann
 */
public class FrameAPI {
    
    private static JFrame frame;
    private static int zustand = 0;
    private static JLabel runde = new JLabel("Aktuelle Runde: " + zustand);
    private static int hasenalive;
    public static boolean allDead = false;
    private static String[][] play;
    private static ClassLoader cl = FrameAPI.class.getClassLoader();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public static int randomInt(int max){ 
        Random rand = new Random();
        int randInt = rand.nextInt(max++);
        
        return randInt;
    }
    
    public static void initFrame(){
        frame = new JFrame("FrameAPI by Tobi");
        frame.setSize(1300,1030);
        frame.setLayout(null);
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        Color g = new Color(129,210,105);
        frame.getContentPane().setBackground(g);
        frame.setVisible(true);
      
        runde.setBounds(1000, 120, 120, 40);
        frame.add(runde);
    }
    
    public static void initString(int length, String[][] ground){
        play = new String[length][length];
        
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                play[i][j] = ground[i][j];
            }
        }
        
    }
    
    public static void setPlayground(){
        zustand++;
        hasenalive = countHasen();
        clearFrame();
        
        int xwert = 64;
        int ywert = 64;
        
        for(int x=0;x<play.length;x++){
            for(int y=0;y<play.length;y++){
                addText(play[x][y], xwert, ywert,64,64);
                xwert=xwert+64;
            }
            ywert=ywert+64;
            xwert=64;
        }
        
        
    }
    
    private static void clearFrame(){
        Color w = new Color(255,255,255);
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        runde.setBounds(1000, 120, 120, 40);
        runde.setBounds(1000, 400, 400, 40);
        runde.setText("Aktuelle Runde: " + zustand);
        runde.setForeground(w);
        runde.setFont(new Font("Dialog", 0, 32));
        JLabel halive = new JLabel("Lebende Hasen: " + hasenalive);
        halive.setBounds(1000, 160, 120, 40);
        halive.setForeground(w);
        frame.add(runde);
        frame.add(halive);
    }
    
    private static int countHasen(){
        
        int hasenint = 0;
        
        for(int x=0;x<play.length;x++){
            for(int y=0;y<play.length;y++){
                if(play[x][y] == "H"){
                    hasenint++;
                }
            }
        }
        
        return hasenint;
    }
    
    public static void addText(String text, int x, int y, int w, int h){
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
    }
    
}
