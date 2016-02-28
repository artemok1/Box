package TH11;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Font;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFormattedTextField displayField;
	JButton btnNewButtonAdd;
	JButton btnNewButtonSub;
	JButton btnNewButtonMult;
	JButton btnNewButtonDiv;
	JButton btnNewButtonEqual;

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(7, 3));
		
		displayField = new JFormattedTextField();
		displayField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		displayField.setPreferredSize(new Dimension(6, 30));
		displayField.setMinimumSize(new Dimension(10, 10));
		displayField.setEditable(false);
		displayField.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(displayField, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 3, 3, 3));
		
		CalculatorActionsListener calcListener = new CalculatorActionsListener(this);
		
		JButton btnNewButton7 = new JButton("7");
		btnNewButton7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton7.setSize(new Dimension(25, 23));
		btnNewButton7.setMaximumSize(new Dimension(23, 23));
		btnNewButton7.setPreferredSize(new Dimension(25, 23));
		panel.add(btnNewButton7);
		btnNewButton7.addActionListener(calcListener);
		
		JButton btnNewButton8 = new JButton("8");
		btnNewButton8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton8);
		btnNewButton8.addActionListener(calcListener);
		
		JButton btnNewButton9 = new JButton("9");
		btnNewButton9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton9);
		btnNewButton9.addActionListener(calcListener);
		
		JButton btnNewButton4 = new JButton("4");
		btnNewButton4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton4);
		btnNewButton4.addActionListener(calcListener);
		
		JButton btnNewButton5 = new JButton("A");
		btnNewButton5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton5);
		btnNewButton5.addActionListener(calcListener);
		
		JButton btnNewButton6 = new JButton("6");
		btnNewButton6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton6);
		btnNewButton6.addActionListener(calcListener);
		
		JButton btnNewButton1 = new JButton("1");
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton1);
		btnNewButton1.addActionListener(calcListener);
		
		JButton btnNewButton2 = new JButton("2");
		btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton2);
		btnNewButton2.addActionListener(calcListener);
		
		JButton btnNewButton3 = new JButton("3");
		btnNewButton3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton3);
		btnNewButton3.addActionListener(calcListener);
		
		JButton btnNewButtonZero = new JButton("0");
		btnNewButtonZero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButtonZero);
		btnNewButtonZero.addActionListener(calcListener);
		
		JButton btnNewButtonDot = new JButton(".");
		btnNewButtonDot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButtonDot);
		btnNewButtonDot.addActionListener(calcListener);
		
		btnNewButtonEqual = new JButton("=");
		btnNewButtonEqual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButtonEqual);
		btnNewButtonEqual.addActionListener(calcListener);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(80, 10));
		panel_1.setBounds(new Rectangle(5, 5, 5, 5));
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(4, 1, 3, 3));
		
		btnNewButtonDiv = new JButton("/");
		btnNewButtonDiv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnNewButtonDiv);
		btnNewButtonDiv.addActionListener(calcListener);
		
		btnNewButtonMult = new JButton("*");
		btnNewButtonMult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnNewButtonMult);
		btnNewButtonMult.addActionListener(calcListener);
		
		btnNewButtonSub = new JButton("-");
		btnNewButtonSub.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnNewButtonSub);
		btnNewButtonSub.addActionListener(calcListener);
		
		btnNewButtonAdd = new JButton("+");
		btnNewButtonAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnNewButtonAdd);
		btnNewButtonAdd.addActionListener(calcListener);
		
	}

}
