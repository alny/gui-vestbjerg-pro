package ControllerLayer;

import java.sql.SQLException;
import java.util.Map;

import Database.CustomerStorage;
import ModelLayer.Account;
import ModelLayer.AccountContainer;
import ModelLayer.Customer;
import ModelLayer.Loan;
import ModelLayer.Order;

/**
 * Lav en beskrivelse af klassen CustomerController her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class AccountController {
	private AccountContainer accountContainer;
	private CustomerStorage customerStorage;

	/**
	 * Konstruktør for objekter af klassen CustomerController
	 */
	public AccountController() {
		accountContainer = AccountContainer.getInstance();
		customerStorage = new CustomerStorage();
	}

	public String updatePhone(String phone, String newPhone) {
		return accountContainer.updatePhone(phone, newPhone);
	}
	
	public String updateDBPhone(String phone, String newPhone) {
		return customerStorage.updatePhone(phone, newPhone);
	}

	public String updateAddress(String phone, String newAddress) {
		return accountContainer.updateaddress(phone, newAddress);
	}
	
	public String createDBAccount(String name, String address, String zip, String city, String phone, String type) throws SQLException {
		Customer customer = new Customer(name, address, zip, city, phone, type);
		System.out.println(name + address + zip + city + phone);
		customerStorage.saveCustomer(customer);
		return "Succes: konto oprettet";
	}

	public String createAccount(String name, String address, String zip, String city, String phone, String type) {
		Account customer = new Customer(name, address, zip, city, phone, type);
		accountContainer.addAccount(customer);
		return "Succes: konto oprettet";
	}

	public Account findCustomer(String phone) {
		return accountContainer.findAccount(phone);
	}
	
	public Account findDBCustomer(String phone) {
		return customerStorage.findAccount(phone);
	}
	
	public Map<String, Account> getDBCustomers() {
		return customerStorage.getCustomers();
	}

	public Map<String, Account> getCustomers() {
		return accountContainer.getAccounts();
	}
	
	public Map<String, Account> getAccountsWithLoan() {
		return accountContainer.getAccountsWithLoan();
	}

	public void removeAccount(String phone) {
		accountContainer.removeAccount(phone);
	}
	
	public void removeDBAccount(String phone) {
		customerStorage.deleteAccount(phone);
	}

	public void addOrder(String phone, Order order) {
		accountContainer.addOrder(phone, order);

	}

	public void addLoan(String phone, Loan loan) {
		accountContainer.addLoan(phone, loan);
	}

	public double getReceivable(String phone) {
		return accountContainer.customerReceivable(phone);
	}

	/**
	 * opretter dummy accounts
	 * @throws SQLException 
	 */
	public void createdummydata() throws SQLException {
		Integer i = 1;
		int index = 0;
		String k = "1";

		while (index < 10) {

			createDBAccount("Lars", "Larsvej 1", "9000", "Aalborg", k, "type");
			i++;
			k = i.toString();
			index++;
		}
	}

	public void setDiscount(String phone, double s) {
		accountContainer.setDiscount(phone, s);
	}

	public double getDiscount(String phone) {
		return accountContainer.getDiscount(phone);
	}
	public Map<Integer,Order> getOrders(String phone){
		return accountContainer.getOrders(phone);
	}
	public void setName(String phone, String name) {
		accountContainer.setName(phone, name);
	}
	public void setAdress(String phone, String adress) {
		accountContainer.setAdress(phone, adress);
	}
	public void setZip(String phone, String zip) {
		accountContainer.setZip(phone, zip);
	}
	public void setCity(String phone, String city) {
		accountContainer.setCity(phone, city);
	}
	public void setPhone(String phone, String newPhone) {
		accountContainer.setPhone(phone, newPhone);
	}
}