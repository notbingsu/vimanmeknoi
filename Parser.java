public class Parser {
    private UI ui;

    public Parser() {
    }

    private class InvalidCommandException extends Exception {
        public InvalidCommandException(String errorMessage) {
            super(errorMessage);
        }
    }

    public void parse(String input) {
        // try to parse the input, if not possible, throw exception
        try {
            parseMainCommand(input);
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }

    private void parseMainCommand(String input) throws InvalidCommandException {
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
                throw new InvalidCommandException(
                        "Invalid command. Type 'help' to see the list of available features.");
        }
    }

    private void parseAccountCommand(String input) {

    }
}
