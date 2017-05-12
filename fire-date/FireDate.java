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
	final double investMultiplier = 25;
	double annualExpenses;
	double noLoanInvestmentBase;
	double currentNeed;
	double currentHave;
	double pension;
	double needAtRetirement;
	int month;
	int monthsUntilRetirement;
	int i;
	InterestAccount[] accounts;

	// CONFIGURATION AREA

	// Annual Expenses
	annualExpenses = 30000.00;
	monthsUntilRetirement = 340;

	// Configure accounts here
	accounts = new InterestAccount[3];
	accounts[0] = new InterestAccount("23000","0.07","900");
	accounts[1] = new InterestAccount("35000","0.032","220");

	accounts[2] = new InterestAccount("171000","0.0325","800");
	accounts[2].makeLoan();

	// Below here is all the working code.
	noLoanInvestmentBase = annualExpenses * investMultiplier;

	for(month = 0; month <= 360; ++month) {

	    monthsUntilRetirement--;
	    if( monthsUntilRetirement < 0 ) {
		monthsUntilRetirement = 0;
	    }
	    pension = 46000 * 0.016 * (12 + month/12);
	    needAtRetirement = (annualExpenses - pension) * investMultiplier;
	    
	    currentNeed = noLoanInvestmentBase;
	    currentHave = 0.0;
	    System.out.print(month);
	    System.out.print(": ");
	    for(i = 0; i < accounts.length; ++i) {
		accounts[i].compound();
		if( accounts[i].isLoan() ) {
		    currentNeed += accounts[i].toDouble();
		} else {
		    currentHave += accounts[i].toDouble();
		}
		System.out.print("$" + accounts[i]);
		System.out.print("\t");
	    }

	    // Print 2 lines
	    System.out.println("\n");
	    
	    if( currentHave > needAtRetirement ) {
		double currentPay = 12;
		currentPay *= glideDown( (currentHave - needAtRetirement),
					 0.04,
					 monthsUntilRetirement);
		currentPay += needAtRetirement * 0.04;
		if( currentPay > annualExpenses ) {
		    System.out.println("We have enough to glide to retirement!\n");
		    System.out.println("Pension: " + pension);
		    System.out.println("Excess: " + (currentHave - needAtRetirement));
		    System.out.println("Remaining: " + needAtRetirement);
		    System.out.println("Months to pension: " + monthsUntilRetirement);
		    break;
		}
	    }

	    if( currentHave >= currentNeed ) {
		System.out.println("We have enough to retire!\n");
		break;
	    }
	}

    }

    /*
     * Since we need less at retirement, this
     * sees how much we can spend down if we want
     * to "retire" early.
     */
    private static double glideDown(double principal, double rate, int months) {
	double monthlyRate = rate  / 12;
	return (principal *
		( monthlyRate /
		  (1 - Math.pow(1 + monthlyRate,(-months)))));
    }
    
}
