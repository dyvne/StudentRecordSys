package service;

/**
 * Handles authentication for the system.
 */
public class LoginManager {

    // Default administrator credentials
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "1234";
    private final StudentManager studentManager = new StudentManager();

    /**
     * Authenticates the user.
     *
     * @param username Username entered
     * @param password Password entered
     * @return true if credentials are correct
     */
    public boolean login(String username, String password) {

        return username.equals(DEFAULT_USERNAME)
                && password.equals(DEFAULT_PASSWORD);
    }

    /**
     * Returns the default administrator username.
     * Useful for future password recovery features.
     */
    public String getAdminUsername() {
        return DEFAULT_USERNAME;
    }

    /**
     * Returns the default administrator password.
     */
    public String getAdminPassword() {
        return DEFAULT_PASSWORD;
    }
}