package TH12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class SimpleArrayTableModel extends AbstractTableModel  {

	/**
	 * Table model
	 */
	private static final long serialVersionUID = 1L;
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	private List<String> dataSet;

	public SimpleArrayTableModel(List<String> data) {
		this.dataSet = data;
	}

	@Override
	public int getRowCount() {
		return dataSet.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:	
			return "Index";
		case 1:
			return "Data";
		}
		
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return rowIndex;
		case 1:
			return dataSet.get(rowIndex);
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

    public void addRow(String rowIns) { 
        int rowCount = getRowCount() + 1;
         
        dataSet.add(rowIns);
        fireTableRowsInserted(rowCount, rowCount);
    } 
    
    
}
