import java.util.Date;

public class AnimalProducts extends Products {
    private double storageTemperature;

    public static void main(String[] args) {
        //AnimalProducts animalProducts = new AnimalProducts();
        //System.out.println(animalProducts);
        //animalProducts.setName();
        //animalProducts.setID();
        //animalProducts.setPrice();
        //animalProducts.setWeight();
        //animalProducts.setStockNumber();
        //animalProducts.setValidityDate();
        //animalProducts.setStorageTemperature();
        //System.out.println(animalProducts);
        //System.out.println("folosesc constructorul de clonare");
        //AnimalProducts animalproducts1 = new AnimalProducts(animalProducts);
        //System.out.println(animalproducts1);
    }

    public AnimalProducts() {
    }

    public AnimalProducts(AnimalProducts initial) {
        super(initial);
        storageTemperature = initial.storageTemperature;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Storage temperature is: " + storageTemperature + System.lineSeparator();
    }

    @Override
    public void resetToDefault() {
        super.resetToDefault();
        storageTemperature = 0;
    }

    public double getStorageTemperature() {
        return storageTemperature;
    }

    public void setStorageTemperature() {
        storageTemperature = InputData.readDouble("Type storage temperature: ", "Type a number: ");
    }
}
