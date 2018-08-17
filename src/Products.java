import java.util.Date;

public abstract class Products implements Comparable{
    protected String name;
    protected static int IDCounter = 0;
    protected int ID;
    protected double price, weight, stockNumber;
    protected Date validityDate;


    public static void main(String[] args) {
        //Products product = new Products();
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
        return  "Name is: "+name+System.lineSeparator()+
                "ID is: " + ID + System.lineSeparator() +
                "Price is: " + price + System.lineSeparator() +
                "Weight is: " + weight + System.lineSeparator() +
                "Stock number is: " + stockNumber + System.lineSeparator() +
                "Validity date is:" + validityDate;
    }
    public void resetToDefault(){
        name = null;
        ID = 0;
        price = 0D;
        weight = 0D;
        stockNumber = 0D;
        validityDate = null;
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Products)o).name);
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
        name = InputData.readString("Type name: ","Retry: ");
    }

    public void setPrice() {
        price = InputData.readDouble("Type price: ","Type a positive number: ",0D);
    }

    public void setWeight() {
        weight = InputData.readDouble("Type weight : ","Type a positive number: ",0D);
    }

    public void setStockNumber() {
        stockNumber = InputData.readDouble("Type stock: ","Type a positive number: ",0D);
    }

    public void setValidityDate() {
        validityDate = InputData.readDate("Type validity date(yyyy-MM-dd): ", "Type a date greater or equal than today: ",new Date());
    }

}



