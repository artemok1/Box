package TH12;

/*
 * Actions listener
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class SimpleArrayActionsListener implements ActionListener {
	Application parent;
	char selectedAction = ' ';
	double currentResult = 0;

	SimpleArrayActionsListener(Application parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent evt) {
		switch (evt.getActionCommand()) {
		case "NEW": // add element to the array
			String data = this.parent.textField.getText(); 
			
			this.parent.model.addRow(data); 
			
			this.parent.table.updateUI();
			
			this.parent.textField.setText("");
			
			break;
		case "REMOVE_A": // remove all occurrence of 'a'
			for (int i = 0; i < parent.dataList.size(); i++) {
				 String row = parent.dataList.get(i);
				 
				 row = row.replaceAll("a", "");
				 
				 parent.dataList.set(i, row);
			}
			
			this.parent.table.updateUI();
			
			break;
		case "DUPICATES":
			Set<String> hs = new HashSet<String>();
			hs.addAll(parent.dataList);
			parent.dataList.clear();
			
			parent.dataList.addAll(hs);
			
			this.parent.table.updateUI();
			
			break;
		default:
			break;
		} ;
	
	}
}
