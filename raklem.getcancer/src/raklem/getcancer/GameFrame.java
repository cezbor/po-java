package raklem.getcancer;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	private static final long serialVersionUID = -3568173389323253243L;

	private MP3 muz = new MP3(getClass().getResource("res/music.mp3"));
	
	public GameFrame() throws HeadlessException
	{
		setSize(900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		//scheduler.scheduleAtFixedRate(timer, 0, 100, TimeUnit.MILLISECONDS);
		
		GamePanel2 panel = new GamePanel2(scheduler);
		panel.addKeyListener(panel);
		panel.setFocusable(true);
		this.add(panel);
		
		muz.start();
		
		WindowListener a = new WindowAdapter()
		{
			@Override
			public void windowClosed(WindowEvent arg0)
			{
				// TODO Auto-generated method stub
				System.out.println("wy³¹czono");
				scheduler.shutdownNow();
			}
		};
		this.addWindowListener(a);
		//System.out.println(timer.getTime());
		
	}
}
