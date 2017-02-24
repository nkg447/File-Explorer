
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SidePanel {
	static JPanel sidePanel;
	
	JPanel getSidePanel()
	{
		(sidePanel=new JPanel()).setLayout(null);
		sidePanel.setBounds(0, 60, 200, 600);
		
		JLabel quick=new JLabel("Quick Access");
		quick.setBounds(5, 10, 150, 30);
		
		JLabel down=new JLabel("Downloads");
		down.setBounds(20, 40, 150, 30);
		
		JLabel doc=new JLabel("Documents");
		doc.setBounds(20, 70, 150, 30);
		
		JLabel pics=new JLabel("Pictures");
		pics.setBounds(20, 100, 150, 30);
		
		sidePanel.add(quick);
		sidePanel.add(down);
		sidePanel.add(doc);
		sidePanel.add(pics);
		return sidePanel;
	}
	
}
