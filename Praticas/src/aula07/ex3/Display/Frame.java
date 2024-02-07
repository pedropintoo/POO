package aula07.ex3.Display;

import aula07.ex3.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{

    private Panel panel;



    public Frame(Game game){

        this.panel = new Panel(game);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel); // Add panel to the frame
        this.pack();
        this.setLocationRelativeTo(null); // Frame appears in the middle of the sreen
        this.setVisible(true);
    }

}
