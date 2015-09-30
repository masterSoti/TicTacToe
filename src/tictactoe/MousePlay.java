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
            func.win(func.check());
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
        private static int[][] check(){
            /*
                Check which grids are green and which are red. Return and Danger grids
            */
            int counter = 0;
            int[][] z = new int[3][3];
            for(int i = 0; i < 3; i++){
                for(int x = 0; x < 3; x++){
                    JPanel s = (JPanel) TicTacToe.mainFrame.getContentPane().getComponent(counter);
                    if(s.getBackground() == Color.red){
                        z[i][x] = 1;
                    }else if(s.getBackground() == Color.green){
                        z[i][x] = 2;
                    }else{
                        z[i][x] = 0;
                    }
                    counter++;
                }

            }
            return z;
        }
        private static boolean win(int[][] arr){
            for(int i = 0; i < 3; i++){
                for(int x = 0; x < 3; x++){
                    int x_cord = i + 1;
                    int y_cord = x + 1;
                    System.out.print("(" + x_cord + ", " + y_cord + "): " +arr[i][x] + "\t");
                }
                System.out.println();
            }
            System.out.println("==========================================");
            return true;
        }
    }
}
