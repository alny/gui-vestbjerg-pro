package TestGUI;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

import ModelLayer.Account;

public class CustomerTableModel extends AbstractTableModel {

	private Map<String, Account> db;
	public final String columnNames[] = new String[] { "Navn", "Addresse", "Post Nr", "By", "Telefon" };

	public void setData(Map<String, Account> db) {
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

	public String removeRow(int row) {
		fireTableRowsDeleted(row, row);
		String[] accountIdArray = db.keySet().toArray(new String[db.keySet().size()]);
		Account customer = db.get(accountIdArray[row]);
		return customer.getPhone();
	}

	@Override
	public Object getValueAt(int row, int col) {

		String[] accountIdArray = db.keySet().toArray(new String[db.keySet().size()]);
		Account customer = db.get(accountIdArray[row]);
		switch (col) {
		case 0:
			return customer.getName();
		case 1:
			return customer.getAddress();
		case 2:
			return customer.getZip();
		case 3:
			return customer.getCity();
		case 4:
			return customer.getPhone();
		}

		return null;
	}

}
