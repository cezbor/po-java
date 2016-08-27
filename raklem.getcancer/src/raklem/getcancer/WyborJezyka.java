package raklem.getcancer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WyborJezyka extends JFrame 
{
	private static final long serialVersionUID = 6270082980761957108L;

	public WyborJezyka() throws HeadlessException 
	{
		setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		
		URL plURL = getClass().getResource("res/pl.png");
		URL enURL = getClass().getResource("res/en.png");
		this.add(new JLabel ("Prosze wybrac jezyk / Choose your language", JLabel.CENTER), BorderLayout.NORTH);
		JPanel panel = new JPanel(new FlowLayout());
		JButton plButton = new JButton(new ImageIcon(plURL));
		plButton.setContentAreaFilled(false);
		plButton.setMargin(getInsets());
		JButton enButton = new JButton(new ImageIcon(enURL));
		enButton.setContentAreaFilled(false);
		enButton.setMargin(getInsets());
		panel.add(plButton);
		panel.add(enButton);		
		add(panel, BorderLayout.CENTER);
		
		ActionListener AngListener = new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	MenuGlowneMultiLang frame = new MenuGlowneMultiLang("EN");
				frame.setVisible(true);
		    	dispose();
		    }
		};
		enButton.addActionListener(AngListener);
		
		ActionListener PlListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				MenuGlowneMultiLang frame = new MenuGlowneMultiLang("PL");
	    		frame.setVisible(true);
	    		dispose();
			}
		};
		
		plButton.addActionListener(PlListener);
		
	}
	
	public static void main(String[] args) 
	{
		WyborJezyka frame = new WyborJezyka();
		frame.setVisible(true);

	}

}
