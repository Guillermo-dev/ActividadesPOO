package Actividad4;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        int a;
        int b;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el numero entero A");
        a = in.nextInt();
        System.out.println("Ingrese el numero entero B");
        b = in.nextInt();
        
        
        Dividir dividir = new Dividir ();
        
        
        System.out.println("El resultado es: " + dividir.dividir(a, b));   
    }
}

/* Respuestas:
    B- El programa no andaria, ya que no existe la division por cero "0"
    D- La excepcion mas adecuada seria usar "ArithmeticException"

    
-- OTRA OPCION POSIBLE, ES USAR TRY-CATCH EN EL INGRESO DE NUMEROS USANDO "InputMismatchException"

        boolean continuar;
        
        do{
        try{
            continuar = false;
            System.out.println("Ingrese un valor entero a");
            a = in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Numero invalido");
            in.next ();
            a = 0;
            continuar=true;
        }
        }while (continuar);
        
        do{
        try{
            continuar = false;
            System.out.println("Ingrese un valor entero b, distinto de 0");
            b = in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Numero invalido");
            in.next ();
            b = 0;
            continuar=true;
            //System.out.println("Continuar = " + continuar);
        }
        }while (continuar);
        
        //System.out.println("Continuar = " + continuar);
        System.out.println("Valor de a = " + a);
        System.out.println("Valor de b = " + b);
        System.out.println("Resultado: " + dividir (a, b));


*/

