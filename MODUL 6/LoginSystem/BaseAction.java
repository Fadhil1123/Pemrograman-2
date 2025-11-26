package LoginSystem;

public abstract class BaseAction implements MenuAction {
    protected final String title;
    protected final ConsoleIO io;

    protected BaseAction(String title, ConsoleIO io) {
        this.title = title;
        this.io = io;
    }

    @Override
    public String name() {
        return title;
    }
}
