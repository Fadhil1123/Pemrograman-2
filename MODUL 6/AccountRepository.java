package LoginSystem;
import java.util.*;

public class AccountRepository {
    private final List<Account> accounts = new ArrayList<>();

    public static class Account{
        private String username;
        private String passwordHash;
        public Account(String username, String passwordHash){
            this.username = username;
            this.passwordHash = passwordHash;
        }

        public String getUsername(){
            return username;
        }

        public String getPasswordHash(){
            return passwordHash;
        }
    }

    public synchronized void add(Account acc){
        accounts.add(acc);
    }

    public synchronized Account findByUsername(String u){
        return accounts.stream().filter(a -> a.getUsername().equalsIgnoreCase(u))
                .findFirst().orElse(null);
    }

    public synchronized List<String> ListUserNames(){
        return accounts.stream().map(Account::getUsername).toList();
    }

}
