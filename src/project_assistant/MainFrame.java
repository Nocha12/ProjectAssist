package project_assistant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	public File file1 = null;
	public File file2 = null;
	
	public MainFrame(OutputFrame outputFrame) 
	{
		setTitle("Project Assistant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPath = new JLabel("Path : ");
		lblPath.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblPath.setBounds(14, 16, 635, 18);
		contentPane.add(lblPath);
		
		JLabel label = new JLabel("Path : ");
		label.setFont(new Font("Consolas", Font.PLAIN, 20));
		label.setBounds(14, 42, 635, 18);
		contentPane.add(label);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnSearch.setBounds(663, 12, 105, 27);
		contentPane.add(btnSearch);
		
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				file1 = ChooseFile();
				
				if(file1 != null)
					lblPath.setText("Path : " + file1.getPath()); 
			}
		});
		
		JButton button = new JButton("Search");
		button.setFont(new Font("Consolas", Font.PLAIN, 20));
		button.setBounds(663, 42, 105, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				file2 = ChooseFile();
				
				if(file2 != null)
					label.setText("Path : " + file2.getPath()); 
			}
		});
		
		JButton btnCompare = new JButton("Compare");
		btnCompare.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnCompare.setBounds(590, 87, 178, 27);
		contentPane.add(btnCompare);
		btnCompare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(file1 == null || file2 == null)
					return;
				GetScripts scripts1 = new GetScripts(file1);
				GetScripts scripts2 = new GetScripts(file2);
				
				DefaultListModel dmAdded = new DefaultListModel();
				DefaultListModel dmDeleted = new DefaultListModel();
				
				for(int i = 0; i < scripts1.scriptsList.size(); i++)
				{
					for(int j = 0; j < scripts2.scriptsList.size(); j++)
					{
						if(scripts1.scriptsList.get(i).getName().equals(scripts2.scriptsList.get(j).getName()))
						{
							LineComparer fc = new LineComparer();
							if(fc.StartCompare(scripts1.scriptsList.get(i).getPath(), scripts2.scriptsList.get(j).getPath()));
								fc.CompareFile();
							
							if(fc.erased.size() > 0 || fc.added.size() > 0)
								
								System.out.println(fc.name);
							if(fc.erased.size() > 0)
							{
								dmAdded.addElement("\n");
								dmAdded.addElement(fc.name);
								dmAdded.addElement("\n");
								//dmAdded.addElement("삭제된 것");
								
								for(int k = 0; k < fc.erased.size(); k++)	
								{
									dmAdded.addElement(fc.erasedLine.get(k)+"줄 "+fc.erased.get(k));
								}
							}
							
							if(fc.added.size() > 0)
							{
								dmDeleted.addElement("\n");
								dmDeleted.addElement(fc.name);
								dmDeleted.addElement("\n");
								//dmDeleted.addElement("추가된 것");
								
								for(int k = 0; k < fc.added.size(); k++){
									dmDeleted.addElement(fc.addedLine.get(k)+"줄 "+fc.added.get(k));
								}
							}
							outputFrame.deletedList.setModel(dmDeleted);
						}
					}
				}
				outputFrame.addedList.setModel(dmDeleted);
				outputFrame.deletedList.setModel(dmAdded);
				
				ArrayList<String> sourceList = new ArrayList<String>(scripts1.scriptsNameList);
				ArrayList<String> destinationList = new ArrayList<String>(scripts2.scriptsNameList);

				sourceList.removeAll( scripts2.scriptsNameList );
			    destinationList.removeAll( scripts1.scriptsNameList );
			 
			    outputFrame.lblAddedFile.setText("Added File : " + destinationList);
			    outputFrame.lblDeletedFile.setText("Deleted File : " + sourceList);
			   
			    outputFrame.setVisible(true);
			}
		});
	}
	
	File ChooseFile()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int value = chooser.showOpenDialog(null);
		if(value == JFileChooser.APPROVE_OPTION)
			return chooser.getSelectedFile();
		else
			return null;
	}
}
