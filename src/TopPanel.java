import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.security.Key;

import javax.swing.*;

public class TopPanel implements KeyListener {

	static JTextField add;

	JPanel getTopPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 20, 900, 55);
		topPanel.setBackground(new Color(255, 255, 255));

		JButton back = new JButton();
		back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backButton.png")));
		back.setFocusPainted(false);
		back.setMargin(new Insets(0, 0, 0, 0));
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setOpaque(false);
		back.setBounds(10, 10, 30, 30);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OuterFrame.path = (new File(OuterFrame.path).getParent());
				OuterFrame.rePaintFrame();
			}
		});

		add = new JTextField(OuterFrame.path);
		add.setBounds(210, 10, 450, 30);
		add.addKeyListener(this);

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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			OuterFrame.path = add.getText();
			OuterFrame.rePaintFrame();
		}
	}

}
