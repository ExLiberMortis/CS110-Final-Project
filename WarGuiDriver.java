import javax.swing.*;

public class WarGuiDriver
{
	public static void main(String[] args) 
    {
		// creates new game GUI
		JFrame frame = new WarGui();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

