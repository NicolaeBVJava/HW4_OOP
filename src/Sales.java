import java.util.Date;

public class Sales {
    private Products product;
    private Date date;
    private double quantity;

    Sales() {
    }

    Sales(Sales original) {
        product = original.product;
        date = original.date;
        quantity = original.quantity;
    }

    public void resetToDefault() {
        product = null;
        date = null;
        quantity = 0;
    }

    public Products getProduct() {
        return product;
    }

    public Date getDate() {
        return date;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setProduct(Products initial) {
        product = initial;
    }

    public void setDate() {
        date = InputData.readDate("Type selling date(yyyy-MM-dd): ", "Type a date greater or equal than today: ", new Date());
        ;
    }

    public void setQuantity() {
        quantity = InputData.readDouble("Type quantity: ", "Type a quantity greater than 0 and less or equal than: " + product.getStockNumber() + " ", 0.001D, product.getStockNumber());
    }

    @Override
    public String toString() {
        return "Product: " + product.getName() + " Quantity: " + quantity + System.lineSeparator();
    }
}