package src;

import java.util.HashMap;

public class AccountManager {
    // create hashmap of username to account
    private HashMap<String, Account> accountsHashMap;
    private Accounts accounts;
    private static Boolean isAdmin;
    private static final String ADMIN_PASSWORD = "admin";

    public AccountManager() {
        accountsHashMap = new HashMap<String, Account>();
        accounts = new Accounts();
        for (Account account : accounts) {
            accountsHashMap.put(account.getUsername(), account);
        }
    }

    public void adminLogin(String password) {
        if (password.equals(ADMIN_PASSWORD)) {
            isAdmin = true;
        }
    }

    public void addAccount(Account account) {
        accountsHashMap.put(account.getUsername(), account);
        accounts.add(account);
    }

    public void createAccount(String username, String password) {
        if (accountsHashMap.containsKey(username)) {
            System.out.println("Username already exists. Choose another username or log in.");
        } else {
            Account account = new Account(username, password);
            addAccount(account);
        }
    }

    public void deleteAccount(String username, String password) {
        if (accountsHashMap.containsKey(username)) {
            Account account = accountsHashMap.get(username);
            if (account.checkPassword(password) | isAdmin) {
                accountsHashMap.remove(username);
                accounts.remove(account);
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        } else {
            System.out.println("Username does not exist. Please create an account.");
        }
    }

    public void login(String username, String password) {
        if (accountsHashMap.containsKey(username)) {
            Account account = accountsHashMap.get(username);
            account.login(username, password);
            System.out.println("You are logged in as " + username);
        } else {
            System.out.println("Username does not exist. Please create an account.");
        }
    }

    public void logout(String username) {
        if (accountsHashMap.containsKey(username)) {
            Account account = accountsHashMap.get(username);
            account.logout();
            System.out.println("You are logged out.");
        } else {
            System.out.println("Username does not exist. Please create an account.");
        }
    }

}
