package LoginSystem;

interface MenuAction {
    void execute(AccountList list, InputHandler handler);
    String getActionName();
}