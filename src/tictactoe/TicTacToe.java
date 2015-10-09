/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author suyog
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    static JFrame mainFrame = new JFrame("Tic Tac Toe");
    static JPanel whoWon = new JPanel();
    
    public static int turn = 0;
    
    static class Panel extends JPanel{
        Color color = Color.white;
        Panel(){
            this.addMouseListener(new MousePlay.panel());
            this.setBackground(color);
            mainFrame.add(this);
            this.setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }
    
    public static void display_designs(){
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Panel panel4 = new Panel();
        Panel panel5 = new Panel();
        Panel panel6 = new Panel();
        Panel panel7 = new Panel();
        Panel panel8 = new Panel();
        Panel panel9 = new Panel();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        display_designs();
        mainFrame.setSize(500, 500);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(3, 3));
        mainFrame.setBackground(Color.white);
        mainFrame.validate();
    }
    
}
