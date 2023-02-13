public class Check {
    public char sign;
    public int indexSign;

    public Check(String equation) {//вытаскиваем знак операции и присваиваем sign

        if (equation.indexOf('+') > 0) {
            indexSign = equation.indexOf('+');
            sign = '+';
        } else if (equation.indexOf('-') > 0) {
            indexSign = equation.indexOf('-');
            sign = '-';
        } else if (equation.indexOf('/') > 0) {
            indexSign = equation.indexOf('/');
            sign = '/';
        } else if (equation.indexOf('*') > 0) {
            indexSign = equation.indexOf('*');
            sign = '*';
        }
    }
}

class Razborka {
    public String left;
    public String right;

    public Razborka(String equation, int indexSign) {//вытаскиваем два числа слева/справа от знака и присваиваем

        left = equation.substring(0, indexSign);
        right = equation.substring(indexSign + 1, equation.length());
    }
}

