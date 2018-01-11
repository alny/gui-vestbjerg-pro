package ModelLayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class AccountContainer {

    // Instance variables
    private HashMap<String, Account> accountMap;
    public static AccountContainer instance;

    //Initialize constructor
    private AccountContainer(){
        accountMap = new HashMap<String, Account>();
    }

    // Create or return Singleton
    /**
     * laver en AccountContainer hvis en ikke eksistere og returnere den
     * @return AccountContainer
     */
    public static AccountContainer getInstance(){
        if(instance == null){
            instance = new AccountContainer();
        }
        return instance;
    }
    
    public Map<String, Account> getAccounts(){
   	 return accountMap;
    }
    
    public Map<String, Account> getAccountsWithLoan(){
    	
    	Map<String, Account> accountWithLoanMap = new HashMap<String, Account>();
//    	System.out.println(accountMap);
    	for (Map.Entry<String, Account> entry : accountMap.entrySet()) {
    		System.out.println(entry.getValue().getLoans());
    		if(entry.getValue().getLoans().isEmpty() == false) {
    			
    			accountWithLoanMap.put(entry.getKey(), entry.getValue());
    			
    		}
    	}
      	 return accountWithLoanMap;
      	 
       }
       
    
    public void removeAccount(String phone) {
    	accountMap.remove(phone);
    }

    /**
     * tilf�jer en konto til accounts hashmap 
     * @param Account account
     */ public void addAccount(Account account){
        accountMap.put(account.getPhone(), account);
    }

    /**
     * henter en account p� phone og returnerer den
     * @param String phone
     * @return account 
     */
    public Account findAccount(String phone) throws NullPointerException {
        Account findCustomer = accountMap.get(phone);
        if(findCustomer == null){
            throw new NullPointerException("Kunde kan ikke findes.");
        }
        return findCustomer;
    }

    /**
     * Vigitig funktion - Vi bruger den som key til at store vores values i HashMappet
     * henter en account p� phone
     * fjerne eksisterende phone og s�tter newPhone
     * @param String newPhone bliver til phone
     * @return String bekr�ftelse af opdatering
     */
    public String updatePhone(String phone, String newPhone)  {
        Account a = findAccount(phone);
        accountMap.remove(phone);
        a.setPhone(newPhone);
        addAccount(a);
        return "Telefonnr. opdateret";
    }

    public String updateaddress(String phone, String newAddress){
        findAccount(phone).setAddress(newAddress);
        return "Adresse opdateret";
    }
    
    /**
     * tilf�jer en order til en account som hentes p� phone 
     * @param String phone og Order order
     */
    public void addOrder(String phone,Order order){
        findAccount(phone).addOrder(order);
    }

    /**
     * tilf�jer et l�n til en account som hentes p� phone 
     * @param Loan loan og String phone 
     */
    public void addLoan(String phone, Loan loan){
        accountMap.get(phone).addLoan(loan);
    }

    /**
     * se costumerRecieveable i Account
     */
    public double customerReceivable(String phone){
        return findAccount(phone).customerReceivable();
    }
    
    public double getDiscount(String phone){
      return accountMap.get(phone).getDiscount();    
    }
    
    public void setDiscount(String phone, double s){
      accountMap.get(phone).setDiscount(s);    
    }
    public Map<Integer,Order> getOrders(String phone){
    	return accountMap.get(phone).getorders();
    }
    
    public void setName(String phone, String name) {
    	findAccount(phone).setName(name);
    }
    
    public void setAdress(String phone, String adress) {
    	findAccount(phone).setAddress(adress);
    }
    public void setZip(String phone, String zip) {
    	
    	findAccount(phone).setZip(zip);
    }
    
    public void setCity(String phone, String city) {
    	
    	findAccount(phone).setCity(city);
    }
    public void setPhone(String phone, String newPhone) {
    	findAccount(phone).setPhone(newPhone);
    }
}

