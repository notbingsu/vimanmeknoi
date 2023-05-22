package src;

import java.util.Scanner;

public class AccountParser {
    public AccountParser() {
    }

    public static void parseAccountCommand(Scanner accountScanner) {
        String input = "";
        while (!input.equals("acc")) {
            input = accountScanner.nextLine();
            switch (input) {
                case "login":
                    parseLogin(accountScanner);
                    break;
                case "logout":
                    break;
                case "create":
                    parserCreateAccount(accountScanner);
                    break;
                case "delete":
                    break;
                case "edit":
                    break;
                case "acc":
                    Parser.setParserStatetoMain();
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid command. Type 'acc' to return to main menu.");
            }
        }
    }

    private static void parseLogin(Scanner accountScanner) {
        String username, password;
        System.out.println("Enter username: ");
        username = accountScanner.nextLine();
        System.out.println("Enter password: ");
        password = accountScanner.nextLine();
        AccountManager.accountLogin(username, password);
    }

    private static void parserCreateAccount(Scanner accountScanner) {
        String username, password;
        System.out.println("Enter username: ");
        username = accountScanner.nextLine();
        System.out.println("Enter password: ");
        password = accountScanner.nextLine();
        AccountManager.createAccount(username, password);
    }

}
