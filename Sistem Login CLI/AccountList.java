package LoginSystem;
import java.util.ArrayList;

public class AccountList {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String username) {
        for (Account acc : accounts) {
            if(acc.getUserName() .equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
