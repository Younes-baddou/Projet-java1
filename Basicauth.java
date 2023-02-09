import java.security.MessageDigest;
import java.util.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Basicauth {
    private static HashMap<String, String> whitelist = new HashMap<>();
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Basic Authentication App");
        System.out.println("[1] Creez un compte");
        System.out.println("[2] Inscrivez-vous");
        System.out.print("Choisissez une option: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.print("Entrez le mail : ");
                String email = sc.next();
                System.out.print("Entrez le mot de passe : ");
                String password = sc.next();
                createUser(email, password);
                break;
            case 2:
                System.out.print("Entrez le mail: ");
                String login = sc.next();
                System.out.print("Entrez le mot de passe: ");
                String loginPassword = sc.next();
                login(login, loginPassword);
                break;
            default:
                System.out.println("Option invalide. essayez une autre fois.");
        }
    }

    private static void createUser(String email, String password) {
        if (!whitelist.containsKey(email)) {
            System.out.println("L'e-mail n'est pas sur la liste Contactez l'administrateur.");
            return;
        }

        if (users.containsKey(email)) {
            System.out.println("User already exists with this email.");
            return;
        }

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        users.put(email, encodedPassword);
        System.out.println("User created successfully.");
    }

    private static void login(String email, String password) {
        if (!users.containsKey(email)) {
            System.out.println("User does not exist with this email.");
            return;
        }

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        if (!users.get(email).equals(encodedPassword)) {
            System.out.println("Incorrect password.");
            return;
        }

        System.out.println("Login successful.");
    }
}

   /* public static class Basicauth {
        private static final String EMAIL_WHITELIST = "whitelist.txt";
        private static List<String> emailList = new ArrayList<>();

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Load email whitelist
            loadEmailWhitelist();

            // Show menu to user
            System.out.println("1. Create account");
            System.out.println("2. Login");
            System.out.print("Choose option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        private static void createAccount() {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter email: ");
            String email = input.nextLine();
            System.out.print("Enter password: ");
            String password = input.nextLine();

            // Check if email is on the whitelist
            if (!emailList.contains(email)) {
                System.out.println("Error: Email not on the whitelist.");
                return;
            }

            // Hash password
            password = hashPassword(password);

            // Store account information
            storeAccount(email, password);

            System.out.println("Account created successfully.");
        }

        private static void login() {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter email: ");
            String email = input.nextLine();
            System.out.print("Enter password: ");
            String password = input.nextLine();

            // Hash password
            password = hashPassword(password);

            // Check if account exists
            if (!checkAccount(email, password)) {
                System.out.println("Error: Invalid email or password.");
                return;
            }

            System.out.println("Login successful.");
        }

        private static void loadEmailWhitelist() {
            // Load email whitelist from file
        }

        private static String hashPassword(String password) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(password.getBytes());
                return Base64.getEncoder().encodeToString(hash);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("Error: " + e.getMessage());
                return null;
            }
        }

        private static void storeAccount(String email, String password) {
            // Store account information to database
        }

        private static boolean checkAccount(String email, String password) {
            // Check if account exists in database
            return false;
        }
    }
}*/

