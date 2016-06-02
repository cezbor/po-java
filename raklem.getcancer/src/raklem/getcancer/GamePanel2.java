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

public class GamePanel2 extends JPanel implements KeyListener
{
	private static final long serialVersionUID = 6288272500065765350L;
	private int x = 100;
	private int y = 400;
	private double vx = 0;
	private double vy = 20;
	private final static double g = 10;
	public static enum Kierunek {GORA, DOL, LEWO, PRAWO; boolean flaga;}
	private final static int fps = 100;
	private double czas = 0;
	
	Obiekt platforma1 = new Obiekt(300, 450, 200, 20);
	Obiekt platforma2 = new Obiekt(550, 320, 150, 50);
	Obiekt platforma3 = new Obiekt(100, 220, 150, 20);
	Obiekt postac = new Obiekt(x, y, "res/logo.png");
	
	public GamePanel2( ScheduledExecutorService scheduler)
	{
		super();
		scheduler.scheduleAtFixedRate(new Runnable()
		{
			public void run()
			{
				czas = czas + 1./fps;
				//System.out.println(czas);
				spadek(czas);
				ruchPostaci();
				kolizjaPostaci();
				kolizjaPostaci(platforma1);
				kolizjaPostaci(platforma2);
				kolizjaPostaci(platforma3);
				
			}
		}, 0, 1000/fps, TimeUnit.MILLISECONDS);
		
		//System.out.println(postac.getHeight());
		//System.out.println( "szer: " + getWidth() +" wys: " +  getHeight());
	}
	
	@Override
    public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		//Siatka
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 100; i<1000; i += 100)
        {
        	g.drawLine(i, 0, i, 1000);
        	g.drawLine(0, i, 1000, i);
        }
        
        g.setColor(Color.black);
        g.drawString("czas: " + czas + " s", 500, 10);
        
        postac.paintComponent(g);
        platforma1.paintComponent(g);
        platforma2.paintComponent(g);
        platforma3.paintComponent(g);
        
        g.drawString("Postac: " + postac.info(), 500, 25);
        g.drawString("Platforma 1: " + platforma1.info(), 500, 40);
        
        
        
        //g.drawRect(0, 0, 800, 600);  //RAMKA
       // g.fillRect(0, 300, getWidth(), getHeight());
       // System.out.println( "szer: " + getWidth() +" wys: " +  getHeight());
	}

	void ruchPostaci()
	{
		if (Kierunek.PRAWO.flaga == true)
			postac.setX(postac.getX() + 10);
		if (Kierunek.LEWO.flaga == true)
			postac.setX(postac.getX() - 10);
		if (Kierunek.DOL.flaga == true)
			postac.setY(postac.getY() + 10);
		if (Kierunek.GORA.flaga == true)
			postac.setY(postac.getY() - 10);
		
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
	public void keyTyped(KeyEvent arg0) //Nie u¿ywane
	{
	}
	
	public void kolizjaPostaci()
	{
		int granicaDol = 600;
		int granicaPrawo = 800;
		int granicaGora = 0;
		int granicaLewo = 0;
		
		//Dó³
		if (postac.getY()  >= granicaDol - postac.getHeight())
		{
			postac.setY(granicaDol - postac.getHeight());
			vy = 0;
			czas = 0;
		}
		//Prawo
		if (postac.getX()  >= granicaPrawo - postac.getWidth())
		{
			postac.setX(granicaPrawo - postac.getWidth());
		}
		//Góra
		if (postac.getY()  <= granicaGora)
		{
			postac.setY(granicaGora);
			//vy = 0;
			//czas = 0;
		}
		//Lewo
		if (postac.getX()  <= granicaLewo)
		{
			postac.setX(granicaLewo);
		}
	}
	public void kolizjaPostaci(Obiekt ob)
	{
		int krawedzGorna = ob.getY();
		int krawedzDolna = ob.getY() + ob.getHeight();
		int krawedzLewa = ob.getX();
		int krawedzPrawa = ob.getX() + ob.getWidth();
		
		int xx = postac.getX();
		int yy = postac.getY();
		
		
		//Czy jest kolizja?
		if (!(yy + postac.getHeight() <= krawedzGorna ||
				yy >= krawedzDolna ||
				xx <= krawedzLewa - postac.getWidth() ||
				xx >= krawedzPrawa))
		{
			//System.out.println("kolizja");
			//Góra
			if (yy + postac.getHeight() > krawedzGorna)
			{
				postac.setY(krawedzGorna - postac.getHeight());
				vy = 0;
				czas = 0;
				//System.out.println("gorna");//TODO dokonczyc
			}
			/*
			//Dó³
			if (yy <= krawedzDolna)
			{
				postac.setY(krawedzDolna);
				vy = 0;
				czas = 0;
				System.out.println("dolna");
			}
			//Lewo
			if (xx  >= krawedzLewa - postac.getWidth())
			{
				postac.setX(krawedzLewa - postac.getWidth());
				System.out.println("lewa");
			}
			//Prawo
			if (xx  <= krawedzPrawa)
			{
				postac.setX(krawedzPrawa);
				System.out.println("prawa");
			}
			*/
		}
		
		
	}
	
	public void spadek(double t)
	{
		vy = vy - g * t;
		postac.setY( (int) ( postac.getY() + ( - vy * t + g * t * t / 2) ));
	}
}
