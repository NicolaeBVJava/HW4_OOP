import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Store {
    public static Products product;
    public static AnimalProducts animalProduct;
    public static VegetalProducts vegetalProduct;
    public static Sales sellProduct;
    public static ArrayList<Products> productsList;
    public static ArrayList<Sales> salesList;

    static {
        product = new Products();
        animalProduct = new AnimalProducts();
        vegetalProduct = new VegetalProducts();
        sellProduct = new Sales();
        productsList = new ArrayList<Products>();
        salesList = new ArrayList<Sales>();
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            switch (InputData.readInteger("Choose a option: ",
                    "Retry: ", 1, 4)) {
                case 1:
                    do {
                        if (InputData.readInteger("Product type: (1-animal; 2-vegetal): ",
                                "Retry: ", 1, 2) == 1) {
                            addAnimalProduct();
                        } else {
                            addVegetalProduct();
                        }
                    } while (InputData.readYesNo("Continue adding products? Yes(Y) No(N): ", "Retry") == YesNo.Y);
                    break;
                case 2:
                    do {
                        sellProduct();

                    } while (InputData.readYesNo("Continue adding orders? Yes(Y) No(N): ", "Retry") == YesNo.Y);
                    break;
                case 3:
                    do {
                        printDailySalesReport();
                    }
                    while (InputData.readYesNo("Continue printing sales? Yes(Y) No(N): ", "Retry") == YesNo.Y);
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }
    }


    public static void addAnimalProduct() {
        animalProduct.resetToDefault();
        boolean duplicateProduct = true;
        while (duplicateProduct) {
            animalProduct.setName();
            if (productsList.contains(animalProduct)) {
                System.out.println(animalProduct.getName() + " is already in list! Retry: ");
            } else {
                duplicateProduct = false;
            }
        }
        animalProduct.setPrice();
        animalProduct.setWeight();
        animalProduct.setStockNumber();
        animalProduct.setValidityDate();
        animalProduct.setStorageTemperature();
        switch (InputData.readYesNo("Add this product? Yes(Y) No(N): "
                , "Yes(Y) No(N): ")) {
            case Y:
                animalProduct.setID();
                productsList.add(new AnimalProducts(animalProduct));
                System.out.println("Product added to list. ");
                break;
            case N:
                System.out.println("No product added to list!");
                break;
        }
        animalProduct.resetToDefault();
    }

    public static void addVegetalProduct() {
        boolean duplicateProduct = true;
        while (duplicateProduct) {
            vegetalProduct.setName();
            if (productsList.contains(vegetalProduct)) {
                System.out.println(vegetalProduct.getName() + " is already in list! Retry: ");
            } else {
                duplicateProduct = false;
            }
        }
        vegetalProduct.setPrice();
        vegetalProduct.setWeight();
        vegetalProduct.setStockNumber();
        vegetalProduct.setValidityDate();
        vegetalProduct.setVitaminsList();
        switch (InputData.readYesNo("Add this product? Yes(Y) No(N): "
                , "Yes(Y) No(N): ")) {
            case Y:
                vegetalProduct.setID();
                productsList.add(new VegetalProducts(vegetalProduct));
                System.out.println("Product added to list. ");
                break;
            case N:
                System.out.println("No product added to list!");
                break;
        }
        vegetalProduct.resetToDefault();
    }

    public static void sellProduct() {
        if (!productsList.isEmpty()) {
            printProductsList();
            sellProduct.resetToDefault();
            while (sellProduct.getProduct() == null) {
                int id = InputData.readInteger("Type an ID: ", "The ID has to be between 1 and " + Products.IDCounter + " ", 1, Products.IDCounter);
                boolean found = false;
                for (int i = 0; ((i <= productsList.size()) && (found == false)); i++) {
                    if (productsList.get(i).getID() == id) {
                        found = true;
                        sellProduct.setProduct(productsList.get(i));
                    }
                }
            }
            if (sellProduct.getProduct().getStockNumber() != 0D) {
                sellProduct.setDate();
                sellProduct.setQuantity();
                switch (InputData.readYesNo("Add this order? Yes(Y) No(N): "
                        , "Yes(Y) No(N): ")) {
                    case Y:
                        salesList.add(new Sales(sellProduct));
                        sellProduct.getProduct().setStockNumber(sellProduct.getQuantity());
                        System.out.println("Order added to list. ");
                        break;
                    case N:
                        System.out.println("No order added to list!");
                        break;
                }
            } else {
                System.out.println("Product " + sellProduct.getProduct().getName() + " is out of stock!");
            }
            sellProduct.resetToDefault();
        } else {
            System.out.println("There are no products in the list!");
        }
    }

    public static void printMenu() {
        System.out.println("--------------------------------------");
        System.out.println("1. Create product and add it to stock");
        System.out.println("2. Sell product");
        System.out.println("3. Display daily sales report");
        System.out.println("4. Exit");
        System.out.println("--------------------------------------");
    }

    public static void printProductsList() {
        for (Products product : productsList) {
            System.out.println("ID: " + product.getID() + "; Name: " + product.getName() + "; Stock: " + product.getStockNumber());
        }
    }

    public static void printDailySalesReport() {
        boolean haveOrders = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date salesDate = InputData.readDate("Type date (yyyy-MM-dd): ", "Retry: ");
        for (Sales sale : salesList) {
            if (dateFormat.format(salesDate).compareTo(dateFormat.format(sale.getDate())) == 0) {
                haveOrders = true;
                System.out.println("Data: " + sale.getDate() + ", ID: " + sale.getProduct().getID() + ", Quantity: " + sale.getQuantity());
            }
        }
        if (haveOrders == false) {
            System.out.println("There are no orders in the list!");
        }
    }
}
