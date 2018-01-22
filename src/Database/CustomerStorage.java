package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ModelLayer.Customer;

public class CustomerStorage {

	private DBConnector dbCon;

	public CustomerStorage() {
		dbCon = new DBConnector();
	}

	public boolean saveCustomer(Customer customer) throws SQLException {

		try (Connection connection = dbCon.createConnection()) {
			final String sql = " insert into customer (id, name, address, zip, city, phone, type)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement preparedStmt = connection.prepareStatement(sql)) {
				preparedStmt.setInt(1, customer.getAccId());
				preparedStmt.setString(2, customer.getName());
				preparedStmt.setString(3, customer.getAddress());
				preparedStmt.setString(4, customer.getZip());
				preparedStmt.setString(5, customer.getCity());
				preparedStmt.setString(6, customer.getPhone());
				preparedStmt.setString(7, customer.getType());

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
