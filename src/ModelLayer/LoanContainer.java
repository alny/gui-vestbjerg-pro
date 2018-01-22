package ModelLayer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Loancontainer st�r for at holde alle l�n, s�ge igennem dem og lave l�n.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoanContainer {
	private HashMap<Integer, Loan> loan;
	private static LoanContainer instance;

	/**
	 * Constructor for objects of class LoanContainer
	 */
	private LoanContainer() {
		loan = new HashMap<Integer, Loan>();
	}

	/**
	 * laver en LoanContainer hvis der ikke er en og returnerer den nye eller den
	 * ekstisterende
	 */
	public static LoanContainer getInstance() {
		if (instance == null) {
			instance = new LoanContainer();
		}
		return instance;
	}

	/**
	 * tilf�jer et l�n til containerens hashmap
	 * 
	 * @param Loan
	 *            loan
	 */
	public void addLoan(Loan loan) {
		this.loan.put(loan.getId(), loan);
	}

	/**
	 * returnerer et l�n p� id
	 * 
	 * @param id
	 *            p� l�net
	 */
	public void returnLoan(Loan loan) {
		this.loan.remove(loan.getId(), loan);
	}

	/**
	 * finder et l�n og s�tter status til betalt
	 * 
	 * @param id
	 *            p� l�n
	 * @return String
	 */
	public String payLoan(int id) {
		findLoan(id).pay();
		return "l�n betalt";
	}

	/**
	 * finder et l�n p� id
	 * 
	 * @param id
	 *            p� loan
	 * @return returnerer et l�n objekt
	 */
	public Loan findLoan(int id) {
		return loan.get(id);
	}
	
	

	/**
	 * tilf�jer et item til et l�n p� l�ns id og tager et item objekt
	 * 
	 * @param id
	 *            p� l�n og et item objekt
	 */
	public void addItem(int id, Item item) {
		findLoan(id).addItem(item);
	}

	/**
	 * returnere et item og �ndrer status p� objekt
	 * 
	 * @param id
	 *            p� l�n og serienummer p� et item
	 * @return returnere et item objekt
	 */
	public Item returnItem(int id, int serial) {
		return findLoan(id).returnItem(serial);
	}

	public double getPrice(int id) {
		return findLoan(id).getTotalPrice();
	}
	
	public Date getDate(int id) {
		return findLoan(id).getDate();
	}
	
	public boolean getPaid(int id) {
		return findLoan(id).isPaid();
	}
	
	
	
	
}
