import java.util.Date;

public class VegetalProducts extends Products{
    private String vitaminsList;

    public static void main(String[] args) {
        VegetalProducts vegetalProducts = new VegetalProducts();
        System.out.println(vegetalProducts);
        vegetalProducts.ID=1234;
        vegetalProducts.price=123;
        vegetalProducts.weight=1;
        vegetalProducts.stockNumber=0;
        vegetalProducts.validityDate = new Date();
        vegetalProducts.vitaminsList = "a,b,c,d";
        System.out.println(vegetalProducts);
        System.out.println("folosesc constructorul de clonare");
        VegetalProducts vegetalProducts1 = new VegetalProducts(vegetalProducts);
        System.out.println(vegetalProducts1);

    }
    public VegetalProducts(){

    }
    public VegetalProducts(VegetalProducts initial){
        super(initial);
        vitaminsList=initial.vitaminsList;
    }

    @Override
    public String toString() {
        return super.toString()+System.lineSeparator()+
                "Vitamins list: "+vitaminsList;
    }

    public String getVitaminsList() {
        return vitaminsList;
    }

    public void setVitaminsList() {
        vitaminsList = InputData.readString("Type viamins list: ", "Type something: ");
    }

    @Override
    public void resetToDefault() {
        super.resetToDefault();
        vitaminsList = null;
    }
}


