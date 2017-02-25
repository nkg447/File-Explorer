import javax.swing.*;

public class OuterFrame {
	static String path;
	static JFrame outer;
	static JPanel mainPanel, topPanel;
	static int startHt = 60;

	OuterFrame() {
		addComponents();
	}

	static void addComponents() {

		mainPanel = (new MainPanel()).getMainPanel();
		outer.add(mainPanel);
		outer.add((new SidePanel()).getSidePanel());
		outer.add(topPanel = (new TopPanel()).getTopPanel());
		outer.add((new MainMenu()).getMenu());
	}

	public static void main(String[] args) {
		path = "ThisPc";
		outer = new JFrame("File Manager");
		outer.setLayout(null);
		outer.setSize(920, 670);
		new OuterFrame();
		outer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outer.setVisible(true);
	}

	static void rePaintFrame() {
		OuterFrame.outer.remove(OuterFrame.mainPanel);
		OuterFrame.outer.remove(OuterFrame.topPanel);
		OuterFrame.outer.add(OuterFrame.topPanel = new TopPanel().getTopPanel());
		OuterFrame.outer.add(OuterFrame.mainPanel = new MainPanel().getMainPanel());
		OuterFrame.mainPanel.repaint();
	}

}
