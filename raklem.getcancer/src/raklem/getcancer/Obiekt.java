package raklem.getcancer;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Obiekt extends JPanel
{
	private static final long serialVersionUID = 7646954161226994749L;
	
	private int x, y;
	private ImageIcon img = new ImageIcon();
	private int width, height;
	
	public Obiekt(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	public Obiekt(int x, int y, String imageString)
	{
		this(x, y);

		img = new ImageIcon(getClass().getResource(imageString));
		this.width = img.getIconWidth();
		this.height = img.getIconHeight();
	}
	public Obiekt(int x, int y, int width, int height)
	{
		this(x, y);
		this.width = width;
		this.height = height;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
        if (img.getImageLoadStatus() == 0)
        	g.fillRect(x, y, width, height);
        else
        	g.drawImage(img.getImage(), x, y, this);
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
