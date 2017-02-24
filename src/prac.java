import java.awt.GridLayout;import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class prac {

	public static void main(String args[])
	{
		
		
		Runtime rt = Runtime.getRuntime();
		try {
			String s="E:/Multimedia/Sherlock/\"Sherlock S0.ico\"";
			rt.exec(s);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
