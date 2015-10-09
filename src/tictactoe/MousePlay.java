/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
            int winner = func.win(func.check());
            if(winner > 0){
                func.GameOver(winner);
            }
            TicTacToe.mainFrame.validate();
            int[][] arr = func.check();
            func.comChose(arr);
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
        private static int win(int[][] arr){
            int p1_left_diag = 0;
            int p2_left_diag = 0;
            for(int i = 0; i < 3; i++){
                int p1_counter_vertical = 0;
                int p2_counter_vertical = 0;
                int p1_counter_horizontal = 0;
                int p2_counter_horizontal = 0;
                for(int x = 0; x < 3; x++){
                    int x_cord = i + 1;
                    int y_cord = x + 1;
                    System.out.print("(" + x_cord + ", " + y_cord + "): " +arr[i][x] + "\t");
                    if(arr[i][x] == 1){
                        p1_counter_horizontal++;
                    }else if(arr[i][x] == 2){
                        p2_counter_horizontal++;
                    }
                    if(arr[x][i] == 1){
                        p1_counter_vertical++;
                    }else if(arr[x][i] == 2){
                        p2_counter_vertical++;
                    }
                    if(x == i){
                        if(arr[x][i] == 1){
                            p1_left_diag++;
                        }else if(arr[x][i] == 2){
                            p2_left_diag++;
                        }
                    }
                }
                System.out.println();
                if(p1_counter_horizontal == 3 || p1_counter_vertical == 3 || p1_left_diag == 3){
                    System.out.println("RED WINS");
                    return 1;
                }else if(p2_counter_horizontal == 3 || p2_counter_vertical == 3 || p2_left_diag == 3){
                    System.out.println("GREEN WINS");
                    return 2;
                }
                //for the diagonal on the other side
                if(arr[2][0] == arr[1][1] && arr[0][2] == arr[1][1]){
                    return arr[1][1];
                }
            }
            System.out.println("==========================================");
            return 0;
        }
        private static void GameOver(int winner){
            TicTacToe.mainFrame.getContentPane().removeAll();
            TicTacToe.mainFrame.getContentPane().repaint();
            JPanel p = TicTacToe.whoWon;
            JTextField t = new JTextField();
            if(winner == 1){
                t.setText("Player One Won!!!!!");
            }else if(winner == 2){
                t.setText("Player Two Won!!!!!");
            }
            t.setFont(new Font("Engravers MT", Font.BOLD, 23));
            t.setEditable(false);
            p.add(t);
            TicTacToe.mainFrame.add(p);
        }
        private static int comChose(int[][] arr){
            if (closeWin() > 0) {
                TicTacToe.Panel p = (TicTacToe.Panel) TicTacToe.mainFrame.getContentPane().getComponent(closeWin());
            }
            return 0;
        }
        private static int closeWin(){
            if (true) {
                
            }
            return 0;
        }
    }
}
