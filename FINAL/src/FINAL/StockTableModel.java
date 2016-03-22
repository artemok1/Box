package FINAL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class StockTableModel extends AbstractTableModel {

	/**
	 * Table model
	 */
	private static final long serialVersionUID = 1L;
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	private ArrayList<Stock> dataSet;

	public StockTableModel(ArrayList<Stock> data) {
		this.dataSet = data;
	}

	@Override
	public int getRowCount() {
		return dataSet.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "ID";
		case 1:
			return "Name";
		case 2:
			return "Bid";
		case 3:
			return "Min Price";
		case 4:
			return "Max Price";
		case 5:
			return "Visible";
		}

		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return Double.class;
		case 3:
			return Double.class;
		case 4:
			return Double.class;
		case 5:
			return Boolean.class;
		}

		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return dataSet.get(rowIndex).getId();
		case 1:
			return dataSet.get(rowIndex).getName();
		case 2:
			return dataSet.get(rowIndex).getBid();
		case 3:
			return dataSet.get(rowIndex).getMinPrice();
		case 4:
			return dataSet.get(rowIndex).getMaxPrice();
		case 5:
			return dataSet.get(rowIndex).isVisible();
		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}
}
