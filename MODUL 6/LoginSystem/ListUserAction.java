package LoginSystem;

public class ListUserAction extends BaseAction {
    private final AccountFacade facade;

    public ListUserAction(AccountFacade facade, ConsoleIO io) {
        super("List User", io);
        this.facade = facade;
    }

    @Override
    public void execute() {
        facade.listUserFlow();
    }
}
