package Parking;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args)
    {
        TicketGUI ticket = new TicketGUI(new JFrame(),new JLabel(),new JLabel(),new JButton(),BorderFactory.createLineBorder(Color.BLACK, 1));
    }
}
