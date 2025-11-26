package LoginSystem;
import java.util.*;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository repo;

    public AccountServiceImpl(AccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public Account authenticate(String username, String password) {
        var acc = repo.findByUsername(username);
        return (acc != null && acc.getPassword().equals(password)) ? acc : null;
    }

    @Override
    public void register(String username, String password) {
        if(repo.findByUsername(username) != null)
            throw new RuntimeException("Username sudah ada");
        repo.add(new Account(username, password));
    }

    @Override
    public List<String> listUsernames() {
        return repo.listUsernames();
    }
}
