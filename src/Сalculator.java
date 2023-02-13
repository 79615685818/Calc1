public class Сalculator {

    public int result;

    public Сalculator(char sign, int num1, int num2) {
        try {
            switch (sign) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
            }
        } catch (Exception a) {
            System.out.println("Такой операции не существует.");
        }
    }
}