package raklem.getcancer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Opcje extends JFrame 
{
	public Opcje() throws HeadlessException
	{
		super();
		setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		
		JButton Rozmiar1 = new JButton("640X480");
		this.add(Rozmiar1);		
		this.setVisible(true);
		
		JButton Rozmiar2 = new JButton("1024X768");
		this.add(Rozmiar2);		
		this.setVisible(true);
		
		JButton Rozmiar3 = new JButton("1920X1080");
		this.add(Rozmiar3);	
		this.setVisible(true);
		
		JButton Wroc = new JButton("Powrót");
		this.add(Wroc);	
		this.setVisible(true);
		
		JSlider pasek = new JSlider();
		this.add(pasek);
	}
}
