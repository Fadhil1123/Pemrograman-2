package LoginSystem;

public class Regist extends AccountAction{

    public Regist() {
        this.actionname = "Registrasi";
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
        if (acc == null) {
            list.addAccount(new Account(username, password));
            handler.show("Akun baru berhasil ditambahkan");
        } else {
            handler.show("Username anda sudah ada");
        }
    }
}