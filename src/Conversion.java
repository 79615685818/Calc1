import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Conversion {
    public int num1, num2;
    public int vremennoeZnachenie1 = 0;//временное переменная для выявления арабского числа из римского
    public int vremennoeZnachenie2 = 0;//--//--//--
    Map<Character, Integer> map = new HashMap<>();
    TreeMap<Integer, String> inmap = new TreeMap<>();

    {  //структура данных ключ значение/значение ключ
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);

        inmap.put(100, "C");
        inmap.put(90, "XC");
        inmap.put(50, "L");
        inmap.put(40, "XL");
        inmap.put(10, "X");
        inmap.put(9, "IX");
        inmap.put(5, "V");
        inmap.put(4, "IV");
        inmap.put(1, "I");
    }

    public Conversion(String left, String right) {
        try {
            if (Character.isDigit(left.charAt(0)) && Character.isDigit(right.charAt(0))) {//если арабские то присваиваем

                num1 = Integer.parseInt(left);
                num2 = Integer.parseInt(right);

                if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                    num1 = 0;
                    num2 = 0;
                }
                num1 = num1 / num1 * num1;
                num2 = num2 / num2 * num2;
            } else if (!Character.isDigit(left.charAt(0)) && !Character.isDigit(right.charAt(0))) {//если римские то вытаскиваем
                for (int i = left.length() - 1; i >= 0; i--) {
                    int curr = map.get(left.charAt(i));
                    if (curr < vremennoeZnachenie1) {
                        num1 -= curr;
                    } else {
                        num1 += curr;
                    }
                    vremennoeZnachenie1 = curr;
                }
                for (int i = right.length() - 1; i >= 0; i--) {
                    int curr = map.get(right.charAt(i));
                    if (curr < vremennoeZnachenie2) {
                        num2 -= curr;
                    } else {
                        num2 += curr;
                    }
                    vremennoeZnachenie2 = curr;
                }
                if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                    //throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Введено не верное значение.");
        }
    }

    public String ReverseConversion(int result) {
        String roman = " ";
        int vrmzn;
        do {
            vrmzn = inmap.floorKey(result);
            roman += inmap.get(vrmzn);
            result -= vrmzn;
        } while (result != 0);
        return roman;
    }
}



