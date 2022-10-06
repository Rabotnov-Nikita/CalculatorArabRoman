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
        String numRoman = "";
        if (numArabian / 10 > 0 & numArabian / 10 < 4) numRoman += "X".repeat(numArabian / 10);
        if (numArabian / 10 == 4) numRoman += "XL";
        if (numArabian / 10 > 4 & numArabian / 10 < 9) numRoman +="L" + "X".repeat(numArabian / 10 - 5);
        if (numArabian / 10 == 9) numRoman += "XC";
        if (numArabian / 10 == 10) numRoman += "C";
        if (numArabian % 10 > 0 & numArabian % 10 < 4) numRoman += "I".repeat(numArabian % 10);
        if (numArabian % 10 == 4) numRoman += "IV";
        if (numArabian % 10 > 4 & numArabian % 10 < 9) numRoman +="V" + "I".repeat(numArabian % 10 - 5);
        if (numArabian % 10 == 9) numRoman += "IX";

        return numRoman;
    }

    public static String calc(String input) throws InputException {
        String [] operations = {"+", "-", "*", "/"};
        String [] arabianNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String [] romanNumbers = {null,"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String [] userArray = input.split(" ");
        int result;
        String resultString;
        if (userArray.length == 3) {
            String oper = userArray[1];
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
        Scanner sc = new Scanner(System.in);
        System.out.println(Main.calc(sc.nextLine()));
    }
}

class InputException extends Exception {
    public InputException (String description) {
        super(description);

    }
}
