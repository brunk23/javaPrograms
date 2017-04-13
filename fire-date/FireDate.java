

public class FireDate {
    public static void main(String[] args) {
	int month;
	int i;

	InterestAccount[] invest = new InterestAccount[2];
	InterestAccount[] debts = new InterestAccount[1];
	invest[0] = new InterestAccount("23000","0.07","900");
	invest[1] = new InterestAccount("35000","0.032","220");
	debts[0] = new InterestAccount("171000","0.0325","800");
	debts[0].makeLoan();

	for(month = 0; month <= 360; ++month) {
	    System.out.print(month);
	    System.out.print(": ");
	    for(i = 0; i < invest.length; ++i) {
		invest[i].compound();
		System.out.print("$" + invest[i].getBalance());
		System.out.print("\t");
	    }
	    System.out.print("::\t");
	    for(i = 0; i < debts.length; ++i) {
		debts[i].compound();
		System.out.print("$" + debts[i].getBalance());
		System.out.print("\t");
	    }
	    // Print 2 lines
	    System.out.println("\n");
	}

    }
}
