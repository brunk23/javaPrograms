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
    private final static double investMultiplier = 25;
    private final static double withdrawRate = 0.04;
    private static double annualExpenses;
    private static double noLoanInvestmentBase;
    private static double currentNeed;
    private static double currentHave;
    private static double pension;
    private static double needAtRetirement;
    private static int month;
    private static int monthsUntilRetirement;
    private static int i;
    private static InterestAccount[] accounts;

    private static void setup() {
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
    }
    
    
    public static void main(String[] args) {
	setup();

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
		if( coastingTime() ) {
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
     * We're going to move this to it's own method. Cleans things up.
     */
    private static boolean coastingTime() {
	double currentPay = 12;
	double loanBalance = (currentNeed - noLoanInvestmentBase);
	currentPay *= glideDown( (currentHave - needAtRetirement -
				  loanBalance),
				 0.04,
				 monthsUntilRetirement);
	currentPay += needAtRetirement * 0.04;
	if( currentPay > annualExpenses ) {
	    System.out.println("We have enough to glide to retirement!\n");
	    System.out.println("Pension: " + pension);
	    System.out.println("Excess: " +
			       (currentHave -
				needAtRetirement -
				loanBalance));
	    System.out.println("Loan Balance: " + loanBalance);
	    System.out.println("Remaining: " + needAtRetirement);
	    System.out.println("Months to pension: " +
			       monthsUntilRetirement);
	    return true;
	}
	return false;
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
