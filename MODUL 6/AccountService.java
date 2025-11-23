package LoginSystem;
import java.util.*;

public interface AccountService {
    List<String> ListUsernames();
    AccountRepository.Account authenticate(String username, String password);
    public void register(String uername, String password);
}
