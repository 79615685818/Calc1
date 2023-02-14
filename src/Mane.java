
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mane {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        Check proverka = new Check(equation);
        char sign = proverka.sign;
        int indexSign = proverka.indexSign;
        Razborka razborka = new Razborka(equation, indexSign);
        String left = razborka.left;
        String right = razborka.right;
        Conversion conversion = new Conversion(razborka.left, razborka.right);
        int num1 = conversion.num1;
        int num2 = conversion.num2;
        Сalculator calkulator = new Сalculator(sign, num1, num2);



        try {
            if (Character.isDigit(razborka.left.charAt(0)) && Character.isDigit(razborka.right.charAt(0)) && conversion.num1 > 0 && conversion.num1 < 11 && conversion.num2 > 0 && conversion.num2 < 11) {
                System.out.println(calkulator.result);
            }
            if (!Character.isDigit(razborka.left.charAt(0)) && !Character.isDigit(razborka.right.charAt(0)) && conversion.num1 > 0 && conversion.num1 < 11 && conversion.num2 > 0 && conversion.num2 < 11) {
                System.out.println(conversion.ReverseConversion(calkulator.result));
            } else if (!Character.isDigit(razborka.left.charAt(0)) && !Character.isDigit(razborka.right.charAt(0)) && calkulator.result < 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Введено не верное значение.");
        }
    }
}