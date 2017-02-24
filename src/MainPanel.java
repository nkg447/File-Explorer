
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
		mainPanel.setBounds(200, 80, 700, 550);

		if (OuterFrame.path.equals("ThisPc")) {

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

		
		File file=new File(OuterFrame.path + e.getActionCommand()+"/");
		if(file.isDirectory())
		{
			OuterFrame.path = OuterFrame.path + e.getActionCommand()+"/";
			OuterFrame.outer.remove(OuterFrame.mainPanel);
			OuterFrame.outer.remove(OuterFrame.topPanel);
			OuterFrame.outer.add(OuterFrame.topPanel=(new TopPanel()).getTopPanel());
			OuterFrame.outer.add(OuterFrame.mainPanel = new MainPanel().getMainPanel());
			OuterFrame.outer.repaint();
		}
		else
		{
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
