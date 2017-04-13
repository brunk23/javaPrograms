

public class FireDate {
    public static void main(String[] args) {
	InterestAccount saving = new InterestAccount();
	InterestAccount checking = new InterestAccount("1000","0.3","50");
	saving.setBalance("500");
	saving.setInterest(".07");
	checking.makeLoan();

	System.out.println(checking.getBalance());
	checking.compound();
	System.out.println(checking.getBalance());
	checking.compound();
	System.out.println(checking.getBalance());
    }
}
