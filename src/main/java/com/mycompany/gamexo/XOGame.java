package com.mycompany.gamexo;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class XOGame extends JFrame implements ActionListener{
        
        // Initialization 
        Random random =new Random();
        JLabel TextField = new JLabel(); ;
        JButton buttons [] = new JButton[9];
        JPanel button_panel= new JPanel(); 
        JPanel Title_Panel = new JPanel();
        boolean Player1_Turn;

        Font myfont = new Font("Serif", Font.BOLD, 50);
        Font myfont1 = new Font("Serif", Font.BOLD, 100);
    
        // Constructor 
    XOGame (){
    
        setTitle("X_O Game ");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(550,200);
        getContentPane().setBackground(Color.GRAY);
        setLayout(new BorderLayout());
        
        // Set Up The Title Label
        
        TextField.setBackground(Color.BLACK);
        TextField.setForeground(Color.GREEN);
        TextField.setFont(myfont);
        TextField.setHorizontalAlignment(JLabel.CENTER);
        TextField.setOpaque(true);
        
        // Set Up The Panels
        
        Title_Panel.setLayout(new BorderLayout());
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.LIGHT_GRAY);
        
        // Initializing Buttons
        
        for (int i=0;i<9;i++) {
            buttons[i] = new JButton() ;
            button_panel.add(buttons[i]);
            buttons[i].setFont(myfont1);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        
        // Add Components to The Frame
        
        Title_Panel.add(TextField);
        this.add(Title_Panel,BorderLayout.NORTH);
        this.add(button_panel);
        this.setVisible(true); 
        
         // Starting The Game
        
        FirstTurn() ;
                }
    
    // Action Performed When a Button is Clicked
    
   @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0 ; i<9 ; i++ ){
            if (e.getSource()==buttons[i]){
                if (Player1_Turn){
                    if ("".equals(buttons[i].getText() )){
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        Player1_Turn=false;
                        TextField.setText("O Turn");
                        Check();                  } } 
                    else {
                        if ("".equals(buttons[i].getText() )){
                            buttons[i].setForeground(Color.ORANGE);
                            buttons[i].setText("O");
                            Player1_Turn=true;
                            TextField.setText("X Turn");
                            Check();  } } } } }
    
    // Determine The First Turn Randomly
    
    public void FirstTurn (){
        if (random.nextInt(2)==0){
        Player1_Turn=true;
        TextField.setText("X Turn");
                                        }
        else {
        Player1_Turn=false;
        TextField.setText("O Turn");
              }
                            }

    public void Check (){
        //Check X is Win  
        if (("X".equals(buttons[0].getText() )) &&
            ("X".equals(buttons[1].getText() ))&&  
            ("X".equals(buttons[2].getText() )))
            XWins(0,1,2);
        
    else if (("X".equals(buttons[3].getText() )) &&
            ("X".equals(buttons[4].getText() ))&&  
            ("X".equals(buttons[5].getText() )))
            XWins(3,4,5);
        
    else if (("X".equals(buttons[6].getText() )) &&
            ("X".equals(buttons[7].getText() ))&&  
            ("X".equals(buttons[8].getText() )))
            XWins(6,7,8);
        
    else if (("X".equals(buttons[0].getText() )) &&
            ("X".equals(buttons[3].getText() ))&&  
            ("X".equals(buttons[6].getText() )))
            XWins(0,3,6);
        
    else if (("X".equals(buttons[1].getText() )) &&
            ("X".equals(buttons[4].getText() ))&&  
            ("X".equals(buttons[7].getText() )))
            XWins(1,4,7);
        
    else if (("X".equals(buttons[2].getText() )) &&
            ("X".equals(buttons[5].getText() ))&&  
            ("X".equals(buttons[8].getText() )))
            XWins(2,5,8);
        
    else if (("X".equals(buttons[2].getText() )) &&
            ("X".equals(buttons[4].getText() ))&&  
            ("X".equals(buttons[6].getText() )))
            XWins(2,4,6);
        
    else if (("X".equals(buttons[0].getText() )) &&
            ("X".equals(buttons[4].getText() ))&&  
            ("X".equals(buttons[8].getText() )))
            XWins(0,4,8);    
        
    // Check O is Win 
     if (("O".equals(buttons[0].getText() )) &&
            ("O".equals(buttons[1].getText() ))&&  
            ("O".equals(buttons[2].getText() )))
            OWins(0,1,2);
        
    else if (("O".equals(buttons[3].getText())) &&
            ("O".equals(buttons[4].getText()))&&  
            ("O".equals(buttons[5].getText())))
            OWins(3,4,5);
        
    else if (("O".equals(buttons[6].getText() )) &&
            ("O".equals(buttons[7].getText() ))&&  
            ("O".equals(buttons[8].getText() )))
            OWins(6,7,8);
        
    else if (("O".equals(buttons[0].getText() )) &&
            ("O".equals(buttons[3].getText() ))&&  
            ("O".equals(buttons[6].getText() )))
            OWins(0,3,6);
        
    else if (("O".equals(buttons[1].getText() )) &&
            ("O".equals(buttons[4].getText() ))&&  
            ("O".equals(buttons[7].getText() )))
            OWins(1,4,7);
        
    else if (("O".equals(buttons[2].getText() )) &&
            ("O".equals(buttons[5].getText() ))&&  
            ("O".equals(buttons[8].getText() )))
            OWins(2,5,8);
        
    else if (("O".equals(buttons[2].getText() )) &&
            ("O".equals(buttons[4].getText() ))&&  
            ("O".equals(buttons[6].getText() )))
            OWins(2,4,6);
        
    else if (("O".equals(buttons[0].getText() )) &&
            ("O".equals(buttons[4].getText() ))&&  
            ("O".equals(buttons[8].getText() )))
            OWins(0,4,8); 
     // Check is Draw
    else if (Player1_Turn) {
                boolean Draw = true;    
            for (int i = 0; i < 9; i++) {
                if (buttons[i].getText().equals("")) {
                    Draw = false;
                         break; } }
                    if (Draw) {
                        Draw(); } } }
    
    // Handle The X is WIN Condition

    public void XWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0 ; i<9 ; i++)
            buttons[i].setEnabled(false);
        TextField.setText("X is Win");
    }
    
        // Handle The O is WIN Condition

    public void OWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0 ; i<9 ; i++)
            buttons[i].setEnabled(false);
        TextField.setText("O is Win");
    }

    // Handle The Draw Condition
    
    public void Draw (){
        for (int i = 0; i < 9; i++) 
            buttons[i].setEnabled(false);
        TextField.setText("Draw");

    }
}
