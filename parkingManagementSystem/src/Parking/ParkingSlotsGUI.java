package Parking;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ParkingSlotsGUI extends superGUI{
    public ParkingSlotsGUI(JFrame frame, JLabel labelOne, JLabel labelTwo, JButton buttonOne, Border border)
    {
        super(frame,labelOne,labelTwo,buttonOne,border);

        //make label for the Available Slots
        getLabelOne().setBounds(45,150,400,150);
        makeLabel(getLabelOne());

        //create a basic frame
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setLayout(null);
        getFrame().setResizable(false);
        getFrame().setSize(500,500);
        getFrame().setVisible(true);
        getFrame().getContentPane().setBackground(new Color(200,200,200));

    }
}
