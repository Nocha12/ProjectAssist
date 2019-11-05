package project_assistant;

import java.io.File;
import java.util.ArrayList;

public class MainGUI {
	
	public static void main(String[] args) {
		OutputFrame outputFrame = new OutputFrame();
		outputFrame.setVisible(false);
		
		MainFrame frame = new MainFrame(outputFrame);
		frame.setVisible(true);
	}
}
