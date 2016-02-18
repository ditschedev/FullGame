/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameActions;

import java.util.Timer;
import java.util.TimerTask;
import static fullgame.FullGame.*;
import static gameFrame.mainFrame.clearFrame;

/**
 *
 * @author Tobias
 */
public class mainActions {
    
    public static String[][] feld = new String[14][14];
    public static String[][] bun = new String[14][14];
    public static String[][] fox = new String[14][14];
    
    public static void createGame(){
        
        addPlayground();
        printToScreen();
        timer = new Timer();
        TimerTask setFields = new TimerTask() {

            @Override
            public void run() {
                System.out.println("Do Something HERE");
            }
        };

        timer.schedule(setFields, 0, 1000);
        running = true;
    }
    private static void addPlayground(){
        for(int i=0; i<feld.length; i++){
            for(int j=0; j<feld.length; j++){
                feld[i][j] = ".";
            }
        }
        for(int i=0; i<bun.length; i++){
            for(int j=0; j<bun.length; j++){
                int r = randomInt(20);
                if(r == 14){
                    bun[i][j] = "H";
                } else {
                    bun[i][j] = ".";
                }
            }
        }
        
        for(int i=0; i<fox.length; i++){
            for(int j=0; j<fox.length; j++){
                int r = randomInt(40);
                if(r == 26){
                    fox[i][j] = "F";
                } else {
                    fox[i][j] = ".";
                }
            }
        }
        
        for(int i=0; i<feld.length; i++){
            for(int j=0; j<feld.length; j++){
                if(fox[i][j] == "F"){
                    feld[i][j] = "F";
                } if(bun[i][j] == "H"){
                    feld[i][j] = "H";
                } else {
                    feld[i][j] = ".";
                }
            }
        }
    }
    
    public static void printToScreen(){
        zustand++;
        //hasenalive = countHasen();
        clearFrame();
        
        int xwert = 64;
        int ywert = 64;
        
        for(int x=0;x<feld.length;x++){
            for(int y=0;y<feld.length;y++){
                addText(feld[x][y], xwert, ywert,64,64,frame);
                xwert=xwert+64;
            }
            ywert=ywert+64;
            xwert=64;
        }
    }
}
