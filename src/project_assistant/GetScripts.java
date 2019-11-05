package project_assistant;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GetScripts {
	public ArrayList<File> scriptsList = new ArrayList<>();
	public ArrayList<String> scriptsNameList = new ArrayList<>();
	
	private String[] extension = { ".cpp", ".c", ".java", ".py", ".h" };
	
	public GetScripts() {}
	
	private void PushScript(File file)
	{
		if(file.isDirectory()) return;
		
		for(int i = 0; i < extension.length; i++)
		if(file.getName().endsWith(extension[i])) {
			scriptsList.add(file);
			scriptsNameList.add(file.getName());
		}
	}
	
	public GetScripts(File file)
	{
		Queue<File> fileQueue = new LinkedList<>();
		
		File rootDir = file;
		fileQueue.offer(rootDir);
		
		while(!fileQueue.isEmpty())
		{
			File tempFile = fileQueue.poll();
			
			if(tempFile.isDirectory())
			{	
				File []fileList = tempFile.listFiles();
				for(int i = 0; i < fileList.length; i++)
				{
					fileQueue.offer(fileList[i]);
					PushScript(fileList[i]);
				}
			}
		}
	}
}
