package LoginSystem;

public class Login extends AccountAction {

    public Login(){
        this.actionname = "Login";
    }

    @Override
    public String getActionName() {
        return actionname;
    }

    @Override
    public void execute(AccountList list, InputHandler handler) {
        showHeader(handler);

        String username = handler.ask("Masukkan username anda : ");
        String password = handler.ask("Masukkan password anda : ");

        Account acc = list.findAccount(username);
        if (acc != null && acc.getPassword().equals(password)) {
            handler.show("Login berhasil, selamat datang " + username);
        } else {
            handler.show("Username atau password anda salah");
        }
    }
}