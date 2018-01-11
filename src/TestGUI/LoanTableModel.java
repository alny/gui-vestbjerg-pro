package TestGUI;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

import ModelLayer.Loan;

public class LoanTableModel extends AbstractTableModel {

	private Map<Integer, Loan> db;
	public final String columnNames[] = new String[] { "Id", "Dage", "Retur Dato", "Betalt" };

	public void setData(Map<Integer, Loan> db) {
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
		Loan loan = db.get(accountIdArray[row]);
		return loan.getId();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Integer[] loanIdArray = db.keySet().toArray(new Integer[db.keySet().size()]);
		Loan loan = db.get(loanIdArray[row]);
		switch (col) {
		case 0:
			return loan.getId();
		}

		return null;
	}

}
