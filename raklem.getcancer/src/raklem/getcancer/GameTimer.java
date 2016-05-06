package raklem.getcancer;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

public class GameTimer implements Runnable
{
	private int time = 0;
	
	public GameTimer()
	{
		super();
	}
	
	public double getTime()
	{
		return time;
	}
	
	public void run()
	{
		time = time + 1;
		//System.out.println("czas: " + time);
	}
}