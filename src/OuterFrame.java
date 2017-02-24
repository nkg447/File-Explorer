
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class OuterFrame implements WindowListener {
	static String path;
	static JFrame outer;
	static JPanel mainPanel,topPanel;
	static int startHt = 60;

	OuterFrame() {
		outer.addWindowListener(this);
		addComponents();
	}
	static void addComponents()
	{
		
		mainPanel=(new MainPanel()).getMainPanel();
		outer.add(mainPanel);
		outer.add((new SidePanel()).getSidePanel());
		outer.add(topPanel=(new TopPanel()).getTopPanel());
		outer.add((new MainMenu()).getMenu());
	}
	

	public static void main(String[] args) {
		path="E:/";
		outer = new JFrame("File Manager");
		outer.setLayout(null);
		outer.setSize(920, 670);
		new OuterFrame();
		outer.setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
