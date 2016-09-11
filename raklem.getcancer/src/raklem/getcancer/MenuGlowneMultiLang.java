package raklem.getcancer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGlowneMultiLang extends JFrame
{
	private static final long serialVersionUID = 8272422647640478134L;

	private MP3 muz = new MP3(getClass().getResource("res/music.mp3"));
	
	public MenuGlowneMultiLang(String lang) 
	{
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		URL newGame = null, options = null, exit = null;
		if (lang == "EN")
		{
			newGame = getClass().getResource("res/newEn.png");
			options = getClass().getResource("res/optionsEn.png");
			exit = getClass().getResource("res/exitEn.png");
 		}
		else if (lang == "PL")
		{
			newGame = getClass().getResource("res/newPl.png");
			options = getClass().getResource("res/optionsPl.png");
			exit = getClass().getResource("res/exitPl.png");
 		}
		
		JButton newGameButton = new JButton(new ImageIcon(newGame));
		newGameButton.setContentAreaFilled(false);
		newGameButton.setMargin(getInsets());
		newGameButton.setOpaque(false);
		/*
		JButton optionsButton = new JButton(new ImageIcon(options));
		optionsButton.setContentAreaFilled(false);
		optionsButton.setMargin(getInsets());
		optionsButton.setOpaque(false);
		*/
		JButton exitButton = new JButton(new ImageIcon(exit));
		exitButton.setContentAreaFilled(false);
		exitButton.setMargin(getInsets());
		exitButton.setOpaque(false);
		
		
		this.add(newGameButton);
		//this.add(optionsButton);
		this.add(exitButton);
		
		muz.start();
		
		ActionListener exitListener = new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	muz.close();
		        dispose();
		    }
		};
		ActionListener newGameListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GameFrame frame = new GameFrame();
				frame.setVisible(true);
	    		dispose();
				
			}
		};
		/*
		ActionListener optionsListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Opcje frame1 = new Opcje();
				frame1.setVisible(true);
	    		dispose();
				
			}
		};
		*/
		newGameButton.addActionListener(newGameListener);
		exitButton.addActionListener(exitListener);
		//optionsButton.addActionListener(optionsListener);
		
		WindowListener a = new WindowAdapter()
		{
			@Override
			public void windowClosed(WindowEvent arg0)
			{
				System.out.println("wy³¹czono");
				muz.close();
			}
		};
		this.addWindowListener(a);
		
	}
	
}
