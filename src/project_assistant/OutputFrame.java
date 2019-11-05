package project_assistant;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;

public class OutputFrame extends JFrame {

	private JPanel contentPane;
	
	JScrollPane addedListScroll;
	JScrollPane deletedListScroll;

	public JList addedList;
	public JList deletedList;
	JLabel lblDeletedFile;
	JLabel lblAddedFile;
	
	public OutputFrame() {
		setTitle("Output");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_268710476543");
		panel.setLayout(null);
		
		addedList = new JList();
		addedList.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		//addedList.setBounds(17, 51, 468, 665);
		//panel.add(addedList);
		addedListScroll = new JScrollPane(addedList);
		addedListScroll.setBounds(17,51,468,665);
		panel.add(addedListScroll);
		
		lblAddedFile = new JLabel("Added File :");
		lblAddedFile.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblAddedFile.setBounds(17, 739, 1034, 41);
		panel.add(lblAddedFile);
		
		deletedList = new JList();
		deletedList.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		//deletedList.setBounds(558, 51, 468, 665);
		//panel.add(deletedList);
		deletedListScroll = new JScrollPane(deletedList);
		deletedListScroll.setBounds(558,51,468,665);
		panel.add(deletedListScroll);
		
		lblDeletedFile = new JLabel("Deleted File :");
		lblDeletedFile.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblDeletedFile.setBounds(17, 780, 1034, 41);
		panel.add(lblDeletedFile);
		
		JLabel lblAddedLine = new JLabel("Added Line");
		lblAddedLine.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblAddedLine.setBounds(166, 15, 212, 21);
		panel.add(lblAddedLine);
		
		JLabel lblDeletedLine = new JLabel("Deleted Line");
		lblDeletedLine.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblDeletedLine.setBounds(716, 15, 212, 21);
		panel.add(lblDeletedLine);
		
	}
}
