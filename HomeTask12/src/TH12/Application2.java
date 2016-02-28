package TH12;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Application2 extends JFrame {
	
	public HashMap<String, ArrayList<Person>> dataSet;
	
	public JTextField surname;
	public JTextField name;
	public JTextField middleName;
	
	public JRadioButton sexMan;
	public JRadioButton sexWoman;
	
	public JTable manTable;
	public JTable womanTable;
	
	public static String MAN = "man";
	public static String WOMAN = "woman";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Application2() {
		setTitle("Task 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ManAndWomenActionsListener Listener = new ManAndWomenActionsListener(this);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 120));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		surname = new JTextField();
		surname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		surname.setBounds(102, 8, 319, 20);
		panel.add(surname);
		surname.setColumns(10);

		JLabel lblNewLabel = new JLabel("Surname");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setLabelFor(surname);
		lblNewLabel.setBounds(10, 11, 102, 14);
		panel.add(lblNewLabel);

		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		name.setBounds(102, 33, 319, 20);
		panel.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setLabelFor(name);
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		panel.add(lblNewLabel_1);

		middleName = new JTextField();
		middleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		middleName.setBounds(102, 58, 319, 20);
		panel.add(middleName);
		middleName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Middle Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setLabelFor(middleName);
		lblNewLabel_2.setBounds(10, 61, 86, 14);
		panel.add(lblNewLabel_2);

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		
		sexMan = new JRadioButton("Man");
		sexMan.setSelected(true);
		group.add(sexMan);
		sexMan.setBounds(443, 8, 109, 23);
		panel.add(sexMan);		

		sexWoman = new JRadioButton("Woman");
		group.add(sexWoman);
		sexWoman.setBounds(443, 33, 109, 23);
		panel.add(sexWoman);
		
		JButton btnNewButton = new JButton("Add New");
		btnNewButton.addActionListener(Listener);
		btnNewButton.setActionCommand("ADD_NEW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setToolTipText("Add new person to the array");
		btnNewButton.setBounds(10, 86, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Random Man");
		btnNewButton_1.addActionListener(Listener);
		btnNewButton_1.setToolTipText("Show random man");
		btnNewButton_1.setActionCommand("MAN");
		btnNewButton_1.setBounds(443, 86, 160, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Random Women");
		btnNewButton_2.addActionListener(Listener);
		btnNewButton_2.setActionCommand("WOMEN");
		btnNewButton_2.setToolTipText("Show random women");
		btnNewButton_2.setBounds(620, 86, 160, 23);
		panel.add(btnNewButton_2);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setPreferredSize(new Dimension(179, 500));
		contentPane.add(splitPane, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		// define data model
		ArrayList<Person> men = new ArrayList<Person>();
		ArrayList<Person> women = new ArrayList<Person>();
		
		dataSet = new HashMap<String, ArrayList<Person>>();
		dataSet.put(MAN, men);
		dataSet.put(WOMAN, women);

		// table for men
		PersonTableModel modelMan = new PersonTableModel(dataSet, MAN);
		
		manTable = new JTable(modelMan);
		manTable.setToolTipText("Men");
		manTable.getColumnModel().getColumn(0).setMaxWidth(60);
		scrollPane.setViewportView(manTable);

		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);

		// table for women 
		PersonTableModel modelWoman = new PersonTableModel(dataSet, WOMAN);
		
		womanTable = new JTable(modelWoman);
		womanTable.setToolTipText("Women");
//		table_1.getColumnModel().getColumn(0).setMaxWidth(60);
		scrollPane_1.setViewportView(womanTable);

		splitPane.setDividerLocation(0.5);
		splitPane.setResizeWeight(0.5);
	}
}
