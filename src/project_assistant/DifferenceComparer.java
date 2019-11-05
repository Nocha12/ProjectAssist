package project_assistant;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class DifferenceComparer extends FileComparer {
	
	ArrayList<String> CompareLog = new ArrayList<String>();

	public void CompareFile() {
		BufferedReader bfr1 = new BufferedReader(fr);
		BufferedReader bfr2 = new BufferedReader(fr2);
		int count = 0;
		while (true) {
			count++;
			String s1 = null, s2 = null;
			try {
				s1 = bfr1.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				s2 = bfr2.readLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (s1 == null || s2 == null) {
				System.out.println("��");
				break;
			}
			if (s1.compareTo(s2) != 0) {
				CompareLog.add(count+"��° ���� �ٸ��ϴ�.");
				CompareLog.add("ù ��° ���� : " + s1);
				CompareLog.add("�� ��° ���� : " + s2);
			}

		}
		try {
			bfr1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bfr2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

