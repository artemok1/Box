package TH12;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Application extends JFrame {
	private static final long serialVersionUID = 1L;
	public JTextField textField;
	public JTable table;
	public ArrayList<String> dataList = new ArrayList<String>();
	public SimpleArrayTableModel model;
	public DefaultTableModel tableModel;

	/**
	 * Create the frame.
	 */
	public Application() {
		setTitle("Home Task 1 and 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 420);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 20));
		panel.add(panel_1);
		panel_1.setLayout(null);

		SimpleArrayActionsListener Listener = new SimpleArrayActionsListener(this);

		JButton btnNewButton = new JButton("Add ");
		btnNewButton.setIcon(new ImageIcon(Application.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		btnNewButton.addActionListener(Listener);

		btnNewButton.setActionCommand("NEW");
		btnNewButton.setToolTipText("Add Element to the Array");
		btnNewButton.setSelected(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 0, 86, 23);
		btnNewButton.setMaximumSize(new Dimension(25, 23));
		btnNewButton.setMinimumSize(new Dimension(25, 23));
		btnNewButton.setPreferredSize(new Dimension(25, 23));
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(Listener);

		btnNewButton_1.setActionCommand("REMOVE_A");
		btnNewButton_1.setToolTipText("Remove all occurrence of 'a'");
		btnNewButton_1
				.setIcon(new ImageIcon(Application.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Background-Color-Black.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(96, 0, 49, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(Listener);
		btnNewButton_2.setActionCommand("DUPICATES");
		btnNewButton_2.setIcon(new ImageIcon(Application.class.getResource("/com/sun/javafx/scene/web/skin/UnorderedListBullets_16x16_JFX.png")));
		btnNewButton_2.setToolTipText("Remove Duplicates");
		btnNewButton_2.setBounds(157, 0, 49, 23);
		panel_1.add(btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		// create table model
		model = new SimpleArrayTableModel(dataList);

		table = new JTable(model);

		table.getColumnModel().getColumn(0).setMaxWidth(60);

		scrollPane.setViewportView(table);

	}
}
