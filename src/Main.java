import java.util.Scanner;

public class Main {
    static int indexOfString(String userString, String[] dictArray) {
        int index = -1;
        for (int i = 0; i < dictArray.length; i++){
            if (userString.equals(dictArray[i])) {
                index = i;
                i = dictArray.length;
            }
        }
        return index;
    }

    static int calculateTwoInts (int a_num, String oper, int b_num){
        int result = 0;
        switch (oper) {
            case "+":
                result = a_num + b_num;
                break;
            case "-":
                result = a_num - b_num;
                break;
            case "*":
                result = a_num * b_num;
                break;
            case "/":
                result = a_num / b_num;
                break;
        }
        return result;
    }

    static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        return roman[numArabian];
    }

    public static String calc(String input) throws InputException {
        //Scanner sc = new Scanner(System.in);
        String userString = input;
        String [] operations = {"+", "-", "*", "/"};
        String [] arabianNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String [] romanNumbers = {null,"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String [] userArray = userString.split(" ");
        String oper = userArray[1];
        int a_num = 0;
        int b_num = 0;
        int result = 0;
        String resultString = "Неверные данные";
        if (userArray.length == 3) {
            if (Main.indexOfString(oper, operations) >= 0) {
                if (Main.indexOfString(userArray[0], arabianNumbers) >= 0 & Main.indexOfString(userArray[2], arabianNumbers) >= 0) {
                    result = Main.calculateTwoInts(Integer.parseInt(userArray[0]), oper, Integer.parseInt(userArray[2]));
                    resultString = result + "";
                    return resultString;
                } else if (Main.indexOfString(userArray[0], romanNumbers) > 0 & Main.indexOfString(userArray[2], romanNumbers) > 0) {
                    result = Main.calculateTwoInts(Main.indexOfString(userArray[0], romanNumbers), oper, Main.indexOfString(userArray[2], romanNumbers));
                    if (result > 0 & result <=100) {
                        resultString = Main.convertNumToRoman(result);
                        return resultString;
                    } else{
                        throw new InputException("В римской системе нет отрицательных чисел");
                    }
                }
                else {
                    throw new InputException("Пользователь ввел неверные данные");
                }

            } else {
                throw new InputException("Пользователь ввел неверный оператор");
            }

        } else {
            throw new InputException("Формат не соответствует заданию два операнда и один оператор");
        }
    }
    public static void main (String [] args) throws InputException{
        //Тесты удалить перед сдачей весь метод main
        /*System.out.println(Main.calc("8 + 3"));
        System.out.println(Main.calc("VI / III"));*/
        System.out.println(Main.calc("X * IX"));
        //System.out.println(Main.calc("I - 1"));
    }
}

class InputException extends Exception {
    public InputException (String description) {
        super(description);

    }
}
