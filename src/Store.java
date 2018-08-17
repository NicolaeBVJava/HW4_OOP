import java.util.ArrayList;

public class Store {
    public static AnimalProducts addAnimalProduct;
    public static VegetalProducts addVegetalProduct;
    static { addAnimalProduct = new AnimalProducts();
             addVegetalProduct  = new VegetalProducts();
    }
    public static void main(String[] args) {
        int option = 0;
        boolean exit = false;
        ArrayList<Products> productsList = new ArrayList<Products>();
        while (!exit){
            System.out.println("-----------------------");
            System.out.println("1. Create product and add it to stock");
            System.out.println("2. Sell product");
            System.out.println("3. Display daily sales report");
            System.out.println("4. Exit");
            System.out.println("-----------------------");
            option = InputData.readInteger("Choose a option: ","Retry: ",1, 4);
            switch (option) {
                case 1: option = InputData.readInteger("Product type (1-animal; 2-vegetal): ","Retry: ",1,2);
                        switch(option){
                            case 1: addAnimalProduct.setName();
                            break;
                        }

            }

        }
    }

}
