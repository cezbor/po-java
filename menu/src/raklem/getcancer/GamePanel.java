package raklem.getcancer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener
{
	private int x = 100;
	private int y = 100;
	public static enum Kierunek {GORA, DOL, LEWO, PRAWO; boolean flaga;}
	private int fps = 240;
	private GameTimer timer;
	private String infoNastepny;
	public GamePanel(GameTimer timer, ScheduledExecutorService scheduler)
	{
		super();
		this.timer = timer;
		scheduler.scheduleAtFixedRate(new Runnable()
		{
			public void run()
			{
				ruch();
			}
		}, 0, 1000/fps, TimeUnit.MILLISECONDS);
	}
	
	@Override
    public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(x, y, 100, 100);
        infoNastepny = "x = " + x + "; y = " + y;
        g.drawString(infoNastepny, 500, 10);
        g.drawString("czas: " + timer.getTime()/10 + " s", 500, 25);
        
	}

	void ruch()
	{
		if (Kierunek.PRAWO.flaga == true)
			x++;
		if (Kierunek.LEWO.flaga == true)
			x--;
		if (Kierunek.DOL.flaga == true)
			y++;
		if (Kierunek.GORA.flaga == true)
			y--;
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int kod = e.getKeyCode();
		System.out.println("przycisk: " + kod);
		if (kod == 39)
			Kierunek.PRAWO.flaga = true;
		if (kod == 37)
			Kierunek.LEWO.flaga = true;
		if (kod == 40)
			Kierunek.DOL.flaga = true;
		if (kod == 38)
			Kierunek.GORA.flaga = true;
		//repaint();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int kod = e.getKeyCode();
		if (kod == 39)
			Kierunek.PRAWO.flaga = false;
		if (kod == 37)
			Kierunek.LEWO.flaga = false;
		if (kod == 40)
			Kierunek.DOL.flaga = false;
		if (kod == 38)
			Kierunek.GORA.flaga = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
	}
}
