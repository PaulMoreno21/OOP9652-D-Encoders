package ec.edu.espe.ferrinventory.model;
import java.util.List;

public class FrontDeskHelper {
    private Warehouse warehouse;
    private Report salesReport;
    private Report inventoryReport;
    private double totalSalesRevenue;
    private User user;

    public FrontDeskHelper(Warehouse warehouse, User user) {
        this.warehouse = warehouse;
        this.salesReport = null;
        this.inventoryReport = null;
        this.totalSalesRevenue = 0.0;
        this.user = user;
    }

    public void displayAllProducts() {
        System.out.println("All Products:");
        List<Product> products = warehouse.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product searchProductByName(String name) {
        return warehouse.searchProductByName(name);
    }

    public void updateStock(Product product, int newQuantity) {
        warehouse.updateStock(product, newQuantity);
    }

    public void addSalesRevenue(double revenue) {
        totalSalesRevenue += revenue;
    }

    public void generateSalesReport(String reportContent) {
        salesReport = new Report() {
            @Override
            public void viewReport() {
                System.out.println("Sales Report:");
                System.out.println(reportContent);
            }

            @Override
            public void sendReportToDB() {
                System.out.println("Sending Sales Report to the database...");
                // Lógica para enviar el informe de ventas a la base de datos
                System.out.println("Sales Report sent to the database.");
            }
        };
    }

    public void generateInventoryReport(String reportContent) {
        inventoryReport = new Report() {
            @Override
            public void viewReport() {
                System.out.println("Inventory Report:");
                System.out.println(reportContent);
            }

            @Override
            public void sendReportToDB() {
                System.out.println("Sending Inventory Report to the database...");
                // Lógica para enviar el informe del inventario a la base de datos
                System.out.println("Inventory Report sent to the database.");
            }
        };
    }

    public void sellProduct(String productName, int quantity) {
        Product product = searchProductByName(productName);
        if (product != null) {
            if (product.getStock() >= quantity) {
                double totalPrice = product.getPrice() * quantity;
                String transactionInfo = productName + ": Quantity - " + quantity + ", Price - $" + totalPrice;
                addSalesRevenue(totalPrice);
                System.out.println("Sale successful!");
            } else {
                System.out.println("Insufficient stock for " + productName);
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    public void viewSalesReport() {
        if (salesReport != null) {
            salesReport.viewReport();
        } else {
            System.out.println("Sales Report is not available.");
        }
    }

    public void viewInventoryReport() {
        if (inventoryReport != null) {
            inventoryReport.viewReport();
        } else {
            System.out.println("Inventory Report is not available.");
        }
    }

    public void sendSalesReportToDB() {
        if (salesReport != null) {
            salesReport.sendReportToDB();
        } else {
            System.out.println("Sales Report is not available to send to the database.");
        }
    }

    public void sendInventoryReportToDB() {
        if (inventoryReport != null) {
            inventoryReport.sendReportToDB();
        } else {
            System.out.println("Inventory Report is not available to send to the database.");
        }
    }

    public void login(String password) {
        if (Validations.validatePassword(password, user)) {
            displayAllProducts();
            viewSalesReport();
            viewInventoryReport();
        } else {
            System.out.println("Invalid login credentials.");
        }
    }
}
