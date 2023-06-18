package Parking;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class ParkingGUI extends superGUI{
    //Initializing ParkingGUI Frame and elements
    JPanel levelPanel = new JPanel();
    JPanel timePanel = new JPanel();

    public ParkingGUI(JFrame frame,JLabel labelOne,JLabel labelTwo,JButton buttonOne,Border border)
    {
        super(frame,labelOne,labelTwo,buttonOne,border);
        //Make Label that displays the level of the parking Lot
        makeLabel(getLabelOne());
        getLabelOne().setBackground(new Color(200,200,200));
        levelPanel.setLayout(new BorderLayout());
        levelPanel.setBounds(0,0,600,100);
        levelPanel.add(getLabelOne());
        getFrame().add(levelPanel);

        //Make label that displays the Time
        getLabelTwo().setText("12:00");
        makeLabel(getLabelTwo());
        getLabelTwo().setBackground(new Color(200,200,200));
        timePanel.setLayout(new BorderLayout());
        timePanel.setBounds(600,0,190,100);
        timePanel.add(getLabelTwo());
        getFrame().add(timePanel);

        //Make the frame layout
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setSize(800,800);
        getFrame().setLayout(null);
        getFrame().setVisible(false);
        getFrame().setResizable(false);
        }
}
