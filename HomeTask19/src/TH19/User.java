package TH19;

import java.util.ArrayList;
import java.util.List;

public class User implements Cloneable {
	private List<String> usrList;

	public User() {
		this.usrList = new ArrayList<String>();
	}

	public User(List<String> list) {
		this.usrList = list;
	}

	public void loadData() {
		// fill with data
		this.usrList.add("Alexej");
		this.usrList.add("Ra");
		this.usrList.add("Anubis");
		this.usrList.add("Osiris");
	}

	public List<String> getUsrList() {
		return this.usrList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();
		
		for (String s : this.getUsrList()) {
			temp.add(s);
		}
		return new User(temp);
	}
}
