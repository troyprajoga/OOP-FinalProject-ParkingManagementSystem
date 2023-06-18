package Parking;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
public class LeaveGUI extends superGUI{
    //Initializes elements and frame of leaveGUI
    JLabel levelLabel = new JLabel();
    JLabel rowLabel = new JLabel();
    JLabel colLabel = new JLabel();
    JLabel levelValue = new JLabel();
    JLabel rowValue = new JLabel();
    JLabel colValue = new JLabel();
    JLabel payTicket = new JLabel();
    public LeaveGUI(JFrame frame,JLabel labelOne,JLabel labelTwo,JButton buttonOne,Border border)
    {
        super(frame,labelOne,labelTwo,buttonOne,border);
        //Make the labels for where the car is parked
        //and also how much payment is due
        getLabelOne().setText("Your Car is Parked at ");
        makeLabel(getLabelOne());
        getLabelOne().setBounds(0,0,300,200);

        levelLabel.setText("Level");
        makeLabel(levelLabel);
        levelLabel.setBounds(300,0,100,100);

        rowLabel.setText("Row");
        makeLabel(rowLabel);
        rowLabel.setBounds(400,0,100,100);

        colLabel.setText("Col");
        makeLabel(colLabel);
        colLabel.setBounds(500,0,100,100);

        makeLabel(levelValue);
        levelValue.setBounds(300,100,100,100);

        makeLabel(rowValue);
        rowValue.setBounds(400,100,100,100);

        makeLabel(colValue);
        colValue.setBounds(500,100,100,100);

        payTicket.setText("Payment Due: ");
        makeLabel(payTicket);
        payTicket.setBounds(0,400,300,165);

        makeLabel(getLabelTwo());
        getLabelTwo().setBounds(300,400,300,165);

        //This button will close the program
        getButtonOne().setText("Leave Parking");
        getButtonOne().setFocusable(false);
        getButtonOne().setBounds(100,200,400,200);
        getButtonOne().setFont(new Font("Times New Roman",Font.BOLD,40));
        getButtonOne().addActionListener(this);
        getFrame().add(getButtonOne());

        //Frame for leaveGUI
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setLayout(null);
        getFrame().setVisible(false);
        getFrame().setSize(615,600);
        getFrame().getContentPane().setBackground(new Color(200,200,200));
        getFrame().setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getButtonOne())
        {
            //if button is pressed, close program
            System.exit(0);
        }
    }
}
