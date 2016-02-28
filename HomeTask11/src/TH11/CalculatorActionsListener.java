package TH11;

/*
 * Actions listener
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorActionsListener implements ActionListener {
	Calculator parent;
	char selectedAction = ' ';
	double currentResult = 0;
	CalculatorEngine engine = new CalculatorEngine();

	CalculatorActionsListener(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent evt) {
		JButton clickedButton = null;

		String displyFieldText = parent.displayField.getText();

		double displayValue = 0;

		// first Exception
		if (!"".equals(displyFieldText)) {
			try {
				displayValue = engine.parseDouble(displyFieldText);
			} catch (NumberException e) {
				JOptionPane.showMessageDialog(null, e.getRussianMessage(),
						"Incorrect Input", JOptionPane.ERROR_MESSAGE);
				parent.displayField.setText("");

				return;
			}
		}

		// get source
		Object source = evt.getSource();
		if (source == parent.btnNewButtonAdd) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");

		} else if (source == parent.btnNewButtonSub) {
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (source == parent.btnNewButtonMult) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (source == parent.btnNewButtonDiv) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (source == parent.btnNewButtonEqual) {
			if (selectedAction == '+') {
				// Add
				currentResult = engine.add(currentResult, displayValue);

				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '-') {
				// Subtract
				currentResult = engine.sub(currentResult, displayValue);

				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '/') {
				// divide, second exception
				try {
					currentResult = engine.div(currentResult, displayValue);
				} catch (NumberZeroException e) {
					JOptionPane.showMessageDialog(null, e.getRussianMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					parent.displayField.setText("");

					return;
				}

				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '*') {
				// Multiply
				currentResult = engine.mult(currentResult, displayValue);
				parent.displayField.setText("" + currentResult);
			}
			
			selectedAction = 'X';

		} else {
			clickedButton = (JButton) source;

			String clickedButtonLabel = clickedButton.getText();

			try {
				engine.parseDouble(clickedButtonLabel);
			} catch (NumberException e) {
				JOptionPane.showMessageDialog(null, e.getRussianMessage(),
						"Incorrect Input", JOptionPane.ERROR_MESSAGE);
				parent.displayField.setText("");

				return;
			}
			
			if (selectedAction == 'X') {
				displyFieldText = "";
			}

			if (clickedButtonLabel == ".") {
				if (("".equals(displyFieldText))) {
					parent.displayField.setText(displyFieldText);
				} else {

					int index = 0;

					index = displyFieldText.indexOf(".");
					if (index > 0) {
						parent.displayField.setText(displyFieldText);
					} else {
						parent.displayField.setText(displyFieldText
								+ clickedButtonLabel);
					}
				}
			} else {

				parent.displayField.setText(displyFieldText
						+ clickedButtonLabel);
			}
		}
	}
}
