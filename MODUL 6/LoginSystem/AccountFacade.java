package LoginSystem;
import java.util.*;

public class AccountFacade {
    private final AccountService service;
    private final ConsoleIO io;

    public AccountFacade(AccountService service, ConsoleIO io) {
        this.service = service;
        this.io = io;
    }

    public void loginFlow(){
        io.header("Login");
        String username = io.ask("Masukkan username : ");
        String password = io.ask("Masukkan password : ");

        var acc = service.authenticate(username, password);
        if(acc == null){
            io.error("Username atau password yang dimasukkan salah");
        } else {
            io.info("Selamat datang " + acc.getUsername());
        }
        io.completeInfo("Login");
    }

    public void registerFlow(){
        io.header("Register");
        String username = io.ask("Masukkan username : ");
        String password = io.ask("Masukkan password : ");
        try{
            service.register(username, password);
            io.info(username + " berhasil registrasi");
        } catch (RuntimeException e) {
            io.error(e.getMessage());
        }
        io.completeInfo("Register");
    }

    public void listUserFlow(){
        io.header("List User");
        List<String> users = service.listUsernames();
        if(users.isEmpty()){
            io.info("Belum ada user");
        } else {
            for (int i = 0; i < users.size(); i++) {
                io.info((i + 1) + ". " + users.get(i));
            }
        }
        io.completeInfo("List User");
    }
}
