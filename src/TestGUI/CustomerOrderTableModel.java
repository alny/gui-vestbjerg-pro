package TestGUI;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

import ModelLayer.Order;

public class CustomerOrderTableModel extends AbstractTableModel {

	private Map<Integer, Order> db;
	public final String columnNames[] = new String[] { "Ordre ID", "Date", "Total Price", "Betalt"};

	public void setData(Map<Integer, Order> db) {
		this.db = db;
	}

	public String getColumnName(int columnIndex) {
		return (columnIndex < columnNames.length) ? columnNames[columnIndex] : null;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	public int removeRow(int row) {
		fireTableRowsDeleted(row, row);
		Integer[] accountIdArray = db.keySet().toArray(new Integer[db.keySet().size()]);
		Order order = db.get(accountIdArray[row]);
		return order.getId();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Integer[] accountIdArray = db.keySet().toArray(new Integer[db.keySet().size()]);
		Order order = db.get(accountIdArray[row]);
		switch (col) {
		case 0:
			return order.getId();
		case 1:
			return order.getDate();
		case 2:
			return order.getTotalPrice();
		case 3:
			return order.getbetalt();
		
		}

		return null;
	}

}
