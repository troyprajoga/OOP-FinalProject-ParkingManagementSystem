package Parking;

import javax.swing.*;
import javax.swing.border.Border;
import java.io.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class ParkingLot implements ActionListener,InterfaceParkingLot {
    //Initializes ParkingLot elements
    ParkingGUI one = new ParkingGUI(new JFrame(),new JLabel(),new JLabel(),new JButton(),BorderFactory.createLineBorder(Color.BLACK, 1));
    ParkingGUI two = new ParkingGUI(new JFrame(),new JLabel(),new JLabel(),new JButton(),BorderFactory.createLineBorder(Color.BLACK, 1));
    ParkingGUI three = new ParkingGUI(new JFrame(),new JLabel(),new JLabel(),new JButton(),BorderFactory.createLineBorder(Color.BLACK, 1));
    ParkingSlotsGUI parkingSlots = new ParkingSlotsGUI(new JFrame(),new JLabel(),new JLabel(),new JButton(),BorderFactory.createLineBorder(Color.BLACK, 1));
    JButton upButtonOne = new JButton();
    JButton upButtonTwo = new JButton();
    JButton upButtonThree = new JButton();
    JButton downButtonOne = new JButton();
    JButton downButtonTwo = new JButton();
    JButton downButtonThree = new JButton();
    JButton[] parkButtonOne = new JButton[8];
    JButton[] parkButtonTwo = new JButton[8];
    JButton[] parkButtonThree = new JButton[8];
    JLabel[] occupiedLabel = new JLabel[8];
    private int x;
    //random class
    Random random = new Random();
    //hour and minute to calculate the time
    private int hour = 12;
    private int minute = 0;
    //paymentDue to calculate payment
    private int paymentDue = 0;
    //to count today's available slots
    public int totalAvailableSlots = 0;
    LeaveGUI leavegui = new LeaveGUI(new JFrame(),new JLabel(),new JLabel(),new JButton(),BorderFactory.createLineBorder(Color.BLACK, 1));
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    private void makeParkButton(JButton button)
    {
        //This method makes the Parking Slot Button
        button.setFocusable(false);
        button.setFont(new Font("Arial", Font.BOLD, 45));
        button.addActionListener(this);
        button.setText("[P]");
    }
    private void makeOccupiedLabel(JLabel label)
    {
        //This makes the occupied slot
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setText("Occupied");
        label.setBackground(Color.RED);
        label.setBorder(border);
        label.setOpaque(true);
    }
    private void makeButton(JButton button)
    {
        //This method makes the common attributes of the button
        button.setFont(new Font("Times New Roman",Font.BOLD,30));
        button.addActionListener(this);
        button.setFocusable(false);
    }
    private void makeUpButton(JButton button)
    {
        //this method makes the "UP" button to change levels
        button.setBounds(600,100,190,332);
        button.setText("UP");
        makeButton(button);
    }
    private void makeDownButton(JButton button)
    {
        //this method makes the "DOWN" button to change levels
        button.setBounds(600,432,190,332);
        button.setText("DOWN");
        makeButton(button);
    }
    private void makeParkingOccupancy(JFrame frame,JButton[] button)
    {
        // this method makes the parking lot and randomly changes
        // between an available parking slot and an occupied one
        for(int i = 0; i < 4; i++)
        {
            //This makes a 1 in 6 chance for a parking slot to be available
            //This makes the top 4 parking slots
            x = random.nextInt(6);
            if(x == 1)
            {
                button[i] = new JButton();
                button[i].setBounds(i * 150, 100, 150, 332);
                makeParkButton(button[i]);
                frame.add(button[i]);
                totalAvailableSlots++;
            }
            else {
                occupiedLabel[i] = new JLabel();
                occupiedLabel[i].setBounds(i*150,100,150,332);
                makeOccupiedLabel(occupiedLabel[i]);
                frame.add(occupiedLabel[i]);
            }
        }
        for(int i = 4; i < 8; i++) {
            //This makes a 1 in 6 chance for a parking slot to be available
            //This makes the bottom 4 parking slots
            x = random.nextInt(6);
            if (x == 1) {
                button[i] = new JButton();
                button[i].setBounds((i - 4) * 150, 432, 150, 332);
                makeParkButton(button[i]);
                frame.add(button[i]);
                totalAvailableSlots++;
            } else {
                occupiedLabel[i] = new JLabel();
                occupiedLabel[i].setBounds((i - 4) * 150, 432, 150, 332);
                makeOccupiedLabel(occupiedLabel[i]);
                frame.add(occupiedLabel[i]);
            }
        }
    }
    public void calculatePayment()
    {
        if((minute == 15) || (minute == 30 || (minute == 45) || (minute == 0)))
        {
            //This adds 15000 to the payment due for every 3 actions performed.
            paymentDue += 15;
        }
    }
    private void setTime()
    {
        //This changes the time that is displayed and simultaneously keeps a count
        //of how many minutes has passed.
        minute += 5;
        if(minute == 60)
        {
            //This makes the minute not fo to 61 but instead, it resets the minute
            //and adds 1 to the hour
            hour++;
            minute = 0;
            one.getLabelTwo().setText(hour + ":00");
            two.getLabelTwo().setText(hour + ":00");
            three.getLabelTwo().setText(hour + ":00");
        }
        else if(minute == 5)
        {
            //So that the time will not display 12:5 but 12:05
            one.getLabelTwo().setText(hour + ":05");
            two.getLabelTwo().setText(hour + ":05");
            three.getLabelTwo().setText(hour + ":05");
        }
        else
        {
            //Displays time
            one.getLabelTwo().setText(hour + ":" + minute);
            two.getLabelTwo().setText(hour + ":" + minute);
            three.getLabelTwo().setText(hour + ":" + minute);
        }
        if(hour == 24)
        {
            //IF the hour goes to 24, the parking lot will automatically open the leaveGUI
            leavegui.getFrame().setVisible(true);
        }
        calculatePayment();
    }
    private void carParked(JFrame frame,JButton button)
    {
        //will close the current parkingGUI and open the leaveGUI
        //also showing the ticket payment price
        frame.setVisible(false);
        leavegui.getLabelTwo().setText(paymentDue + ".000 RP");
        leavegui.getFrame().setVisible(true);
    }
    private void updateAvailableSlots(int todaySlots)
    {
        try {
            // Update the file with today's available slots
            FileWriter writer = new FileWriter("AvailableParkingSlots.txt");
            writer.write("Available Slots Today: " + todaySlots);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    ParkingLot(){
        //make up and down buttons
        makeUpButton(upButtonOne);
        makeUpButton(upButtonTwo);
        makeUpButton(upButtonThree);

        makeDownButton(downButtonOne);
        makeDownButton(downButtonTwo);
        makeDownButton(downButtonThree);

        //add up and down buttons to parkingGUIs
        one.getFrame().add(upButtonOne);
        one.getFrame().add(downButtonOne);
        two.getFrame().add(upButtonTwo);
        two.getFrame().add(downButtonTwo);
        three.getFrame().add(upButtonThree);
        three.getFrame().add(downButtonThree);

        //set level labels
        one.getLabelOne().setText("Level: 1");
        two.getLabelOne().setText("Level: 2");
        three.getLabelOne().setText("Level: 3");


        //create parking occupancies
        makeParkingOccupancy(one.getFrame(),parkButtonOne);
        makeParkingOccupancy(two.getFrame(),parkButtonTwo);
        makeParkingOccupancy(three.getFrame(),parkButtonThree);

        //the parking lot starts at level 1
        one.getFrame().setVisible(true);

        //Updates txt file and also adds the total slots today to the Parking Slots GUI
        updateAvailableSlots(totalAvailableSlots);
        parkingSlots.getLabelOne().setText("Available Slots Today: " + totalAvailableSlots);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==upButtonOne)
        {
            //This allows the user to go up a level from level 1
            setTime();
            one.getFrame().setVisible(false);
            two.getFrame().setVisible(true);
        }
        if(e.getSource()==upButtonTwo)
        {
            //This allows the user to go up a level from level 2
            setTime();
            two.getFrame().setVisible(false);
            three.getFrame().setVisible(true);
        }
        if(e.getSource()==downButtonTwo)
        {
            //This allows the user to go down a level from level 2
            setTime();
            two.getFrame().setVisible(false);
            one.getFrame().setVisible(true);
        }
        if(e.getSource()==downButtonThree)
        {
            //This allows the user to go down a level from level 3
            setTime();
            three.getFrame().setVisible(false);
            two.getFrame().setVisible(true);
        }
        for(int i = 0; i < 8; i++)
        {
            //checks which parking button is pressed
            //and displays on the leaveGUI what level, row, and column
            //that the car is parked at
            if(e.getSource() == parkButtonOne[i])
            {
                carParked(one.getFrame(),parkButtonOne[i]);
                if(i < 4)
                {
                    leavegui.rowValue.setText("1");
                    leavegui.colValue.setText(Integer.toString(i+1));
                }
                else {
                    leavegui.rowValue.setText("2");
                    leavegui.colValue.setText(Integer.toString(i-3));
                }
                leavegui.levelValue.setText("1");
            }
        }
        for(int i = 0; i < 8; i++)
        {
            //checks which parking button is pressed
            //and displays on the leaveGUI what level, row, and column
            //that the car is parked at
            if(e.getSource()== parkButtonTwo[i])
            {
                carParked(two.getFrame(),parkButtonTwo[i]);
                if(i < 4)
                {
                    leavegui.rowValue.setText("1");
                    leavegui.colValue.setText(Integer.toString(i+1));
                }
                else {
                    leavegui.rowValue.setText("2");
                    leavegui.colValue.setText(Integer.toString(i-3));
                }
                leavegui.levelValue.setText("2");
            }
        }
        for(int i = 0; i < 8; i++)
        {
            //checks which parking button is pressed
            //and displays on the leaveGUI what level, row, and column
            //that the car is parked at
            if(e.getSource()== parkButtonThree[i])
            {
                carParked(three.getFrame(),parkButtonThree[i]);
                if(i <= 4)
                {
                    leavegui.rowValue.setText("1");
                    leavegui.colValue.setText(Integer.toString(i+1));
                }
                else {
                    leavegui.rowValue.setText("2");
                    leavegui.colValue.setText(Integer.toString(i-3));
                }
                leavegui.levelValue.setText("3");
            }
        }
    }
}
