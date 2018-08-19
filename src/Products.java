import java.util.Date;

public class Products implements Comparable {
    protected String name;
    protected static int IDCounter = 0;
    protected int ID;
    protected double price, weight, stockNumber;
    protected Date validityDate;


    public static void main(String[] args) {
        //Products product = new Products();
        //System.out.println(product);
        //product.setName();
        //product.setID();
        //product.setPrice();
        //product.setWeight();
        //product.setStockNumber();
        //product.setValidityDate();
        //System.out.println(product);
    }

    Products() {
    }

    Products(Products initial) {
        name = initial.name;
        ID = initial.ID;
        price = initial.price;
        weight = initial.weight;
        stockNumber = initial.stockNumber;
        validityDate = initial.validityDate;
    }

    @Override
    public String toString() {
        return "Name is: " + name + System.lineSeparator() +
                "ID is: " + ID + System.lineSeparator() +
                "Price is: " + price + System.lineSeparator() +
                "Weight is: " + weight + System.lineSeparator() +
                "Stock number is: " + stockNumber + System.lineSeparator() +
                "Validity date is:" + validityDate + System.lineSeparator();
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Products) o).name);
    }

    @Override
    public boolean equals(Object obj) {
        return name.compareTo(((Products) obj).name) == 0;
    }

    public void resetToDefault() {
        name = null;
        ID = 0;
        price = 0D;
        weight = 0D;
        stockNumber = 0D;
        validityDate = null;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public double getStockNumber() {
        return stockNumber;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setName() {
        name = InputData.readString("Type name: ", "Retry: ");
    }

    public void setPrice() {
        price = InputData.readDouble("Type price: ", "Type a price greater than 0: ", 0.01D);
    }

    public void setWeight() {
        weight = InputData.readDouble("Type weight : ", "Type a weight greater than 0: ", 0.001D);
    }

    public void setStockNumber() {
        stockNumber = InputData.readDouble("Type stock: ", "Type a stock greater than 0: ", 0.001D);
    }

    //suprascriu metoda setStockNumber()
    public void setStockNumber(double soldQuantity) {
        stockNumber -= soldQuantity;
    }

    public void setValidityDate() {
        validityDate = InputData.readDate("Type validity date(yyyy-MM-dd): ", "Type a date greater or equal than today: ", new Date());
    }

    public void setID() {
        IDCounter += 1;
        ID = IDCounter;
    }
}