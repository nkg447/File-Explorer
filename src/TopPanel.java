import javax.swing.*;

public class TopPanel {

	
	JPanel getTopPanel()
	{
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 20, 900, 40);
		
		JButton back=new JButton("Back");
		back.setBounds(10, 10, 70, 30);
		
		JTextField add=new JTextField(OuterFrame.path);
		add.setBounds(210, 10, 450, 30);
		
		JTextField search=new JTextField();
		search.setBounds(700, 10, 200, 30);
		
		topPanel.add(add);
		topPanel.add(back);
		topPanel.add(search);
		
		return topPanel;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
