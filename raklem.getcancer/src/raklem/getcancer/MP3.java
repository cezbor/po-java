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
			pl.close();
		} catch (JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void close()
	{
		pl.close();
	}
	
}
