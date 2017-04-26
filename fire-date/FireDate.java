/*
 * This should find the point where the investment
 * account balances is 25 times annual expenses (4%
 * withdrawal rate) plus the balance of the loan
 * accounts.
 *
 * Example:
 * $10,000 annual expenses and a $7,777 remaing loan
 * balance
 * $257,777 required to FIRE.
 *
 * Because the loan balance continues to go down, the
 * total amount required also shrinks as time moves
 * on.
 */
import java.math.BigDecimal;

public class FireDate {
    public static void main(String[] args) {
	final BigDecimal investMultiplier = new BigDecimal("25");
	BigDecimal annualExpenses;
	BigDecimal noLoanInvestmentBase;
	BigDecimal currentNeed;
	BigDecimal currentHave;
	int month;
	int i;
	InterestAccount[] accounts;

	// CONFIGURATION AREA

	// Annual Expenses
	annualExpenses = new BigDecimal("30000.00");

	// Configure accounts here
	accounts = new InterestAccount[3];
	accounts[0] = new InterestAccount("23000","0.07","900");
	accounts[1] = new InterestAccount("35000","0.032","220");

	accounts[2] = new InterestAccount("171000","0.0325","800");
	accounts[2].makeLoan();

	// Below here is all the working code.
	noLoanInvestmentBase = annualExpenses.multiply(investMultiplier);

	for(month = 0; month <= 360; ++month) {
	    currentNeed = noLoanInvestmentBase;
	    currentHave = new BigDecimal("0");
	    System.out.print(month);
	    System.out.print(": ");
	    for(i = 0; i < accounts.length; ++i) {
		accounts[i].compound();
		if( accounts[i].isLoan() ) {
		    currentNeed = currentNeed.add(accounts[i].getBalance());
		} else {
		    currentHave = currentHave.add(accounts[i].getBalance());
		}
		System.out.print("$" + accounts[i]);
		System.out.print("\t");
	    }

	    // Print 2 lines
	    System.out.println("\n");

	    if( currentHave.compareTo(currentNeed) >= 0 ) {
		System.out.println("We have enough to retire!\n");
		break;
	    }
	}

    }
}
