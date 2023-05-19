import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static final String FILE_PATH = "accountsdata.txt";
    Account account = new Account();
    Accounts accounts = new Accounts();

    public Storage() {
    }

    public void loadFile() {
        File file = new File(FILE_PATH);
        String username = "";
        String password = "";
        try {
            if (!file.createNewFile()) {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String data = sc.nextLine();
                    String[] dataArr = data.split(",");
                    username = dataArr[0];
                    password = dataArr[1];
                    account = new Account(username, password);
                    accounts.add(account);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

    }

    public void saveFile(Accounts accounts) {
        try {
            FileWriter Fw = new FileWriter(FILE_PATH);
            Fw.write(writeFile(accounts));
            Fw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    private static String writeFile(Accounts accounts) {
        String output = "";
        for (Account account : accounts) {
            output += account.getUsername() + "," + account.getPassword() + "\n";
        }
        return output;
    }

}
