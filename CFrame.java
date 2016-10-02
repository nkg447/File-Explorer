import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;


public class CFrame implements WindowListener
{
	String path;
	JFrame frame=new JFrame();
	JButton button[];
	public CFrame(String loc) 	//a constructor that forms a frame of the path at string loc
	{
		// TODO Auto-generated constructor stub
		path=loc;
		frame.setLayout(null);
		frame.setSize(1500, 700);
		frame.setName(path);
		File flist[]=(new File(path)).listFiles();
		button=new JButton[flist.length];
		createFrame(flist);
		frame.setVisible(true);
	}
	
	
	public CFrame() 	//a constructor that forms a frame of the root path
	{
		// TODO Auto-generated constructor stub
		path="";
		frame.setName(null);
		frame.setLayout(null);
		frame.setSize(1500, 700);
		createMainFrame();
		frame.setVisible(true);
	}
	
	
	private void createMainFrame() 		//create the frame for root path
	{
		// TODO Auto-generated method stub
		final File flist[]=File.listRoots();
		button=new JButton[flist.length];
		
		
		for(int i=0;i<flist.length;i++)
		{
			button[i]=new JButton();
			button[i].setLabel(flist[i].getPath());
			
			button[i].setBounds(30,(i+2)*40, 100, 30);
			final int indx = i;
			button[i].addActionListener(new ActionListener()
			{

				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					File newList[]=flist[indx].listFiles();
					removeComponent(frame);
					createFrame(newList);
				}
				private void removeComponent(JFrame frame) {
					// TODO Auto-generated method stub
					for(int indx=0;indx<flist.length;indx++)
					{
						frame.remove(button[indx]);
					}
				}
				
			});
			frame.add(button[i]);
		}
		frame.addWindowListener(this);
		SwingUtilities.updateComponentTreeUI(frame);
	}


	void createFrame(final File[] newList) //create frame of thefile list given
	{
		addBackButton();
		path=newList[0].getParent();
		System.out.println(path);
		button=new JButton[newList.length];
		for(int i=0;i<newList.length;i++)
		{
			final int indx = i;
			button[i]=new JButton();
			button[i].setLabel(newList[i].getName());
			button[i].setBounds((i%8)*150+30,((i/8)+2)*40, 150, 30);
			if(newList[i].isFile())
			{
				button[i].setBackground(new java.awt.Color(0,204,204));
				button[i].addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						
						try {
							open(newList[indx].getPath());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				});
			}
			else
			{
				button[i].addActionListener(new ActionListener()
				{

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println(path);
						
						File flist[]=newList[indx].listFiles();
						removeComponent(path);
						createFrame(flist);
					}
					
				});
			}
			
			
			
			frame.add(button[i]);
			
		}
		SwingUtilities.updateComponentTreeUI(frame);	
			
	}


	private void addBackButton() 	//ads back button
	{
		final JButton back=new JButton("BACK");
		back.setBounds(30, 40, 80, 30);
		
		back.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(path.length()<4)
				{
					removeComponent(path);
					frame.remove(back);
					createMainFrame();
				}
				else
				{
					
					File parentDir=new File(path);
					parentDir=new File(parentDir.getParent());
					File flist[]=parentDir.listFiles();
					removeComponent(path);
					createFrame(flist);
				}
				
			}
			
		});
		frame.add(back);
		SwingUtilities.updateComponentTreeUI(frame);	
	}


	void removeComponent(String parent) 	//removes component fron older frames
	{
		// TODO Auto-generated method stub
		File temp=new File(parent);
		//temp=new File(temp.getParent());
		File templ[]=temp.listFiles();
		for(int i=0;i<templ.length;i++)
			frame.remove(button[i]);
		
	}


	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}


	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}


	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void open(String targetFilePath) throws IOException
	{
		Desktop desktop = Desktop.getDesktop();

		desktop.open(new File(targetFilePath));
	}
}
