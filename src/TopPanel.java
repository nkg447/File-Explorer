import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class TopPanel {

	JPanel getTopPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 20, 900, 55);
		topPanel.setBackground(new Color(255, 255, 255));

		JButton back = new JButton("Back");
		back.setBounds(10, 10, 70, 30);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OuterFrame.path = (new File(OuterFrame.path).getParent());
				OuterFrame.rePaintFrame();
			}
		});

		JTextField add = new JTextField(OuterFrame.path);
		add.setBounds(210, 10, 450, 30);
		JTextField search = new JTextField("Search " + (new File(OuterFrame.path)).getName());
		if (OuterFrame.path.equals("ThisPc"))
			search.setText("Search");
		else
			search.setText("Search " + (new File(OuterFrame.path)).getName());

		search.setBounds(700, 10, 190, 30);

		topPanel.add(add);
		topPanel.add(back);
		topPanel.add(search);

		return topPanel;
	}

}
