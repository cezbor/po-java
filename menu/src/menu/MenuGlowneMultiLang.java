package menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuGlowneMultiLang extends JFrame
{
	private static final long serialVersionUID = 8272422647640478134L;

	public MenuGlowneMultiLang(String lang) 
	{
		setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		setBackground(Color.BLUE); //Czemu nie dzia³a????
		
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
		
		JButton optionsButton = new JButton(new ImageIcon(options));
		optionsButton.setContentAreaFilled(false);
		optionsButton.setMargin(getInsets());
		optionsButton.setOpaque(false);
		
		JButton exitButton = new JButton(new ImageIcon(exit));
		exitButton.setContentAreaFilled(false);
		exitButton.setMargin(getInsets());
		exitButton.setOpaque(false);
		
		this.add(newGameButton);
		this.add(optionsButton);
		this.add(exitButton);
		
		
		ActionListener exitListener2 = new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		        dispose();
		    }
		};
		
		exitButton.addActionListener(exitListener2);
	}
	
	//Wersja bez obrazków - z samymi napisami
	/*
	public MenuGlowneMultiLang(String lang) 
	{
		setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		String newGame = "N/A", options = "N/A", exit = "N/A";
		if (lang == "EN")
		{
			newGame = "New Game";
			options = "Options";
			exit = "Exit";
 		}
		else if (lang == "PL")
		{
			newGame = "Nowa Gra";
			options = "Opcje";
			exit = "Wyjscie";
		}
		
		JButton closeFrameButton = new JButton(newGame);
		JButton closeFrameButton1 = new JButton(options);
		JButton closeFrameButton2 = new JButton(exit);
		this.add(closeFrameButton);
		this.add(closeFrameButton1);
		this.add(closeFrameButton2);
		
		ActionListener exitListener2 = new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		        dispose();
		    }
		};
		
		closeFrameButton2.addActionListener(exitListener2);
	}
	*/
}
