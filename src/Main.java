package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UI.printIntro();
        Storage storage = new Storage();
        storage.loadFile();
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser(sc);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            input = input.toLowerCase();
            if (input.equals("bye")) {
                storage.saveFile(AccountManager.getAccounts());
                UI.printBye();
                break;
            } else {
                parser.parse(input);
                // System.out.println("page: " + parser.ParserState);
                UI.printLineBreak();
            }
        }
    }
}
