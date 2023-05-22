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
        return this.accountPassword;
        // might have privacy issues
    }

    public boolean checkPassword(String password) {
        return this.accountPassword.equals(password);
    }

    public Boolean login(String password) {
        return loggedIn = checkPassword(password);
    }

    public void logout() {
        loggedIn = false;
    }

}
