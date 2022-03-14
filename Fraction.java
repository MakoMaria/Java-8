
public class Fraction {
    int num;// числитель(numerator)
    int den; // знаменатель(denominator)

    public Fraction(int num, int den) throws Exception {

        if( den == 0) { // ошибка бросается в случае , если знаменатель равен 0
            throw new Exception("Ошибка деления на ноль");
        }
        else if (num == 0){
            this.num = 0;
            this.den = 1;
        }
        else {
            //перебор всех общих множителей в числителе и знаменателе
            int i = 2;
            while (i <= num && i <= den ){
                if (num % i == 0 && den % i == 0) {
                    num /=i;
                    den /=i;
                }
                i++;
            }

            this.num = num;
            this.den = den;
        }
    }

    public Fraction() {
        this.num = 1;
        this.den = 1;
    }

    //Ищем сумму
    public static Fraction sum1(Fraction f1, Fraction f2) throws Exception {
        int d = f1.den * f2.den;
        int n = (f1.num * f2.den) + (f2.num * f1.den);
        Fraction f3 = new Fraction(n, d);
        return f3;
    }

    public static Fraction sub1(Fraction f1, Fraction f2) throws Exception {
        int d = f1.den * f2.den;
        int n = (f1.num * f2.den) - (f2.num * f1.den);
        Fraction f4 = new Fraction(n, d);
        return f4;
    }

    public static Fraction mul1(Fraction f1, Fraction f2) throws Exception {
        int n = f1.num * f2.num;
        int d = f2.den * f1.den;
        Fraction f5 = new Fraction(n, d);
        return f5;
    }

    public static Fraction div1(Fraction f1, Fraction f2) throws Exception {
        int n = f1.num * f2.den;
        int d = f1.den * f2.num;
        Fraction f5 = new Fraction(n, d);
        return f5;
    }

    @Override//аннотация
    public String toString() { //после перегрузки этой функции будет выводится строка, когда это нужно, а не адрес метода
        if (this.num == 0){ // если в числителе 0, то дробь будет распечатана как 0
            return "0";
        }
        if (this.den == 1){
            return "" + num;
        }
        return  num + "/" + den;
    }
}
