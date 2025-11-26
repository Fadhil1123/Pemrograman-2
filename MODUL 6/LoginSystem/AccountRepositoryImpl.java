package LoginSystem;
import java.util.*;

public class AccountRepositoryImpl implements AccountRepository {
    private final List<Account> accounts = new ArrayList<>();

    @Override
    public synchronized void add(Account account) {
        accounts.add(account);
    }

    @Override
    public synchronized Account findByUsername(String username) {
        return accounts.stream()
                .filter(a -> a.getUsername().equalsIgnoreCase(username))
                .findFirst().orElse(null);
    }

    @Override
    public synchronized List<String> listUsernames() {
        List<String> list = new ArrayList<>();
        for (Account a : accounts) list.add(a.getUsername());
        return Collections.unmodifiableList(list);
    }
}
