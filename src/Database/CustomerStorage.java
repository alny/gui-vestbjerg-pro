package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ModelLayer.Account;
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

	public Map<String, Account> getCustomers() {
		HashMap<String, Account> customers = new HashMap<>();

		try (Connection connection = dbCon.createConnection()) {
			final String sql = "SELECT * FROM CUSTOMER";

			try (PreparedStatement preparedStmt = connection.prepareStatement(sql)) {

				try (ResultSet rs = preparedStmt.executeQuery()) {
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String address = rs.getString("address");
						String zip = rs.getString("zip");
						String city = rs.getString("city");
						String phone = rs.getString("phone");
						String type = rs.getString("type");

						Account customer = new Customer(name, address, zip, city, phone, type);
						customers.put(customer.getPhone(), customer);
						

					}
				} catch (Exception e) {
					System.out.println(e);
				}
			
				return customers;

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public Account findAccount(String getPhone) throws NullPointerException {

		try (Connection connection = dbCon.createConnection()) {
			final String sql = "SELECT * FROM CUSTOMER WHERE phone = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, getPhone);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String address = rs.getString("address");
					String zip = rs.getString("zip");
					String city = rs.getString("city");
					String phone = rs.getString("phone");
					String type = rs.getString("type");
					Account customer = new Customer(name, address, zip, city, phone, type);
				
					return customer;
					
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public void deleteAccount(String getPhone) throws NullPointerException {

		try (Connection connection = dbCon.createConnection()) {
			final String sql = "DELETE FROM CUSTOMER WHERE phone = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, getPhone);
			statement.executeUpdate();		

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String updatePhone(String getPhone, String newPhone) throws NullPointerException {

		try (Connection connection = dbCon.createConnection()) {
			final String sql = "UPDATE customer set phone = ? WHERE phone = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newPhone);
			statement.setString(2, getPhone);
			statement.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
