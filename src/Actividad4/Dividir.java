package Actividad4;

public class Dividir {

    public int dividir(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("No existe la division por 0");
            return 0;
        }
    }
}

/*  OTRA OPCION
    public int dividir(int a, int b) {
        if (b == 0) {
            return 0; 
        } else {
            return a / b;
        }
    }

 */
    