package menu;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class GameFrame extends JFrame
{

	public GameFrame() throws HeadlessException
	{
		setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		GamePanel panel = new GamePanel();
		this.add(panel);
		
		
	}

}
