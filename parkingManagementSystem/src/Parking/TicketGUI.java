package Parking;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TicketGUI extends superGUI {
    public TicketGUI(JFrame frame,JLabel labelOne,JLabel labelTwo,JButton buttonOne,Border border)
    {
        super(frame,labelOne,labelTwo,buttonOne,border);
        //make labels for the gui
        getLabelOne().setText("Enter Parking");
        getLabelOne().setBounds(145,0,200,150);
        makeLabel(getLabelOne());

        getLabelTwo().setText("Every Action is 5 Minutes");
        getLabelTwo().setBounds(45,314,400,150);
        makeLabel(getLabelTwo());

        //make the ticket button to open the ParkingGUI
        getButtonOne().setBounds(100,150,285,165);
        getButtonOne().setText("Get Ticket");
        getButtonOne().setFont(new Font("Times New Roman",Font.BOLD,30));
        getButtonOne().setFocusable(false);
        getButtonOne().addActionListener(this);
        getFrame().add(getButtonOne());

        //makes the layout of the frame
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setLayout(null);
        getFrame().setResizable(false);
        getFrame().setSize(500,500);
        getFrame().setVisible(true);
        getFrame().getContentPane().setBackground(new Color(200,200,200));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getButtonOne())
        {
            //if get ticket button is pressed, make parking lot
            getFrame().setVisible(false);
            new ParkingLot();
        }
    }
}
