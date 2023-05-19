package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            input = input.toLowerCase();
            if (input.equals("bye")) {
                ui.printBye();
                break;
            } else {
                parser.parse(input);
                ui.printLineBreak();
            }
        }
    }
}
