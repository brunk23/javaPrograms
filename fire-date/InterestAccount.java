import java.math.BigDecimal;

public class InterestAccount {
    // java.math.BigDecimal
    BigDecimal balance;
    BigDecimal apr;
    BigDecimal payment;
    boolean isLoan;
    int months;

    /*
     * This is the main driving function
     */
    void compound() {
	months++;
	balance = balance.multiply(apr);
	if(isLoan) {
	    subtract();
	} else {
	    add();
	}
    }

    private void add() {
	balance = balance.add(payment);
    }

    private void subtract() {
	balance = balance.subtract(payment);
    }
    
    void makeLoan() {
	isLoan = true;
    }

    void makeInvestment() {
	isLoan = false;
    }

    void setBalance(String newBalance) {
	balance = new BigDecimal(newBalance);
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

    private void createAPR(String value) {
	apr = new BigDecimal(value);
	apr = apr.divide(new BigDecimal("12"), 10, BigDecimal.ROUND_FLOOR);
	apr = apr.add(new BigDecimal("1"));
    }

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
}
