
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel implements ActionListener {

	JPanel getMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(205, 80, 700, 550);
		mainPanel.setBackground(new Color(255, 255, 255));
		/*
		 * JScrollPane scroll=new JScrollPane(mainPanel);
		 * scroll.setVerticalScrollBarPolicy(JScrollPane.
		 * VERTICAL_SCROLLBAR_AS_NEEDED);
		 * scroll.setHorizontalScrollBarPolicy(JScrollPane.
		 * HORIZONTAL_SCROLLBAR_NEVER); scroll.setBounds(870, 0, 30, 550);
		 * JPanel contentPane = new JPanel(null);
		 * contentPane.setPreferredSize(new Dimension(500, 400));
		 * contentPane.add(scroll);
		 * OuterFrame.outer.setContentPane(contentPane);
		 */
		if (OuterFrame.path.equals("ThisPc")) {
			JButton b;
			int ct = 0;
			File[] fileList = File.listRoots();
			for (File f : fileList) {
				b = new JButton(f.getPath());
				b.setBounds(130 * (ct % 5) + 10, 30 * (ct / 5) + 10, 120, 20);
				b.addActionListener(this);
				mainPanel.add(b);
				ct++;
			}

		} else {
			JButton b;
			int ct = 0;
			File[] fileList = (new File(OuterFrame.path)).listFiles();
			for (File f : fileList) {
				b = new JButton(f.getName());
				b.setBounds(130 * (ct % 5), 30 * (ct / 5), 120, 20);
				b.addActionListener(this);
				mainPanel.add(b);
				ct++;
			}
		}

		return mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		File file = new File(OuterFrame.path + e.getActionCommand() + "/");
		if (file.isDirectory() || OuterFrame.path.equals("ThisPc")) {

			if (OuterFrame.path.equals("ThisPc"))
				OuterFrame.path = e.getActionCommand();
			else
				OuterFrame.path = OuterFrame.path + e.getActionCommand() + "/";
			OuterFrame.rePaintFrame();
		} else {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(file.getPath());
			}
		}
	}

}
