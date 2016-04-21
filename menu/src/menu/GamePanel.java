package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel
{
	private int x = 100;
	private int y = 100;
	String infoNastepny = "N/A";
	public GamePanel()
	{
		JLabel label = new JLabel("Strza³ki lewo prawo ");
		add(label);
		JButton button = new JButton("przesuñ");
		ActionListener buttonActionListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				x += 20;
				y += 20;
				info();
				validate();
				repaint();
			}
		};
		
		button.addActionListener(buttonActionListener);
		add(button);
		
		KeyListener keyListener = new KeyAdapter()
		{
			
			@Override
			public void keyPressed(KeyEvent e)
			{
				int kod = e.getKeyCode();
				System.out.println(kod);
				if (kod == 37)
					x = x - 10;
				else if (kod == 39)
					x = x + 10;
				else if (kod == 38)
					y = y - 10;
				else if (kod == 40)
					y = y + 10;
				
				info();
				repaint();
			}
		};
		
		button.addKeyListener(keyListener);
	}
	
	@Override
    public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(x, y, 100, 100);
        g.drawString(infoNastepny, 500, 10);
        
        /*
       	int margin = 10;
        Dimension dim = getSize();
        g.setColor(Color.red);
        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
        */
	}
	
	void info()
	{
		infoNastepny = "x = " + x + "; y = " + y;
	}
}
