package src;

public class Account {
    private String accountUsername;
    private String accountPassword;
    private Boolean loggedIn;
    private static Boolean isAdmin;
    private static final String ILLEGAL_ACCESS_MESSAGE = "You do not have access. Please log in.";

    private class IllegalAccessException extends Exception {
        public IllegalAccessException() {
            super(ILLEGAL_ACCESS_MESSAGE);
        }
    }

    public Account() {
        loggedIn = false;
        isAdmin = false;
    }

    public Account(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    private void setUsername(String username) {
        this.accountUsername = username;
    }

    private void setPassword(String password) {
        this.accountPassword = password;
    }

    public String getUsername() {
        return this.accountUsername;
    }

    public String getPassword() {
        try {
            if (loggedIn | isAdmin) {
                return this.accountPassword;
            } else {
                throw new IllegalAccessException();
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean checkPassword(String password) {
        return this.accountPassword.equals(password);
    }

    public void login(String username, String password) {
        if (checkPassword(password)) {
            loggedIn = true;
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }

    public void logout() {
        loggedIn = false;
    }

}
