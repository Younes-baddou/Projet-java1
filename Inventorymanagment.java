import java.util.ArrayList;

class Inventorymanagment {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Inventorymanagment(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

class Inventory {
    private int id;
    private String name;
    private ArrayList<Inventorymanagment> items;

    public Inventory(int id, String name) {
        this.id = id;
        this.name = name;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Inventorymanagment> getItems() {
        return items;
    }

    public void addItem(Inventorymanagment item) {
        items.add(item);
    }

    public void removeItem(Inventorymanagment item) {
        items.remove(item);
    }

    public void increaseItemStock(int itemId, int amount) {
        for (Inventorymanagment item : items) {
            if (item.getId() == itemId) {
                int newStock = item.getStock() + amount;
                if (newStock >= 0) {
                    item.setStock(newStock);
                } else {
                    System.out.println("Error: Stock cannot be negative.");
                }
            }
        }
    }

    public void decreaseItemStock(int itemId, int amount) {
        for (Inventorymanagment item : items) {
            if (item.getId() == itemId) {
                int newStock = item.getStock() - amount;
                if (newStock >= 0) {
                    item.setStock(newStock);
                } else {
                    System.out.println("Error: Stock cannot be negative.");
                }
            }
        }
    }

    public void displayInventory() {
        System.out.println("Inventory " + name + ":");
        for (Inventorymanagment item : items) {
            System.out.println("Item ID: " + item.getId() + ", Name: " + item.getName() +
                    ", Price: " + item.getPrice() + ", Stock: " + item.getStock());
        }
    }
}

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void increaseInventoryStock(Inventory inventory, int itemId);}

