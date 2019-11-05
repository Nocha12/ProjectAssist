package project_assistant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileComparer {

	FileReader fr = null;
	FileReader fr2 = null;
	
	String name;

	public boolean StartCompare(String path1, String path2) {

		boolean canDo = true;

		try {
			File file = new File(path1);
			fr = new FileReader(file);
			name = file.getName();
		} catch (FileNotFoundException e) {
			System.out.println(path1 + "를 찾을 수 없습니다");
			canDo = false;
		}
		try {
			fr2 = new FileReader(path2);
		} catch (FileNotFoundException e) {
			System.out.println(path2 + "를 찾을 수 없습니다");
			canDo = false;
		}
		if (canDo) {
			return true;
		}
		else{
			return false;
		}
	}

	public void CompareFile() {}

}
