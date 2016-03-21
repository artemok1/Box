package FINAL;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.internal.chartpart.Chart;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -7091500217510571512L;
	private JPanel contentPane;

	private TableRowSorter<StockTableModel> sorter;
	private JPanel progressBar;
	private JLabel progressIcon;

	public Timer timer;

	JTable tableStock;
	
	// UI commands
	public static final String XML = "XML";
	public static final String JSON = "JSON";
	public static final String GSON = "GSON";
	public static final String SYNC = "SYNC";
	public static final String STAT = "STAT";
	public static final String TIMER = "TIMER";
	public static final String BACK = "BACK";	

	private MainController actionListener = MainController.getInstance();

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Moskow Stock");

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				MainWindow.class.getResource("/images/stocks.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 612);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		syncScreen();
	}

	// Progress bar
	public void showProgressBar() {
		contentPane.removeAll();

		progressBar = new JPanel();
		progressBar.setBackground(new Color(255, 255, 255));
		contentPane.add(progressBar, BorderLayout.CENTER);
		progressBar.setLayout(new GridLayout(0, 1, 0, 0));

		progressIcon = new JLabel("Loading data from cloud...");
		progressIcon.setForeground(new Color(154, 205, 50));
		progressIcon.setFont(new Font("MV Boli", Font.BOLD, 20));
		progressIcon.setHorizontalAlignment(SwingConstants.CENTER);
		progressIcon.setBackground(new Color(255, 255, 255));
		progressIcon.setIcon(new ImageIcon(MainWindow.class
				.getResource("/images/CircularProgressAnimation.gif")));
		progressBar.add(progressIcon);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		contentPane.validate();
		contentPane.repaint();

		timer = new Timer(2500, actionListener);
		timer.setActionCommand(TIMER);
		timer.start();
	}

	// Main screen with data
	public void showMainScreen(DataModel dataModel) {
		contentPane.removeAll();

		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(255, 255, 255));
		panelNorth.setPreferredSize(new Dimension(10, 80));
		panelNorth.setMinimumSize(new Dimension(0, 0));
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));

		JPanel panelToolbar = new JPanel();
		panelToolbar.setBackground(new Color(255, 255, 255));
		panelToolbar.setMinimumSize(new Dimension(10, 50));
		panelToolbar.setPreferredSize(new Dimension(10, 50));
		panelNorth.add(panelToolbar, BorderLayout.CENTER);
		panelToolbar.setLayout(null);

		JButton btnSync = new JButton("");
		btnSync.setIcon(new ImageIcon(MainWindow.class
				.getResource("/images/sync.jpg")));
		btnSync.setBounds(0, 0, 78, 60);
		btnSync.setActionCommand(SYNC);
		btnSync.setToolTipText("Sync to the cloud");
		btnSync.setBorder(null);
		btnSync.setBorderPainted(false);
		btnSync.setBackground(new Color(255, 255, 255));
		btnSync.addActionListener(actionListener);
		panelToolbar.add(btnSync);

		JButton btnStat = new JButton("");
		btnStat.setIcon(new ImageIcon(MainWindow.class
				.getResource("/images/Stat.png")));
		btnStat.setActionCommand(STAT);
		btnStat.setToolTipText("Statistics");
		btnStat.setBorderPainted(false);
		btnStat.setBorder(null);
		btnStat.setBackground(new Color(255, 255, 255));
		btnStat.setBounds(83, 0, 78, 60);
		btnStat.addActionListener(actionListener);
		panelToolbar.add(btnStat);

		JPanel panelCenter = new JPanel();
		panelNorth.add(panelCenter, BorderLayout.SOUTH);
		panelCenter.setLayout(new GridLayout(0, 6, 0, 0));
		panelCenter.setBackground(new Color(255, 255, 255));

		JTextField filter0 = new JTextField();
		panelCenter.add(filter0);
		filter0.setColumns(10);

		// Whenever filterText changes, invoke newFilter.
		// filter 1 column
		filter0.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter(filter0, 0);
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter(filter0, 0);
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter(filter0, 0);
			}
		});

		JTextField filter1 = new JTextField();
		panelCenter.add(filter1);
		filter1.setColumns(10);

		// filter 2 column
		filter1.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter(filter1, 1);
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter(filter1, 1);
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter(filter1, 1);
			}
		});

		JTextField filter2 = new JTextField();
		panelCenter.add(filter2);
		filter2.setColumns(10);

		// filter 3 column
		filter2.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter(filter2, 2);
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter(filter2, 2);
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter(filter2, 2);
			}
		});

		JTextField filter3 = new JTextField();
		panelCenter.add(filter3);
		filter3.setColumns(10);

		// filter 4 column
		filter3.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter(filter3, 3);
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter(filter3, 3);
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter(filter3, 3);
			}
		});

		JTextField filter4 = new JTextField();
		panelCenter.add(filter4);
		filter4.setColumns(10);

		// filter 5 column
		filter4.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter(filter4, 4);
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter(filter4, 4);
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter(filter4, 4);
			}
		});

		JTextField filter5 = new JTextField();
		panelCenter.add(filter5);
		filter5.setColumns(10);

		// filter 6 column
		filter5.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter(filter5, 5);
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter(filter5, 5);
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter(filter5, 5);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(0, 0));
		scrollPane.setBackground(new Color(204, 204, 255));
		contentPane.add(scrollPane, BorderLayout.CENTER);

		StockTableModel tableModel = new StockTableModel(
				(ArrayList<Stock>) dataModel.getStock());

		sorter = new TableRowSorter<StockTableModel>(tableModel);

		tableStock = new JTable(tableModel);
		tableStock.setSelectionForeground(new Color(0, 0, 0));
		tableStock.setSelectionBackground(new Color(255, 255, 255));
		tableStock.setGridColor(new Color(204, 204, 255));
		tableStock.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		tableStock.setBackground(new Color(204, 204, 204));
		tableStock.setAutoCreateRowSorter(true);
		tableStock.setRowSorter(sorter);
		scrollPane.setViewportView(tableStock);

		contentPane.validate();
		contentPane.repaint();
	}

	// Start Screen
	public void syncScreen() {
		contentPane.removeAll();

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel mainPanel = new JPanel();
		panel.add(mainPanel);
		mainPanel.setMaximumSize(new Dimension(32767, 180));
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setPreferredSize(new Dimension(10, 240));
		mainPanel.setLayout(new GridLayout(4, 1, 10, 3));

		JLabel lblNewLabel = new JLabel("  Select option to parse the data:");
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		mainPanel.add(lblNewLabel);

		JButton buttonXML = new JButton("  XML");
		buttonXML.setActionCommand(XML);
		buttonXML.setIcon(new ImageIcon(MainWindow.class
				.getResource("/images/XML.png")));
		buttonXML.setForeground(new Color(105, 105, 105));
		buttonXML.setFont(new Font("SansSerif", Font.BOLD, 14));
		buttonXML.setBackground(new Color(211, 211, 211));
		buttonXML.setBorderPainted(false);
		buttonXML.setHorizontalAlignment(SwingConstants.LEFT);
		mainPanel.add(buttonXML);

		JButton buttonGSON = new JButton("  GSON");
		buttonGSON.setActionCommand(GSON);
		buttonGSON.setIcon(new ImageIcon(MainWindow.class
				.getResource("/images/GSON.png")));
		buttonGSON.setForeground(new Color(105, 105, 105));
		buttonGSON.setFont(new Font("SansSerif", Font.BOLD, 14));
		buttonGSON.setBackground(new Color(211, 211, 211));
		buttonGSON.setBorderPainted(false);
		buttonGSON.setHorizontalAlignment(SwingConstants.LEFT);
		mainPanel.add(buttonGSON);

		JButton buttonJSON = new JButton("  Simple JSON");
		mainPanel.add(buttonJSON);
		buttonJSON.setActionCommand(JSON);
		buttonJSON.setIcon(new ImageIcon(MainWindow.class
				.getResource("/images/JSON.png")));
		buttonJSON.setForeground(new Color(105, 105, 105));
		buttonJSON.setFont(new Font("SansSerif", Font.BOLD, 14));
		buttonJSON.setBackground(new Color(211, 211, 211));
		buttonJSON.setBorderPainted(false);
		buttonJSON.setHorizontalAlignment(SwingConstants.LEFT);
		buttonJSON.addActionListener(actionListener);
		buttonGSON.addActionListener(actionListener);

		buttonXML.addActionListener(actionListener);

		contentPane.validate();
		contentPane.repaint();
	}

	public void showStat(DataModel dataModel) {
		contentPane.removeAll();
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(255, 255, 255));
		panelNorth.setPreferredSize(new Dimension(10, 60));
		panelNorth.setMinimumSize(new Dimension(0, 0));
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setMinimumSize(new Dimension(10, 40));
		panel.setPreferredSize(new Dimension(10, 40));
		panelNorth.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setActionCommand(BACK);
		btnNewButton.setToolTipText("Back");
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(MainWindow.class
				.getResource("/images/Back.jpg")));
		btnNewButton.addActionListener(actionListener);

		btnNewButton.setBounds(0, 0, 135, 56);
		panel.add(btnNewButton);

		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(255, 255, 255));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(2, 2, 5, 5));

		// Max price chart
		@SuppressWarnings("rawtypes")
		Chart chartMax = new CompareChart(dataModel.getStock(), CompareChart.MAX_PRICE).getChart();		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		XChartPanel xpanelMax = new XChartPanel(chartMax);
		xpanelMax.setBackground(new Color(255, 255, 255));
		xpanelMax.setLayout(new GridLayout(1, 1, 0, 0));

		panelCenter.add(xpanelMax);
		
		// Bid chart
		@SuppressWarnings("rawtypes")
		Chart chartBid = new CompareChart(dataModel.getStock(), CompareChart.BID).getChart();		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		XChartPanel xpanelBid = new XChartPanel(chartBid);
		xpanelBid.setBackground(new Color(255, 255, 255));
		xpanelBid.setLayout(new GridLayout(1, 1, 0, 0));
		
		panelCenter.add(xpanelBid);		
		
		// Minimum price chart
		@SuppressWarnings("rawtypes")
		Chart chartMin = new CompareChart(dataModel.getStock(), CompareChart.MIN_PRICE).getChart();		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		XChartPanel xpanelMin = new XChartPanel(chartMin);
		xpanelMin.setBackground(new Color(255, 255, 255));
		xpanelMin.setLayout(new GridLayout(1, 1, 0, 0));
		
		panelCenter.add(xpanelMin);
		
		JPanel panelMiddle = new JPanel();
		panelMiddle.setBackground(new Color(255, 255, 255));
		panelCenter.add(panelMiddle);
		panelMiddle.setLayout(null);

		JLabel lblMiddleMinValue = new JLabel("Middle Min Value:");
		lblMiddleMinValue.setBounds(10, 11, 204, 21);
		panelMiddle.add(lblMiddleMinValue);
		lblMiddleMinValue.setForeground(SystemColor.controlDkShadow);
		lblMiddleMinValue.setFont(new Font("SansSerif", Font.BOLD, 16));

		JLabel lblMiddleMaxValue = new JLabel("Middle Max Value:");
		lblMiddleMaxValue.setBounds(10, 40, 148, 21);
		panelMiddle.add(lblMiddleMaxValue);
		lblMiddleMaxValue.setForeground(SystemColor.controlDkShadow);
		lblMiddleMaxValue.setFont(new Font("SansSerif", Font.BOLD, 16));

		JLabel lblMiddleBid = new JLabel("Middle Bid:");
		lblMiddleBid.setBounds(10, 68, 96, 21);
		panelMiddle.add(lblMiddleBid);
		lblMiddleBid.setForeground(SystemColor.controlDkShadow);
		lblMiddleBid.setFont(new Font("SansSerif", Font.BOLD, 16));

		JLabel lblMin = new JLabel(String.valueOf(dataModel.getMiddleMinPrice()));
		lblMin.setForeground(new Color(0, 100, 0));
		lblMin.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMin.setBounds(157, 14, 103, 14);
		panelMiddle.add(lblMin);

		JLabel lblMax = new JLabel(String.valueOf(dataModel.getMiddleMaxPrice()));
		lblMax.setForeground(new Color(0, 100, 0));
		lblMax.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMax.setBounds(157, 43, 103, 14);
		panelMiddle.add(lblMax);

		JLabel lblBid = new JLabel(String.valueOf(dataModel.getMiddleBid()));
		lblBid.setForeground(new Color(0, 100, 0));
		lblBid.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblBid.setBounds(157, 71, 103, 14);
		panelMiddle.add(lblBid);

		contentPane.validate();
		contentPane.repaint();
	}

	@SuppressWarnings("unchecked")
	private void newFilter(JTextField filter, int col) {
		RowFilter<Object, Object> rowFilter = RowFilter.regexFilter(
				filter.getText(), col);
		((DefaultRowSorter<StockTableModel, Integer>) tableStock.getRowSorter())
				.setRowFilter(rowFilter);
	}
}
