package TestGUI;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

import ModelLayer.Account;
import ModelLayer.Product;

public class ProductTableModel extends AbstractTableModel {

	private Map<Integer, Product> db;
	public final String columnNames[] = new String[] { "Stregkode", "Navn", "Beskrivelse", "Pris", "Antal", "Min", "Max" };

	public void setData(Map<Integer, Product> db) {
		this.db = db;
	}
	

	public String getColumnName(int columnIndex) {
		return (columnIndex < columnNames.length) ? columnNames[columnIndex] : null;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	public int removeRow(int row) {
		fireTableRowsDeleted(row, row);
		Integer[] accountIdArray = db.keySet().toArray(new Integer[db.keySet().size()]);
		Product product = db.get(accountIdArray[row]);
		return product.getBarcode();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Integer[] productIdArray = db.keySet().toArray(new Integer[db.keySet().size()]);
		
		Product product = db.get(productIdArray[row]);

		switch (col) {
		case 0:
			return product.getBarcode();
		case 1:
			return product.getName();
		case 2:
			return product.getDescription();
		case 3:
			return product.getPrice();
		case 4:
			return product.getAmount();
		case 5:
			return product.getMinAmount();
		case 6:
			return product.getMaxAmount();
		}

		return null;
	}

}
