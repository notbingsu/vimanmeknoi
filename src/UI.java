package src;

public class UI {

    public UI() {
        printIntro();
    }

    private final void printIntro() {
        System.out.println("Welcome to Hoontrakul! \n What can I help you with today?"
                + "\n Type 'help' to see the list of available features.");
        this.printLineBreak();
    }

    public final void printBye() {
        System.out.println("Bye. Hoontrakul hopes to see you again soon!");
    }

    public final void printListOfCommands() {
        System.out.println("Here are the list of available features: \n"
                + "1. account (acc)\n"
                + "2. info (inf)\n"
                + "3. products (prd)\n"
                + "Type the (code) of the option you wish to access: ");
    }

    public final void printLineBreak() {
        System.out.println("------------------------------------------------------------");
    }

}
