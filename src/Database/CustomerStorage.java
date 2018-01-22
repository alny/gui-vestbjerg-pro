package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ModelLayer.Account;

public class CustomerStorage {

	private DBConnector dbCon;

	public CustomerStorage() {
		dbCon = new DBConnector();
	}

	public boolean saveCustomer(Account account) throws SQLException {

		try (Connection connection = dbCon.createConnection()) {
			final String sql = " insert into customer (id, name, address, zip, city, phone)"
					+ " values (?, ?, ?, ?, ?, ?)";
			try (PreparedStatement preparedStmt = connection.prepareStatement(sql)) {
				preparedStmt.setInt(1, account.getAccId());
				preparedStmt.setString(2, account.getName());
				preparedStmt.setString(3, account.getAddress());
				preparedStmt.setString(4, account.getZip());
				preparedStmt.setString(5, account.getCity());
				preparedStmt.setString(6, account.getPhone());

				preparedStmt.execute();
				connection.close();

				return true;

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

}
