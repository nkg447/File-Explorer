import java.io.File;


public class SortBy
{
	void sort(File list[],int mode)
	{
		int cdir=0,cfile=0;
		File temp;
		for(int i=0;i<list.length;i++)
		{
			if(list[i].isDirectory())
				cdir++;
			else
				cfile++;
		}
		File dir[]=new File[cdir];
		File file[]=new File[cfile];
		cdir=0;
		cfile=0;
		for(int i=0;i<list.length;i++)
		{
			if(list[i].isDirectory())
				dir[cdir++]=list[i];
			else
				file[cfile++]=list[i];
		}
		
		if(mode!=3)
		{
			for(int i=0;i<dir.length;i++)
			{
				for(int j=i+1;j<dir.length-1;j++)
				{
					if(toCompare(dir[i],dir[j],mode))
					{
						temp=dir[i];
						dir[i]=dir[j];
						dir[j]=temp;
					}
				}
			}
			
			for(int i=0;i<file.length;i++)
			{
				for(int j=i+1;j<file.length-1;j++)
				{
					if(toCompare(file[i],file[j],mode))
					{
						temp=file[i];
						file[i]=file[j];
						file[j]=temp;
					}
				}
			}
		}
		
		for(int i=0;i<dir.length;i++)
		{
			list[i]=dir[i];
		}
		cdir=dir.length;
		for(int i=0;i<file.length;i++)
		{
			list[cdir++]=file[i];
		}
	}

	private boolean toCompare(File file, File file2, int mode) 
	{
		switch(mode)
		{
			case 1: return byDate(file,file2);

			case 2: return bySize(file,file2);
			
			case 4: return byType(file,file2);
				
		}
		return false;
		
	}

	private boolean byType(File file, File file2) 
	{
		return false;
	}

	private boolean bySize(File file, File file2) 
	{
		if(file.length()<file2.length())
			return false;
		return true;
	}

	private boolean byDate(File file, File file2) 
	{
		if(file.lastModified()<file2.lastModified())
			return false;
		return true;
	}
}
