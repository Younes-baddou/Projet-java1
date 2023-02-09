import java.util.ArrayList;
import java.util.List;
public class Storemanagement {

 int user ;
        private static List<Store> stores = new ArrayList<>();
        private static List<User> users = new ArrayList<>();

        public static void main(String[] args) {
            // Initialize an admin user
            User admin = new User("admin", "admin", Role.ADMIN);
            users.add(admin);

            // Create a store
            Store store = new Store(1, "Store 1");
            stores.add(store);

            // Add an employee to the store
            User employee = new User("employee", "password", Role.EMPLOYEE);
            addEmployeeToStore(employee, store);

            // Display the list of all people having access to the store
            displayStoreAccess(store);
        }

        public static void createStore(String name) {
            if (isAdmin()) {
                Store store = new Store(getNextStoreId(), name);
                stores.add(store);
            } else {
                System.out.println("Error: Only Admin can create a store.");
            }
        }

        public static void deleteStore(Store store) {
            if (isAdmin()) {
                stores.remove(store);
            } else {
                System.out.println("Error: Only Admin can delete a store.");
            }
        }

        public static void addEmployeeToStore(User employee, Store store) {
            if (isAdmin() || isStoreManager(store)) {
                store.addEmployee(employee);
            } else {
                System.out.println("Error: Only Admin or Store Manager can add an employee to the store.");
            }
        }

        public static void displayStoreAccess(Store store) {
            System.out.println("People having access to store '" + store.getName() + "':");
            for (User user : users) {
                if (store.hasAccess(user)) {
                    System.out.println(user.getUsername());
                }
            }
        }

        private static int getNextStoreId() {
            return stores.size() + 1;
        }

        private static boolean isAdmin() {
            User currentUser = getCurrentUser();
            return currentUser != null && currentUser.getRole() == Role.ADMIN;
        }

        private static boolean isStoreManager(Store store) {
            User currentUser = getCurrentUser();
            return currentUser != null && store.hasAccess(currentUser);
        }

        private static User getCurrentUser() {
            // Get the current user from the session or from some other means
            // In this example, it is just returning the first user for demonstration purposes
            return users.size() > 0 ? users.get(0) : null;
        }
    }

    class Store {
        private int id;
        private String name;
        private List<User> employees = new ArrayList<>();

        public Store(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {}
    }
