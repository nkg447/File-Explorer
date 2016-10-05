import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class SearchField 
{
	JTextField searchField=new JTextField();
	JButton clickSearch=new JButton();
	JFrame frame=new JFrame();
	public SearchField(JFrame f) {
		// TODO Auto-generated constructor stub
		frame=f;
		addSearchField();
	}
	void addSearchField()
	{
		searchField.setBounds(new Rectangle(700,40,300,30));
		clickSearch.setBounds(new Rectangle(1000, 40, 30, 30));
		clickSearch.setIcon(new javax.swing.ImageIcon("im.jpg")); 
		frame.add(clickSearch);
		frame.add(searchField);
	}
	
}
