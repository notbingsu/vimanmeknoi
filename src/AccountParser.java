package src;

import java.util.Scanner;

public class AccountParser {
    public AccountParser() {
        accountHandlers = AccountHandlers.ACC;
    }

    enum AccountHandlers {
        ACC,
        LOGIN,
        LOGOUT,
        CREATE,
        DELETE,
        EDIT
    }

    private static AccountHandlers accountHandlers;

    public static void parseAccountCommand(Scanner accountScanner) {
        String input = accountScanner.nextLine();
        switch (input) {
            case "login":
                accountHandlers = AccountHandlers.LOGIN;
                parseLogin(accountScanner);
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
                Parser.setParserStatetoMain();
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid command. Type 'acc' to return to main menu.");
        }
    }

    private static void parseLogin(Scanner accountScanner) {
        String username, password;
        System.out.println("Enter username: ");
        username = accountScanner.nextLine();
        System.out.println("Enter password: ");
        password = accountScanner.nextLine();
        AccountManager.login(username, password);
    }

}
