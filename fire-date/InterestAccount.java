import java.math.BigDecimal;

/*
 * A class for accounts that generate interest.
 * These can be loans or investment accounts.
 */
public class InterestAccount {
    private BigDecimal balance;
    private BigDecimal apr;
    private BigDecimal payment;
    private boolean loan;
    private int months;		// unused at the moment

    /*
     * This is the main driving function, as this is the
     * main action an account can perform.
     */
    void compound() {
	months++;

	// Compound the interest
	balance = balance.multiply(apr);

	// Subtract payments from loans, add to investments
	if(loan) {
	    subtract();
	} else {
	    add();
	}
    }

    // Default is to be an investment account. If this is a
    // loan, make the payments come off the balance.
    void makeLoan() {
	loan = true;
    }

    public boolean isLoan() {
	return loan;
    }

    // This is the default behavior. Probably won't need
    // to call this from outside.
    void makeInvestment() {
	loan = false;
    }

    void setBalance(String newBalance) {
	balance = new BigDecimal(newBalance);
    }

    public String toString() {
	return balance.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
    }

    double toDouble() {
	return balance.doubleValue();
    }
    
    BigDecimal getBalance() {
	return balance;
    }	

    void setInterest(String newInterest) {
	createAPR(newInterest);
    }

    BigDecimal getInterest() {
	return apr;
    }

    void setPayment(String newPayment) {
	payment = new BigDecimal(newPayment);
    }

    BigDecimal getPayment() {
	return payment;
    }

    /*
     * These are the constructors for this class
     *
     */
    InterestAccount() {
	makeInvestment();
	balance = new BigDecimal("0.0");
	createAPR("0.0");
	payment = new BigDecimal("0.0");
	months = 0;
    }

    InterestAccount(String newBalance, String newAPR, String newPayment) {
	makeInvestment();
	balance = new BigDecimal(newBalance);
	createAPR(newAPR);
	payment = new BigDecimal(newPayment);
	months = 0;
    }

    InterestAccount(String newBalance, String newAPR) {
	makeInvestment();
	balance = new BigDecimal(newBalance);
	createAPR(newAPR);
	payment = new BigDecimal("0");
	months = 0;
    }

    /*
     * Private internal methods here.
     */
    private void add() {
	balance = balance.add(payment);
    }

    private void subtract() {
	balance = balance.subtract(payment);
    }

    private void createAPR(String value) {
	apr = new BigDecimal(value);
	apr = apr.divide(new BigDecimal("12"), 10, BigDecimal.ROUND_FLOOR);
	apr = apr.add(new BigDecimal("1"));
    }
}
