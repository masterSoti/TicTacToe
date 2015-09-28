/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author suyog
 */
public class MousePlay {
    static class panel implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Object source = me.getSource();
            TicTacToe.Panel panel = (TicTacToe.Panel) source;
            if(panel.getBackground() != Color.green && panel.getBackground() != Color.red){
                TicTacToe.turn++;
                if(TicTacToe.turn % 2 != 0){
                    panel.setBackground(Color.red);
                    panel.color = panel.getBackground();
                }else{
                    panel.setBackground(Color.green);
                    panel.color = panel.getBackground();
                }
            }
            System.out.println(func.check()[0]);
        }

        @Override
        public void mousePressed(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Object source = me.getSource();
            TicTacToe.Panel panel = (TicTacToe.Panel) source;
            if(panel.getBackground() != Color.green && panel.getBackground() != Color.red){
                panel.setBackground(Color.yellow);
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Object source = me.getSource();
            TicTacToe.Panel panel = (TicTacToe.Panel) source;
            panel.setBackground(panel.color);
        }
        
    }
    private static class func{
        private static boolean[] check(){
            /*
                Check which grids are green and which are red. Return and Danger grids
            */
            boolean[] z = new boolean[9];
            for(int i = 0; i < 9; i++){
                JPanel s = (JPanel) TicTacToe.mainFrame.getContentPane().getComponent(i);
                if(s.getBackground() != Color.white){
                    z[i] = true;
                }else{
                    z[i] = false;
                }
            }
            return z;
        }
        private static boolean win(boolean[] arr){
            for(int i = 0; i < arr.length; i++){
                
            }
            return true;
        }
    }
}
