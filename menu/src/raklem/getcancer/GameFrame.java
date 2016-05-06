package raklem.getcancer;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame
{
	public GameFrame() throws HeadlessException
	{
		setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		GameTimer timer = new GameTimer();
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		scheduler.scheduleAtFixedRate(timer, 0, 100, TimeUnit.MILLISECONDS);
		
		GamePanel panel = new GamePanel(timer, scheduler);
		panel.addKeyListener(panel);
		panel.setFocusable(true);
		this.add(panel);
		
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
