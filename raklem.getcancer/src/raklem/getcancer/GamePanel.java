package raklem.getcancer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener
{
	private static final long serialVersionUID = 6288272500065765350L;
	private int x = 100;
	private int y = 100;
	public static enum Kierunek {GORA, DOL, LEWO, PRAWO; boolean flaga;}
	private int fps = 240;
	//private GameTimer timer;
	private int czas = 0;
	private String infoNastepny;
	private ImageIcon logo;
	public GamePanel( ScheduledExecutorService scheduler)
	{
		super();
		//this.timer = timer;
		scheduler.scheduleAtFixedRate(new Runnable()
		{
			public void run()
			{
				ruch();
				czas++;
			}
		}, 0, 1000/fps, TimeUnit.MILLISECONDS);
		
		logo = new ImageIcon(getClass().getResource("res/logo.png"));
		
	}
	
	@Override
    public void paintComponent(Graphics g) 
	{
		
		super.paintComponent(g);
        g.setColor(Color.black);
        //g.fillRect(x, y, 100, 100);
        infoNastepny = "x = " + x + "; y = " + y;
        g.drawString(infoNastepny, 500, 10);
        g.drawString("czas: " + (float)czas/fps + " s", 500, 25);
        g.drawImage(logo.getImage(), x, y, this);
        
        
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
