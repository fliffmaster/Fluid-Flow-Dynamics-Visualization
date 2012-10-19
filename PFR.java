import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PFR extends JPanel
{
	WaterSlice panel_1 = new WaterSlice();
	int x = 0;
	
	public PFR()
	{
		TimerListener listen = new TimerListener();
		Timer timer = new Timer(200, listen);
		timer.setRepeats(true);
		timer.start();
		

		panel_1.setBounds(x, 0, 10, 209);
		add(panel_1);
		panel_1.setLayout(null);
	}
	
	class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg) 
		{
			x++;
			panel_1.setBounds(x, 0, 10, 209);
			repaint();
		}
		
	}
}
