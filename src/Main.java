import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordManager pm = new PasswordManager();

        while (true) {
            menu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    pm.registerUser();
                    break;
                case 2:
                    if (pm.loginUser()) {
                        pm.manageLogs();
                    }
                    break;
                case 3:
                    pm.updatePassword();
                    break;
                case 4: 
                    System.out.print("Enter username to view login history: ");
                    String username = scanner.nextLine();
                    pm.fetchAndDisplayLoginLogs(username);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    break;
                case 5:
                pm.deleteUser();

                break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    static void menu() {
        System.out.println("----------------------------------------------------------");
        System.out.println("-------------1. Register User-----------------------------");
        System.out.println("-------------2. Login User--------------------------------");
        System.out.println("-------------3. Update Password---------------------------");
        System.out.println("-------------4. View Login History------------------------");
        System.out.println("-------------5. Delete User-------------------------------"); // New option
        System.out.println("-------------6. Exit--------------------------------------");
        System.out.println("---------------Choose an option: ---------------------------");

    }
}
