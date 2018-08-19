import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class InputData {
    static Scanner sc;
    static SimpleDateFormat dateFormat;

    static {
        sc = new Scanner(System.in);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static void main(String[] args) {
        //System.out.println(readDouble("weight is: ", "Retry: ",0,10));
        //System.out.println(readInteger("weight is: ", "greater  or equal than 0, less or equal than 5 ",0,5));
        //System.out.println(readDate("Validity date is: ", "Retry: ", new Date()));
        //System.out.println(readString("Product is: ", "Retry: "));
        //System.out.println(readYesNo("Continue? Yes(Y) No(N): ", "Retry: "));
    }

    public static double readDouble(String inputMsg, String invalidInputMsg) {
        System.out.print(inputMsg);
        Double number = null;
        while (number == null) {
            try {
                number = Double.valueOf(sc.nextLine());
            } catch (NumberFormatException nexc) {
            }
            if (number == null) {
                System.out.print(invalidInputMsg);
            }
        }
        return number;
    }

    public static double readDouble(String inputMsg, String invalidInputMsg, double greaterOrEqualThan) {
        Double number = null;
        do {
            number = readDouble(inputMsg, invalidInputMsg);
            if (number < greaterOrEqualThan) {
                number = null;
                inputMsg = invalidInputMsg;
            }
        } while (number == null);
        return number;
    }

    public static double readDouble(String inputMsg, String invalidInputMsg, double greaterOrEqualThan, double lessOrEqualThan) {
        Double number = null;
        do {
            number = readDouble(inputMsg, invalidInputMsg, greaterOrEqualThan);
            if (number > lessOrEqualThan) {
                number = null;
                inputMsg = invalidInputMsg;
            }
        } while (number == null);
        return number;
    }

    public static int readInteger(String inputMSG, String invalidInputMSG, int greaterOrEqualThan, int lessOrEqualThan) {
        System.out.print(inputMSG);
        Integer number = null;
        while (number == null) {
            try {
                number = Integer.valueOf(sc.nextLine());
                if ((number < greaterOrEqualThan) || (number > lessOrEqualThan)) {
                    number = null;
                }
            } catch (NumberFormatException nexc) {
            }
            if (number == null) {
                System.out.print(invalidInputMSG);
            }
        }
        return number;
    }

    public static Date readDate(String inputMsg, String invalidInputMsg) {
        System.out.print(inputMsg);
        Date validityDate = null;
        while (validityDate == null) {
            try {
                validityDate = dateFormat.parse(sc.nextLine());
            } catch (ParseException pexc) {
            }
            if (validityDate == null) {
                System.out.print(invalidInputMsg);
            }
        }
        return validityDate;
    }

    public static Date readDate(String inputMsg, String invalidInputMsg, Date greaterOrEqual) {
        Date validityDate = null;
        do {
            validityDate = readDate(inputMsg, invalidInputMsg);
            if (dateFormat.format(validityDate).compareTo(dateFormat.format(greaterOrEqual)) < 0) {
                validityDate = null;
                inputMsg = invalidInputMsg;
            }
        } while (validityDate == null);
        return validityDate;
    }

    public static String readString(String inputMsg, String invalidInputMsg) {
        System.out.print(inputMsg);
        String string = null;
        while (string == null) {
            if ((string = sc.nextLine()).isEmpty()) {
                string = null;
            }
            if (string == null) {
                System.out.print(invalidInputMsg);
            }
        }
        return string.trim().toUpperCase();
    }

    public static YesNo readYesNo(String inputMsg, String invalidInputMsg) {
        System.out.print(inputMsg);
        YesNo option = null;
        while (option == null) {
            try {
                option = YesNo.valueOf(sc.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException exc) {
                System.out.print(invalidInputMsg);
            }
        }
        return option;
    }
}
