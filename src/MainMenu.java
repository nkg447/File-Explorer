import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu implements ActionListener {

	JMenuBar menuBar;

	JMenuBar getMenu() {
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 900, 20);
		menuBar.setBackground(new Color(233, 224, 224));
		JMenu file = new JMenu("File");
		JMenuItem cmd = new JMenuItem("Open in cmd");
		JMenuItem newWindow = new JMenuItem("Open in New Window");
		JMenuItem close = new JMenuItem("close");
		close.addActionListener(this);
		file.add(cmd);
		file.add(newWindow);
		file.add(close);
		JMenu view = new JMenu("View");
		menuBar.add(file);
		menuBar.add(view);

		return menuBar;

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "close")
			System.exit(0);

	}

}
