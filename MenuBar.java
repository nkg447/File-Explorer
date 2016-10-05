import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;




public class MenuBar extends CFrame
{
	Runtime rt = Runtime.getRuntime();
	JMenuBar menubar=new JMenuBar();
	
	public MenuBar() {
		// TODO Auto-generated constructor stub
		addMenuBar();
		(new SearchField(frame)).addSearchField();
	}
	MenuBar(String loc)
	{
		super(loc);
		addMenuBar();
	}
	void addMenuBar()
	{
		frame.add(menubar);
		menubar.setBounds(0, 0, 1500, 30);
		addFileBar();
		addViewBar();
		
	}
	private void addViewBar() 
	{
		JMenu view=new JMenu("View");
		menubar.add(view);
		
		JMenu sortBy=new JMenu("Sort By");
		JMenuItem bydate=new JMenuItem("date");
		JMenuItem byname=new JMenuItem("name");
		JMenuItem bysize=new JMenuItem("size");
		sortBy.add(byname);
		sortBy.add(bydate);
		sortBy.add(bysize);
		byname.addActionListener(defaultHandler);
		bydate.addActionListener(defaultHandler);
		bysize.addActionListener(defaultHandler);
		view.add(sortBy);
		
	}
	private void addFileBar() {

		// TODO Auto-generated method stub
		JMenu file=new JMenu("File");
		menubar.add(file);
		JMenuItem openInNew=new JMenuItem("Open in new Frame");
		file.add(openInNew);
		openInNew.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				new MenuBar(path);
			}
		
		});
		
		JMenuItem cmd=new JMenuItem("Open cmd here");
		file.add(cmd);
		cmd.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				System.out.println(path);
				try {
					
					rt.exec("cmd.exe /c start", null, (new File(path)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		});
		
		JMenuItem close=new JMenuItem("close");
		file.add(close);
		close.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				System.exit(0);
			}
		
		});
	}
	
	ActionListener defaultHandler = new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	
	      if(e.getActionCommand().equals("name"))
	      {
	    	  removeComponent(path);
	    	  createFrame(new File(path),3);
	      }
	      else if(e.getActionCommand().equals("date"))
	      {
	    	  removeComponent(path);
	    	  createFrame(new File(path),1);
	      }
	      else if(e.getActionCommand().equals("size"))
	      {
	    	  removeComponent(path);
	    	  createFrame(new File(path),2);
	      }
	     
	    }
	  };
	  
}
