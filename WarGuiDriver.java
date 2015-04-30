//~ Sam Rowell
//~ CS110 - Project
//~ This program is used as a driver for a GUI based "war" card game

import javax.swing.*;

public class WarGuiDriver
{
	public static void main(String[] args) 
    {
		// creates new game GUI
		JFrame frame = new WarGui();
		
		// set frame properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

