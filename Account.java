public class Account {
    private String accountUsername;
    private String accountPassword;
    private Boolean loggedIn;
    private static Boolean isAdmin;
    private static final String ADMIN_PASSWORD = "admin";
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
        try {
            if (loggedIn | isAdmin) {
                return this.accountUsername;
            } else {
                throw new IllegalAccessException();
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
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

    private boolean checkPassword(String password) {
        return this.accountPassword.equals(password);
    }

    public void login(String username, String password) {
        if (checkPassword(password)) {
            loggedIn = true;
        }
    }

    public void logout() {
        loggedIn = false;
    }

    public void adminLogin(String password) {
        if (password.equals(ADMIN_PASSWORD)) {
            isAdmin = true;
        }
    }
}
