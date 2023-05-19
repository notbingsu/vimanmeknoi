package src;

public class Parser {
    private UI ui;
    private static AccountManager accountManager;

    enum ParserState {
        MAIN, ACCOUNT, INFORMATION, PRODUCT
    }

    ParserState ParserState;

    public Parser() {
        ui = new UI();
        accountManager = new AccountManager();
        ParserState = ParserState.MAIN;
    }

    private class InvalidCommandException extends Exception {
        public InvalidCommandException(String errorMessage) {
            super(errorMessage);
        }
    }

    public void parse(String input) {
        try {
            switch (ParserState) {
                case MAIN:
                    parseMainCommand(input);
                    break;
                case ACCOUNT:
                    parseAccountCommand(input);
                    break;
                case INFORMATION:
                    // parseInformationCommand(input);
                    break;
                case PRODUCT:
                    // parseProductCommand(input);
                    break;
                default:
                    throw new InvalidCommandException(
                            "Invalid command. Type 'help' to see the list of available features.");
            }
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }

    private void parseMainCommand(String input) {
        switch (input) {
            case "help":
                ui.printListOfCommands();
                break;
            case "acc":
                parseAccountCommand(input);
                break;
            case "inf":
                break;
            case "prd":
                break;
            default:
                System.out.println("Invalid command. Type 'help' to see the list of available features.");
        }
    }

    private void parseAccountCommand(String input) {
        switch (input) {
            case "login":

                break;
            case "logout":
                break;
            case "create":
                break;
            case "delete":
                break;
            case "edit":
                break;
            case "acc":
                ParserState = ParserState.MAIN;
                break;
            default:
                System.out.println("Invalid command. Type 'acc' to return to main menu.");
        }
    }

}
