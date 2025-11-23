package LoginSystem;

public class ListUserAction extends BaseAction {
    private final AccountService service;

    protected ListUserAction(AccountService service, ConsoleIO io) {
        super("List User", io);
        this.service = service;
    }

    @Override
    public void execute() {
        printHeader();
        var users = service.ListUsernames();
        if(users.isEmpty()){
            io.info("Tidak ada user");
        } else {
            for(int i = 1; i <= users.size(); i++){
                io.info(i + ". " + users.get(i - 1));
            }
        }
        printComplete();
    }
}
