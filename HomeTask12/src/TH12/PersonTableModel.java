package TH12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel  {

	/**
	 * Table model
	 */
	private static final long serialVersionUID = 1L;
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	public ArrayList<Person> dataSet;

	public PersonTableModel(HashMap<String, ArrayList<Person>> data, String type) {
		this.dataSet = data.get(type);
	}

	@Override
	public int getRowCount() {
		return dataSet.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:	
			return "ID";
		case 1:
			return "Surname";
		case 2:
			return "Name";
		case 3:
			return "Middle Name";			
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
			return dataSet.get(rowIndex).getId();
		case 1:
			return dataSet.get(rowIndex).getSurname();
		case 2:
			return dataSet.get(rowIndex).getName();
		case 3:
			return dataSet.get(rowIndex).getMidleName();			
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
         
//        dataSet.add(rowIns);
        fireTableRowsInserted(rowCount, rowCount);
    } 
    
    
}
