package project_assistant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileClass {
	public ArrayList<String> lineValues;

	BufferedReader bfr;

	FileClass(FileReader fr) {
		bfr = new BufferedReader(fr);
		lineValues = new ArrayList<String>();
	}

	public void ReadLine() {
		String s1 = null;
		try {
			while ((s1 = bfr.readLine()) != null) {
				lineValues.add(s1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bfr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
