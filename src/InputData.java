import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class InputData {
    static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        //readDate("Input validity date: ","Retry: ", "dd-MM-yyyy" ,new Date());
        //System.out.println(readDouble("weight is: ", "Retry: ",0));
        //System.out.println(readDate("Validity date is: ", "Retry: ", new Date()));
        //System.out.println(readString("Product is: ", "Retry: "));
        System.out.println(readYesNo("Continue? Yes(Y) No(N): ", "Retry: "));
    }

    public static double readDouble(String inputMSG, String invalidInputMSG, double greaterOrEqual) {
        System.out.print(inputMSG);
        double number = 0;
        boolean stop = false;
        while (!stop) {
            try {
                if ((number = Double.parseDouble(sc.nextLine())) >= greaterOrEqual) {
                    stop = true;
                }
            } catch (NumberFormatException exc) {
            }
            if (!stop) {
                System.out.print(invalidInputMSG);
            }
        }
        return number;
    }

    public static int readInteger(String inputMSG, String invalidInputMSG, int greaterOrEqual, int lessOrEqualThan) {
        System.out.print(inputMSG);
        int number = 0;
        boolean stop = false;
        while (!stop) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if ((number >= greaterOrEqual)&&(number <= lessOrEqualThan)) {
                    stop = true;
                }
            } catch (NumberFormatException exc) {
            }
            if (!stop) {
                System.out.print(invalidInputMSG);
            }
        }
        return number;
    }
    public static Date readDate(String inputMsg, String invalidInputMsg, Date greaterOrEqual) {
        System.out.print(inputMsg);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = null;
        Date validityDate = null;
        boolean stop = false;
        while (!stop) {
            try {
                stringDate = sc.nextLine();
                validityDate = dateFormat.parse(stringDate);
                if (dateFormat.format(validityDate).compareTo(dateFormat.format(greaterOrEqual)) >= 0) {
                    stop = true;
                }
            } catch (ParseException pexc) {
            }
            if (!stop) {
                System.out.print(invalidInputMsg);
            }
        }
        return validityDate;

    }

    public static String readString(String inputMsg, String invalidInputMsg) {
        System.out.print(inputMsg);
        String string = null;
        boolean stop = false;
        while (!stop) {

            if (!(string = sc.nextLine()).isEmpty()) {
                stop = true;
            }
            else {
                System.out.print(invalidInputMsg);
            }
        }
        return string.trim().toUpperCase();
    }
    public static YesNo readYesNo(String inputMsg, String invalidInputMsg){
        System.out.println(inputMsg);
        YesNo option = null;
        String stringOption = null;
        while (option == null){
            System.out.println("option is "+option);
            try {
                stringOption = sc.nextLine().trim().toUpperCase();
                option = YesNo.valueOf(stringOption);
            }
            catch(IllegalArgumentException exc) {
                System.out.print(invalidInputMsg);
            }
        }
        return option;
    }

}
