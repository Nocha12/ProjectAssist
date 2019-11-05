package project_assistant;

import java.util.ArrayList;

public class LineComparer extends FileComparer {

	ArrayList<String> erased = new ArrayList<String>();
	ArrayList<Integer> erasedLine = new ArrayList<Integer>();
	ArrayList<String> added = new ArrayList<String>();
	ArrayList<Integer> addedLine = new ArrayList<Integer>();

	public void CompareFile() {
		FileClass fc1 = new FileClass(fr);
		FileClass fc2 = new FileClass(fr2);
		fc1.ReadLine();
		fc2.ReadLine();

		int rcount = 0;
		int lcount = 0;
		while (true) {
			if (lcount >= fc1.lineValues.size())
				break;
			int i;
			for (i = 0; i < fc2.lineValues.size(); i++) {
				if (fc1.lineValues.get(lcount).equals(fc2.lineValues.get(i))) {
					break;
				}
			}
			if (i == fc2.lineValues.size()) {
				erased.add(fc1.lineValues.get(lcount));
				erasedLine.add(lcount + 1);
			}
			lcount++;
		}
		while (true) {
			if (rcount >= fc2.lineValues.size())
				break;
			int i;
			for (i = 0; i < fc1.lineValues.size(); i++) {
				if (fc2.lineValues.get(rcount).equals(fc1.lineValues.get(i))) {
					break;
				}
			}
			if (i == fc1.lineValues.size()) {
				added.add(fc2.lineValues.get(rcount));
				addedLine.add(rcount + 1);
			}
			rcount++;
		}
	}
}
