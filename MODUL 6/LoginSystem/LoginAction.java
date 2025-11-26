package LoginSystem;

public class LoginAction extends BaseAction {
    private final AccountFacade facade;

    public LoginAction(AccountFacade facade, ConsoleIO io) {
        super("Login", io);
        this.facade = facade;
    }

    @Override
    public void execute() {
        facade.loginFlow();
    }
}
