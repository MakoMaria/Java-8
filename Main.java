import javax.print.attribute.standard.PrintQuality;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


        String expression = sc.nextLine();
        expression = expression.replaceAll("\\s", "");//заменяем пробелы на "ничего"
        String b;
        int a = expression.indexOf('+');

        b = (a == -1) ? "" : "\\+";//если a ==-1, то b присваивается занчение "+"
        if (a == -1) {
            a = expression.indexOf('-');
            b = (a == -1) ? "" : "-";
        }
        if (a == -1) {
            a = expression.indexOf(':',1);//для случаев, когда перед дробью "-"
            b = (a == -1) ? "" : ":";
        }
        if (a == -1) {
            a = expression.indexOf('*');
            b = (a == -1) ? "" : "\\*";
        }
        String[] new_expr = expression.split(b);//здесь хранятся части до и после знака b
        String[] first_fraction = new_expr[0].split("/");//присваиваем значения дроби1
        String[] second_fraction = new_expr[1].split("/");//присваиваем значения дроби2

        Fraction frac1 = new Fraction(Integer.parseInt(first_fraction[0]), Integer.parseInt(first_fraction[1]));//переводим строчные значения в числа
        Fraction frac2 = new Fraction(Integer.parseInt(second_fraction[0]), Integer.parseInt(second_fraction[1]));
        Fraction result = switch (b) {
            case "\\+" -> Fraction.sum1(frac1, frac2);
            case "\\*" -> Fraction.mul1(frac1, frac2);
            case "-" -> Fraction.sub1(frac1, frac2);
            case ":" -> Fraction.div1(frac1, frac2);
            default -> new Fraction(1, 1);
        };
        System.out.println(result.toString());
    }
}
