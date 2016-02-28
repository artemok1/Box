package TH12;

/*
 * Actions listener for Mans and Women
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

public class ManAndWomenActionsListener implements ActionListener {
	Application2 parent;
	char selectedAction = ' ';
	double currentResult = 0;

	ManAndWomenActionsListener(Application2 parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent evt) {
		switch (evt.getActionCommand()) {
		case "ADD_NEW": // add new person
			String surname = this.parent.surname.getText();

			if (surname.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Field 'Surname' is obligatory", "Incorrect Input",
						JOptionPane.ERROR_MESSAGE);

				return;
			}

			String name = this.parent.name.getText();

			if (name.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Field 'Name' is obligatory", "Incorrect Input",
						JOptionPane.ERROR_MESSAGE);

				return;
			}

			String middleName = this.parent.middleName.getText(); // is not obligatory

			if (this.parent.sexMan.isSelected()) {
				Person man = new Person(this.parent.dataSet.get(
						Application2.MAN).size() + 1); // id = size + 1
				man.setSurname(surname);
				man.setName(name);
				man.setMidleName(middleName);

				this.parent.dataSet.get(Application2.MAN).add(man);

				this.parent.manTable.updateUI();
			} else {
				Person woman = new Person(this.parent.dataSet.get(
						Application2.WOMAN).size() + 1); // id = size + 1
				woman.setSurname(surname);
				woman.setName(name);
				woman.setMidleName(middleName);

				this.parent.dataSet.get(Application2.WOMAN).add(woman);

				this.parent.womanTable.updateUI();
			}

			// init
			this.parent.surname.setText("");
			this.parent.name.setText("");
			this.parent.middleName.setText("");

			break;
		case "MAN": // show random man
			if (this.parent.dataSet.get(Application2.MAN).size() == 0) {
				JOptionPane.showMessageDialog(null,
						"Add at least one man to the array", "Failed",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			// get random index
			int idx = new Random().nextInt(this.parent.dataSet.get(
					Application2.MAN).size());

			Person man = this.parent.dataSet.get(Application2.MAN).get(idx);

			JOptionPane.showMessageDialog(null, man.toString(), "Random man",
					JOptionPane.INFORMATION_MESSAGE);

			break;
		case "WOMEN": // show random women
			if (this.parent.dataSet.get(Application2.WOMAN).size() == 0) {
				JOptionPane.showMessageDialog(null,
						"Add at least one woman to the array", "Failed",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			// get random index
			int idxW = new Random().nextInt(this.parent.dataSet.get(
					Application2.WOMAN).size());

			Person woman = this.parent.dataSet.get(Application2.WOMAN).get(idxW);

			JOptionPane.showMessageDialog(null, woman.toString(), "Random woman",
					JOptionPane.INFORMATION_MESSAGE);

			break;
		default:
			break;
		}
		;

	}
}
