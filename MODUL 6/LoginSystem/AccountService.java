package LoginSystem;
import java.util.*;

public interface AccountService {
    Account authenticate(String username, String password);
    void register(String username, String password) throws RuntimeException;
    List<String> listUsernames();
}
