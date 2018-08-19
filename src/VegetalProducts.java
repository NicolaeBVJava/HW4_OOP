import java.util.Date;

public class VegetalProducts extends Products {
    private String vitaminsList;

    public static void main(String[] args) {
        //VegetalProducts vegetalProducts = new VegetalProducts();
        //System.out.println(vegetalProducts);
        //vegetalProducts.name = "ala";
        //vegetalProducts.ID = 1;
        //vegetalProducts.price = 2;
        //vegetalProducts.weight = 3;
        //vegetalProducts.stockNumber = 4;
        //vegetalProducts.validityDate = new Date();
        //vegetalProducts.vitaminsList = "a,b,c,d";
        //System.out.println(vegetalProducts);
        //System.out.println("folosesc constructorul de clonare");
        //VegetalProducts vegetalProducts1 = new VegetalProducts(vegetalProducts);
        //System.out.println(vegetalProducts1);
        //vegetalProducts.setName();
        //vegetalProducts.setID();
        //vegetalProducts.setPrice();
        //vegetalProducts.setWeight();
        //vegetalProducts.setStockNumber();
        //vegetalProducts.setValidityDate();
        //vegetalProducts.setVitaminsList();
        //System.out.println(vegetalProducts);
    }

    public VegetalProducts() {

    }

    public VegetalProducts(VegetalProducts initial) {
        super(initial);
        vitaminsList = initial.vitaminsList;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Vitamins list: " + vitaminsList + System.lineSeparator();
    }

    @Override
    public void resetToDefault() {
        super.resetToDefault();
        vitaminsList = null;
    }

    public String getVitaminsList() {
        return vitaminsList;
    }

    public void setVitaminsList() {
        vitaminsList = InputData.readString("Type vitamins list: ", "Retry: ");
    }
}