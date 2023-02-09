import java.util.Scanner;
import java.util.HashMap;
import java.util.Base64;

import static sun.security.jgss.GSSUtil.login;

public class Admin {
    private static HashMap<String, User> users = new HashMap<>();
    private static HashMap<String, String> whitelist = new HashMap<>();
    private static HashMap<String, Store> stores = new HashMap<>();
    private static User currentUser;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Admin Management App");
        System.out.println("[1] Login");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter email: ");
                String login = sc.next();
                System.out.print("Enter password: ");
                String loginPassword = sc.next();
                currentUser = login( login, loginPassword);
                if (currentUser == null) {
                    return;
                }
                if (!currentUser.role.equals("admin")) {
                    System.out.println("Access Denied. Only Admin can access this app.");
                    return;
                }
                manageAdmin();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static User login(String login, String loginPassword) {
    }

    private static void manageAdmin() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Whitelist Email");
            System.out.println("[2] Update User");
            System.out.println("[3] Delete User");
            System.out.println("[4] Create Store");
            System.out.println("[5] Add Item");
            System.out.println("[6] Delete Item");
            System.out.println("[7] Logout");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter email to whitelist: ");
                    String email = sc.next();
                    whitelist.put(email, email);
                    System.out.println("Email has been whitelisted.");
                    break;
                case 2:
                        System.out.print("Enter user id: ");
                    int id = sc.nextInt();
                    User user = users.get(String.valueOf(id));
                    if (user == null) {
                        System.out.println("User does not exist with this id.");
                        continue;
                    }
                        System.out.print("Enter new email: ");
                    String email = sc.next();
                        System.out.print("Enter new pseudo: ");
                    String pseudo = sc.next();
                        System.out.print("Enter new password: ");
                    String password = sc.next();
                        System.out.print("Enter new role: ");
                    String role = sc.next();
                    user.email = email;
                    user.pseudo = pseudo;
                    user.password = password;
                    user.role = role;}}}}
