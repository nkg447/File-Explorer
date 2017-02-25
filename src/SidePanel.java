
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SidePanel implements ActionListener {
	static JPanel sidePanel;

	JPanel getSidePanel() {
		(sidePanel = new JPanel()).setLayout(null);
		sidePanel.setBounds(0, 80, 200, 580);
		sidePanel.setBackground(new Color(255, 255, 255));

		JButton quick = new JButton("Quick Access");
		quick.setBounds(-20, 10, 150, 30);

		JButton down = new JButton("Downloads");
		down.setBounds(9, 40, 150, 30);

		JButton doc = new JButton("Documents");
		doc.setBounds(10, 70, 150, 30);

		JButton pics = new JButton("Pictures");
		pics.setBounds(3, 100, 150, 30);

		JButton pc = new JButton("This Pc");
		pc.setBounds(-38, 150, 150, 30);

		toJLabel(pc);
		toJLabel(pics);
		toJLabel(doc);
		toJLabel(down);
		toJLabel(quick);

		sidePanel.add(quick);
		sidePanel.add(down);
		sidePanel.add(doc);
		sidePanel.add(pics);
		sidePanel.add(pc);
		return sidePanel;
	}

	private void toJLabel(JButton b) {
		// TODO Auto-generated method stub
		b.setFocusPainted(false);
		b.setMargin(new Insets(0, 0, 0, 0));
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setOpaque(false);
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Downloads"))
			OuterFrame.path = "C:/Users/" + System.getProperty("user.name") + "/Downloads/";

		else if (e.getActionCommand().equals("Documents"))
			OuterFrame.path = "C:/Users/" + System.getProperty("user.name") + "/Documents/";
		else if (e.getActionCommand().equals("Pictures"))
			OuterFrame.path = "C:/Users/" + System.getProperty("user.name") + "/Pictures/";
		else if (e.getActionCommand().equals("This Pc"))
			OuterFrame.path = "ThisPc";

		OuterFrame.rePaintFrame();
	}

}
