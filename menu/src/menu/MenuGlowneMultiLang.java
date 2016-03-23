package menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuGlowneMultiLang extends JFrame
{
	private static final long serialVersionUID = 8272422647640478134L;

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
		this.add(closeFrameButton);
		JButton closeFrameButton1 = new JButton(options);
		this.add(closeFrameButton1);
		JButton closeFrameButton2 = new JButton(exit);
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
}
