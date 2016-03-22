package FINAL;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class StartingWindow extends JFrame {
	
	public JRadioButton rdbtnJason;
	public JRadioButton rdbtnXML;
	public JRadioButton rdbtnGSON;

	private static final long serialVersionUID = -41345863771087795L;
	private JPanel contentPane;

 	/**
	 * Create the frame.
	 */
	public StartingWindow() {
 		setIconImage(Toolkit.getDefaultToolkit().getImage(StartingWindow.class.getResource("/images/stocks.png")));
 		setFont(new Font("Times New Roman", Font.BOLD, 11));
 		setBackground(new Color(255, 255, 153));
 		setForeground(Color.WHITE);
		setResizable(false);
		setTitle("Select data parser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 206);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		rdbtnJason = new JRadioButton("Simple JSON");
		rdbtnJason.setMinimumSize(new Dimension(85, 60));
		rdbtnJason.setMaximumSize(new Dimension(85, 60));
		rdbtnJason.setPreferredSize(new Dimension(85, 60));
		rdbtnJason.setForeground(new Color(0, 0, 0));
		rdbtnJason.setBackground(new Color(255, 255, 255));
		rdbtnJason.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtnJason.setBounds(10, 33, 109, 23);
		contentPane.add(rdbtnJason);
		
		rdbtnXML = new JRadioButton("XML");
		rdbtnXML.setForeground(new Color(0, 0, 0));
		rdbtnXML.setBackground(new Color(255, 255, 255));
		rdbtnXML.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtnXML.setBounds(10, 59, 109, 23);
		contentPane.add(rdbtnXML);
		
		rdbtnGSON = new JRadioButton("GSON");
		rdbtnGSON.setForeground(new Color(0, 0, 0));
		rdbtnGSON.setBackground(new Color(255, 255, 255));
		rdbtnGSON.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtnGSON.setSelected(true);
		rdbtnGSON.setBounds(10, 7, 109, 23);
		contentPane.add(rdbtnGSON);		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnJason);
		group.add(rdbtnXML);
		group.add(rdbtnGSON);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(new Color(0, 0, 0));
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnOk.setBackground(new Color(204, 204, 255));
		btnOk.setBorder(UIManager.getBorder("Tree.editorBorder"));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnOk.setToolTipText("Continue");
		btnOk.setBounds(318, 144, 89, 23);
		contentPane.add(btnOk);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StartingWindow.class.getResource("/images/ProgressBar.gif")));
		label.setBounds(155, 7, 233, 108);
		contentPane.add(label);
			
		btnOk.addActionListener(MainController.getInstance());
	}
}
