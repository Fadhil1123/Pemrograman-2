package LoginSystem;
import java.security.MessageDigest;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository repo;

    public AccountServiceImpl(AccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<String> ListUsernames() {
        return repo.ListUserNames();
    }

    @Override
    public AccountRepository.Account authenticate(String username, String password) {
        var acc = repo.findByUsername(username);
        return (acc != null && acc.getPasswordHash().equals(hash(password)) ? acc : null);
    }

    @Override
    public void register(String username, String password) {
        if (repo.findByUsername(username) != null){
            throw new RuntimeException("Username already exists");
        }
        repo.add(new AccountRepository.Account(username, hash(password)));
    }

    private String hash(String s){
        try{
            byte[] b = MessageDigest.getInstance("SHA-256").digest(s.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte x : b) sb.append(String.format("%02x", x));
            return sb.toString();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
