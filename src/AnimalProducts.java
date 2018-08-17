import java.util.Date;

public class AnimalProducts extends Products {
    private double storageTemperature;

    public static void main(String[] args) {
        AnimalProducts animalProducts = new AnimalProducts();
        System.out.println(animalProducts);
        animalProducts.ID=1234;
        animalProducts.price=123;
        animalProducts.weight=1;
        animalProducts.stockNumber=0;
        animalProducts.validityDate = new Date();
        animalProducts.storageTemperature = 37;
        System.out.println(animalProducts);
        System.out.println("folosesc constructorul de clonare");
        AnimalProducts animalproducts1 = new AnimalProducts(animalProducts);
        System.out.println(animalproducts1);
    }
    public AnimalProducts(){
    }

    public AnimalProducts(AnimalProducts initial) {
        super(initial);
        storageTemperature = initial.storageTemperature;
    }

    @Override
    public String toString() {
        return super.toString()+System.lineSeparator()+
                "Storage temperature is: "+storageTemperature;
    }

    public double getStorageTemperature() {
        return storageTemperature;
    }

    public void setStorageTemperature() {
        storageTemperature = InputData.readDouble("Type storage temperature: ", "Type a number: ", Double.MIN_VALUE);
    }

    @Override
    public void resetToDefault() {
        super.resetToDefault();
        storageTemperature = 0;
    }
}
