package raklem.getcancer;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Postac extends Obiekt
{
	private static final long serialVersionUID = 2298056819025504218L;
	private ImageIcon img;
	private ImageIcon imgLewo = new ImageIcon(getClass().getResource("res/mariolew.png"));
	private ImageIcon imgPrawo = new ImageIcon(getClass().getResource("res/mario.png"));
	private ImageIcon imgSkokLewo = new ImageIcon(getClass().getResource("res/mariojump_lewo.png"));
	private ImageIcon imgSkokPrawo = new ImageIcon(getClass().getResource("res/mariojump_prawo.png"));
	
	public Postac(int x, int y)
	{
		super(x, y);
		img = imgLewo;
		this.x = x;
		this.y = y;
		
		this.width = img.getIconWidth();
		this.height = img.getIconHeight();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
        g.drawImage(img.getImage(), x, y, this);
	}

	public void lewo()
	{
		img = imgLewo;
	}
	
	public void prawo()
	{
		img = imgPrawo;
	}
	
	public void lewoPrawo()
	{
		if (img == imgSkokLewo)
			img = imgLewo;
		else if (img == imgSkokPrawo)
			img = imgPrawo;
	}
	
	public void skok()
	{
		if (img == imgLewo)
			img = imgSkokLewo;
		else if (img == imgPrawo)
			img = imgSkokPrawo;
	}
	
	public String info()
	{
		return "x = " + x + "; y = " + y;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
	
	
}
