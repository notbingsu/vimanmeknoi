package src;

import java.util.Scanner;

public class Parser {
    private static Scanner parserScanner;
    AccountParser accountParser;

    enum ParserState {
        MAIN, ACCOUNT, INFORMATION, PRODUCT
    }

    private static ParserState parserState;

    public Parser(Scanner sc) {
        accountParser = new AccountParser();
        parserState = ParserState.MAIN;
        parserScanner = sc;
    }

    private class InvalidCommandException extends Exception {
        public InvalidCommandException(String errorMessage) {
            super(errorMessage);
        }
    }

    public void parse(String input) {
        try {
            switch (parserState) {
                case MAIN:
                    parseMainCommand(input);
                    break;
                case ACCOUNT:
                    // accountParser.parseAccountCommand(parserScanner);
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

    private static void parseMainCommand(String input) {
        switch (input) {
            case "help":
                UI.printListOfCommands();
                break;
            case "acc":
                parserState = ParserState.ACCOUNT;
                System.out.println("Accessing account menu...");
                AccountParser.parseAccountCommand(parserScanner);
                break;
            case "inf":
                break;
            case "prd":
                break;
            default:
                System.out.println("Invalid command. Type 'help' to see the list of available features.");
        }
    }

    public static void setParserStatetoMain() {
        parserState = ParserState.MAIN;
    }
}
