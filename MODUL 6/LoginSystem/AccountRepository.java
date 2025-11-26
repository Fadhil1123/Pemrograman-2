package LoginSystem;
import java.util.*;

public interface AccountRepository {
    void add(Account account);
    Account findByUsername(String username);
    List<String> listUsernames();
}
