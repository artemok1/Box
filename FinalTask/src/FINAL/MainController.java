package FINAL;

// Controller class

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MainController implements ActionListener {
	// links
	public static final String JSONLINK = "http://kiparo.ru/t/stock.json";
	public static final String XMLLINK = "http://kiparo.ru/t/stock.xml";

	private static MainController controller = new MainController();

	private MainWindow mainWindow;
	private Parser parser;
	private DataModel dataModel;

	private String selCommand;

	private MainController() {
		super();
	}

	public static MainController getInstance() {
		return controller;
	}

	public void run() {

		// start application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow = new MainWindow();

					mainWindow.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Error occurred: " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);

					return;
				}
			}
		});
	}

	// UI actions
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		// Show progress bar, get and parse data
		if (command.equals(MainWindow.JSON) || command.equals(MainWindow.GSON)
				|| command.equals(MainWindow.XML)) {
			parser = new Parser(command);

			mainWindow.showProgressBar();

			parser.run();

			selCommand = command;

			return;
		}

		// Show sync screen
		if (command.equals(MainWindow.SYNC)) {
			parser = new Parser(selCommand);

			mainWindow.showProgressBar();

			parser.run();

			return;
		}

		// Show statistic screen
		if (command.equals(MainWindow.STAT)) {
			mainWindow.showStat(dataModel);

			return;
		}

		if (command.equals(MainWindow.BACK)) {
			mainWindow.showMainScreen(dataModel);

			return;
		}

		if (command.equals(MainWindow.TIMER)) {
			if (parser.isAlive()) {
				return;
			}

			if (parser.getMessage().equals("")) {
				dataModel = parser.getDataModel();

				if (dataModel != null) {
					mainWindow.showMainScreen(dataModel);

					mainWindow.timer.stop();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Error occurred: " + parser.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				mainWindow.timer.stop();

			}
		}
	}
}
