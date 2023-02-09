import java.util.Scanner;
import java.util.HashMap;

public class Usermanagement {
    private static HashMap<String, User> users = new HashMap<>();
    private static HashMap<String, String> whitelist = new HashMap<>();
    private static User currentUser;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the User Management App");
        System.out.println("[1] Create Account");
        System.out.println("[2] Login");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter email: ");
                String email = sc.next();
                if (!whitelist.containsKey(email)) {
                    System.out.println("Email is not whitelisted. Contact admin.");
                    return;
                }
                System.out.print("Enter pseudo: ");
                String pseudo = sc.next();
                System.out.print("Enter password: ");
                String password = sc.next();
                createUser(email, pseudo, password);
                break;
            case 2:
                System.out.print("Enter email: ");
                String login = sc.next();
                System.out.print("Enter password: ");
                String loginPassword = sc.next();
                currentUser = login(login, loginPassword);
                if (currentUser == null) {
                    return;
                }
                manageUser();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void manageUser() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Read User");
            System.out.println("[2] Update User");
            System.out.println("[3] Delete User");
            System.out.println("[4] Logout");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter user id: ");
                    int id = sc.nextInt();
                    User user = users.get(String.valueOf(id));
                    if (user == null) {
                        System.out.println("User does not exist with this id.");
                        continue;
                    }
                    System.out.println("Email: " + user.email);
                    System.out.println("Pseudo: " + user.pseudo);
                    System.out.println("Role: " + user.role);
                    break;
                case 2:
                    if (currentUser.role.equals("admin") || currentUser.id == currentUser.id) {
                        System.out.print("Enter user id: ");
                        int updateId = sc.nextInt();
                        User updateUser = users.get(String.valueOf(updateId));
                        if (updateUser == null) {
                            System.out.println("User does not");
                            continue;
                        }}}}}}

