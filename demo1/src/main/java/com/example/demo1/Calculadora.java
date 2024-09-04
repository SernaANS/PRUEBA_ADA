package com.example.demo1;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {


    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        try{
            System.out.println("Seleccione una operacion");
            System.out.println("1. Suma");
            System.out.println("2. resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Raiz Cuadrada");

            int opcion= scanner.nextInt();

            double numero1=0;
            double numero2=0;

            if(opcion!=5){
                System.out.println("Ingrese el primer numero:");
                numero1=leerNumeros(scanner);
                System.out.println("Ingrese el segundo numero:");
                numero2=leerNumeros(scanner);
            }else{
                System.out.println("Ingrese el numero para calcular la raiz:");
                numero1=leerNumeros(scanner);
            }

            switch (opcion){
                case 1:
                    System.out.println("Res: " + (numero1+numero2));
                    break;
                case 2:
                    System.out.println("Res: " + (numero1-numero2));
                    break;
                case 3:
                    System.out.println("Res: " + (numero1*numero2));
                    break;
                case 4:
                    if(numero2==0){
                        System.out.println("Error multiplicando por 0");
                    }else{
                        System.out.println("Res: " + (numero1/numero2));
                    }
                    break;
                case 5:
                    if(numero1<0){
                        System.out.println("Error no se puede calcular");
                    }else{
                        System.out.println("Res"+Math.sqrt(numero1));
                    }
                    break;
                default:
                    System.out.println("OPCION NO VALIDA");
                    break;
            }

        }catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida");
        }finally {
            scanner.close();
        }
    }

    private static double leerNumeros(Scanner scanner){
        while(true){
            try{
                return scanner.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("Error: Entrada no válida");
                scanner.next();
            }
        }
    }
}