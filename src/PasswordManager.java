import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PasswordManager {
    private Connection connection;
    private Map<String, CustomStack> userLoginStacks;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static Scanner scanner = new Scanner(System.in);

    public PasswordManager() {
        try {
            connection = DatabaseUtil.getConnection();
            userLoginStacks = new HashMap<>();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    // Hashes a password using SHA-256 and returns a 32-character hash
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2 * hash.length);

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Return only the first 32 characters
            return hexString.substring(0, 32);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isUsernameTaken(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next();  // Returns true if a record is found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Registers a new user
    public void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if the username already exists
        if (isUsernameTaken(username)) {
            System.out.println("Username is already taken. Please choose a different username.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String hashedPassword = hashPassword(password);

        String query = "INSERT INTO users (username, hashed_password) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            stmt.executeUpdate();
            userLoginStacks.put(username, new CustomStack());
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    String loggedinUser ;

    // Logs in a user and adds login time to the stack
    public boolean loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        loggedinUser = username;
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String hashedPassword = hashPassword(password);

        String query = "SELECT * FROM users WHERE username = ? AND hashed_password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
                logLogin(username);
                return true;
            } else {
                System.out.println("Invalid username or password.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Logs login time to the stack and database
    private void logLogin(String username) {
        String loginTime = LocalDateTime.now().format(formatter);
        CustomStack stack = userLoginStacks.computeIfAbsent(username, k -> new CustomStack());
        stack.push(loginTime);
        logLoginToDatabase(username, loginTime);
    }

    private void logLoginToDatabase(String username, String loginTime) {
        String query = "INSERT INTO login_logs (username, login_time) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, loginTime);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Updates a user's password
    public void updatePassword() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!isUserExists(username)) {
            System.out.println("Username does not exist!");
            return;
        }

        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        String oldHashedPassword = hashPassword(oldPassword);

        if (!isPasswordCorrect(username, oldHashedPassword)) {
            System.out.println("Old password is incorrect!");
            return;
        }

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        String newHashedPassword = hashPassword(newPassword);

        String query = "UPDATE users SET hashed_password = ? WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newHashedPassword);
            stmt.setString(2, username);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Password updated successfully!");
                String updateTime = LocalDateTime.now().format(formatter);
                logPasswordUpdate(username, updateTime);
            } else {
                System.out.println("Password update failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isUserExists(String username) {
        String query = "SELECT 1 FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isPasswordCorrect(String username, String hashedPassword) {
        String query = "SELECT hashed_password FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String storedHashedPassword = rs.getString("hashed_password");
                return storedHashedPassword.equals(hashedPassword);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void logPasswordUpdate(String username, String updateTime) {
        String query = "INSERT INTO login_logs (username, password_update_time) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, updateTime);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetches and displays login logs for a specific user
    public void fetchAndDisplayLoginLogs(String username) {
        String query = "SELECT login_time FROM login_logs WHERE username = ? ORDER BY login_time DESC";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
                //k is lambda function which represents key
            CustomStack stack = userLoginStacks.computeIfAbsent(username, k -> new CustomStack());

            while (rs.next()) {
                String loginTime = rs.getString("login_time");
                stack.push(loginTime);
            }

            userLoginStacks.put(username, stack); // Update user's stack
            System.out.println("Login History for " + username + ":");
            stack.display();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Deletes a user from the system
public void deleteUser() {
    System.out.print("Enter username to delete: ");
    String username = scanner.nextLine();

    // Check if the user exists
    if (!isUserExists(username)) {
        System.out.println("Username does not exist!");
        return;
    }

    // Verify password
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    String hashedPassword = hashPassword(password);

    if (!isPasswordCorrect(username, hashedPassword)) {
        System.out.println("Incorrect password!");
        return;
    }

    // Delete user from the database
    String deleteUserQuery = "DELETE FROM users WHERE username = ?";
    try (PreparedStatement deleteUserStmt = connection.prepareStatement(deleteUserQuery)) {
        deleteUserStmt.setString(1, username);
        int rowsAffected = deleteUserStmt.executeUpdate();
        
        if (rowsAffected > 0) {
            // Remove user’s login stack from memory
            userLoginStacks.remove(username);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User deletion failed.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public void manageLogs() {
        // System.out.print("Enter username to manage logs: ");
        String username = loggedinUser;

        if (!userLoginStacks.containsKey(username)) {
            System.out.println("No login logs found for this user.");
            return;
        }

        CustomStack stack = userLoginStacks.get(username);
        System.out.println("\nLogin Log Manager for " + username + ":");
        while (true) {
            System.out.println("\n1. View Login History");
            System.out.println("2. Pop Last Login");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    fetchAndDisplayLoginLogs(username); // Fetch user-specific logs
                    break;
                case 2:
                    try {
                        String lastLogin = stack.pop();
                        System.out.println("Last login was at: " + lastLogin);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
