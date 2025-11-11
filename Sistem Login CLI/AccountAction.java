package LoginSystem;

public abstract class AccountAction implements MenuAction {
    protected String actionname;

    @Override
    public abstract String getActionName();

    @Override
    public abstract void execute(AccountList list, InputHandler handler);

    public void showHeader(InputHandler handler) {
        System.out.println("======" + getActionName() + "======");
    }
}
