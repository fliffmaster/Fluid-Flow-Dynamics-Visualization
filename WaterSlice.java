import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class WaterSlice extends JPanel
{
	Particle particle[] = new Particle[100];
	public WaterSlice() 
	{	
		setBorder(new LineBorder(new Color(0, 0, 0)));
		for(int i = 0; i < particle.length; i++)
		{
			particle[i] = new Particle();
		}
	}
	
	public void makeParticle()
	{
		for(int i = 0; i < particle.length; i++)
		{
			particle[i] = new Particle();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		
		for(int i = 0; i < particle.length; i++)
		{
			particle[i] = new Particle();
			g2.fill(particle[i].getEllipse());
		}		
	}
	
/*	public void deleteParticle()
	{
		particle[i].deleteParticle();
	}*/
}
