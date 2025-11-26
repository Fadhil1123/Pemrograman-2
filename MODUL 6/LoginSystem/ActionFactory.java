package LoginSystem;

public interface ActionFactory {
    MenuAction create(int actionKey);

    class Default implements ActionFactory {
        private final AccountFacade facade;
        private final ConsoleIO io;

        public Default(AccountFacade facade, ConsoleIO io) {
            this.facade = facade;
            this.io = io;
        }

        @Override
        public MenuAction create(int actionKey) {
            switch (actionKey) {
                case 1: return new RegistrationAction(facade, io);
                case 2: return new LoginAction(facade, io);
                case 3: return new ListUserAction(facade, io);
                default: return null;
            }
        }
    }
}
