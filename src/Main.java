import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражение");
        String userInput = s.nextLine();
        System.out.println(calc(userInput));
    }

    public static String calc(String userInput) throws Exception {
        int number1, number2;
        String[] numbers = new String[2];
        String sign;
        boolean isRoman;
        String result;
        userInput = userInput.replaceAll(" ","");
        numbers = userInput.toUpperCase().split("[+\\-*/]");
        sign = mathOperation(userInput);
        if (sign == null) throw new Exception("Неподдерживаемая математическая операция");
        if (numbers.length != 2) throw new Exception("Должно быть два операнда");
        if (romanNumber.isRoman(numbers[0]) && romanNumber.isRoman(numbers[1])) {
            number1 = romanNumber.toArab(numbers[0]);
            number2 = romanNumber.toArab(numbers[1]);
            isRoman = true;
        }
        else if (!romanNumber.isRoman(numbers[0]) && !romanNumber.isRoman(numbers[1])) {
            number1 = Integer.parseInt(numbers[0]);
            number2 = Integer.parseInt(numbers[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Числа введены в разных форматах или присутствует число меньше 1");
        }
        if (number1 > 10 || number2 > 10 || number1<1 || number2 <1) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calculation(number1, number2, sign);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = romanNumber.toRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;


    }
    static String mathOperation(String userInput) {
        if (userInput.contains("+")) return "+";
        else if (userInput.contains("-")) return "-";
        else if (userInput.contains("*")) return "*";
        else if (userInput.contains("/")) return "/";
        else return null;
    }

    static int calculation(int a, int b, String sign) {

        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }

}
class romanNumber {
    static String[] Romans = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean isRoman(String val) {
        for (String roman : Romans) {
            if (val.equals(roman)) {
                return true;
            }
        }
        return false;
    }

    public static int toArab(String roman) {
        for (int i = 0; i < Romans.length; i++) {
            if (roman.equals(Romans[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String toRoman(int arabian) {
        return Romans[arabian];
    }
}