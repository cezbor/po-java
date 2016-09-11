package raklem.getcancer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel2 extends JPanel implements KeyListener
{
	private static final long serialVersionUID = 6288272500065765350L;
	private int x = 100;
	private int y = 400;
	private double vy = 20;
	private final static double g = 10;
	public static enum Kierunek {GORA, DOL, LEWO, PRAWO; boolean flaga;}
	private final static int fps = 100;
	private double czas = 0;
	GameFrame frame;

	Obiekt platforma1 = new Obiekt(300, 450, "res/platforma150.png");
	Obiekt platforma2 = new Obiekt(550, 320, "res/platforma200.png");
	Obiekt platforma3 = new Obiekt(100, 220, "res/platforma100.png");
	Postac postac = new Postac(x, y);
	Obiekt rak = new Obiekt(120, 177, "res/rak.png");
	
	private Image tlo= (new ImageIcon(getClass().getResource("res/tlo.jpg")).getImage());
	
	public GamePanel2( ScheduledExecutorService scheduler, GameFrame frame)
	{
		super();
		this.frame = frame;
		scheduler.scheduleAtFixedRate(new Runnable()
		{
			public void run()
			{
				czas = czas + 1./100;
				spadek(czas);
				ruchPostaci();
				kolizjaPostaci();
				kolizjaPostaci(platforma1);
				kolizjaPostaci(platforma2);
				kolizjaPostaci(platforma3);
				wygrana(scheduler);
				
			}
		}, 0, 1000/fps, TimeUnit.MILLISECONDS);
		
	}
	
	@Override
    public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawImage(tlo, 0, 0, this);
        g.setColor(Color.black);
        
        postac.paintComponent(g);
        platforma1.paintComponent(g);
        platforma2.paintComponent(g);
        platforma3.paintComponent(g);
        rak.paintComponent(g);
        
       // g.drawString("czas: " + czas + " s", 500, 10);
       // g.drawString("Postac: " + postac.info(), 500, 25);
       // g.drawString("Platforma 1: " + platforma1.info(), 500, 40);
       // g.drawString("Postac2: " + postac2.info(), 500, 55);
        
	}

	public void spadek(double t)
	{
		vy = vy - g * t;
		postac.setY( (int) ( postac.getY() + ( - vy * t + g * t * t / 2) ));
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
		//System.out.println("przycisk: " + kod);
		if (kod == 39)
		{
			postac.prawo();
			Kierunek.PRAWO.flaga = true;
		}
		if (kod == 37)
		{
			postac.lewo();
			Kierunek.LEWO.flaga = true;
		}
		if (kod == 40)
		{
			Kierunek.DOL.flaga = true;
		}
		if (kod == 38)
		{
			postac.skok();
			Kierunek.GORA.flaga = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int kod = e.getKeyCode();
		if (kod == 39)
		{
			postac.prawo();
			Kierunek.PRAWO.flaga = false;
		}
		if (kod == 37)
		{
			postac.lewo();
			Kierunek.LEWO.flaga = false;
		}
		if (kod == 40)
		{
			Kierunek.DOL.flaga = false;
		}
		if (kod == 38)
		{
			postac.lewoPrawo();
			Kierunek.GORA.flaga = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) //Nie u¿ywane
	{
	}
	
	public void kolizjaPostaci()
	{
		int granicaDol = getHeight();  //600
		int granicaPrawo = getWidth();  //800
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
			//Góra
			if (yy + postac.getHeight() > krawedzGorna)
			{
				postac.setY(krawedzGorna - postac.getHeight());
				vy = 0;
				czas = 0;
				//System.out.println("gorna");
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
	public void wygrana(ScheduledExecutorService scheduler)
	{
		int krawedzGorna = rak.getY();
		int krawedzDolna = rak.getY() + rak.getHeight();
		int krawedzLewa = rak.getX();
		int krawedzPrawa = rak.getX() + rak.getWidth();
		
		int xx = postac.getX();
		int yy = postac.getY();
		
		if (!(yy + postac.getHeight() <= krawedzGorna ||
				yy >= krawedzDolna ||
				xx <= krawedzLewa - postac.getWidth() ||
				xx >= krawedzPrawa))
		{
			System.out.println("WYGRALES!");
			scheduler.shutdown();
			JOptionPane.showMessageDialog(this, "Gratulacje, wygra³eœ!");
			System.out.println("Koniec!");
			System.exit(0);
		}
	}
	
	
}
