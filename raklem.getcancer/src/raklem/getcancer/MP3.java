package raklem.getcancer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MP3 extends Thread
{
	private Player pl;
	
	private URL url;
	
	public MP3 (URL url)
	{
		super();
		this.url = url;
	}
	
	public void run ()
	{
		InputStream stream;
		try {
			stream = url.openStream();
		
		
		try {
			pl = new Player(stream);
			pl.play();
		} catch (JavaLayerException e1) {
			e1.printStackTrace();
		}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void close()
	{
		boolean isClosed = false;
		boolean printed = false;
		do
		{
			try
			{
				pl.close();
				isClosed = true;
			}
			catch (NullPointerException e)
			{
				if(!printed)
				{
					System.out.println("Wyj¹tek: Za szybko wy³¹czono muzykê (" + getClass().getName() + ")");
					printed = true;
				}
				try
				{
					sleep(20);
				}
				catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
			}
		} 
		while(!isClosed);
		
	}
	
}
