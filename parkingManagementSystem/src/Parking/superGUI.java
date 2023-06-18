package Parking;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class superGUI implements ActionListener
{
    //initializing elements that the GUIs will use
    JFrame frame = new JFrame();
    JLabel labelOne = new JLabel();
    JLabel labelTwo = new JLabel();
    JButton buttonOne = new JButton();
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    superGUI(){}
    public superGUI(JFrame frame,JLabel labelOne,JLabel labelTwo,JButton buttonOne,Border border)
    {
        //initialize objects of class
        this.frame = frame;
        this.labelOne = labelOne;
        this.labelTwo = labelTwo;
        this.buttonOne = buttonOne;
        this.border = border;
    }

    public JFrame getFrame()
    {
        //to call frame
        return this.frame;
    }
    public JLabel getLabelOne()
    {
        //to call label
        return this.labelOne;
    }
    public JLabel getLabelTwo()
    {
        //to call second label
        return this.labelTwo;
    }
    public JButton getButtonOne()
    {
        //to call button
        return this.buttonOne;
    }
    public Border getBorder()
    {
        //to call border
        return this.border;
    }
    public void makeLabel(JLabel label)
    {
        //makes the general label attributes
        label.setFont(new Font("Times New Roman",Font.BOLD,30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setBorder(getBorder());
        getFrame().add(label);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
