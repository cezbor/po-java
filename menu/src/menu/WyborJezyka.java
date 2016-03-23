package menu;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WyborJezyka extends JFrame 
{
	private static final long serialVersionUID = 6270082980761957108L;

	public WyborJezyka() throws HeadlessException 
	{
		setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		this.add(new JLabel ("Prosze wybrac jezyk"));
		JButton closeFrameButton = new JButton("Polski");
		this.add(closeFrameButton);
		JButton closeFrameButton1 = new JButton("Angielski");
		this.add(closeFrameButton1);
		
		
		
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
		closeFrameButton1.addActionListener(AngListener);
		
		
		
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
		
		closeFrameButton.addActionListener(PlListener);
		
	}
	
	
	public static void main(String[] args) 
	{
		WyborJezyka frame = new WyborJezyka();
		frame.setVisible(true);

	}

}
