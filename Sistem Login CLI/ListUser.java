package LoginSystem;

public class ListUser extends AccountAction {

    public ListUser() {
        this.actionname="List User";
    }

    @Override
    public String getActionName() {
        return actionname;
    }

    @Override
    public void execute(AccountList list, InputHandler handler) {
        showHeader(handler);
        int i = 1;
        for(Account acc : list.getAccounts()){
            System.out.println(i + ". " + acc.getUserName());
            i++;
        }
    }
}
