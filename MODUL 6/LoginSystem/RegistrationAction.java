package LoginSystem;

public class RegistrationAction extends BaseAction{
    private final AccountFacade facade;

    public RegistrationAction(AccountFacade facade, ConsoleIO io) {
        super("Registrasi", io);
        this.facade = facade;
    }

    @Override
    public void execute() {
        facade.registerFlow();
    }
}
