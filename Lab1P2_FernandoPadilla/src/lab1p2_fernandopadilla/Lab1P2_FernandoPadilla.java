/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_fernandopadilla;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class Lab1P2_FernandoPadilla {

    static Scanner read = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        int opcion = 0;
        do {
            System.out.println("Menu \n--------- \n1.Calculadora de fechas \n2.Numeros Palindromos \n3.Salida");
            opcion = read.nextInt();
            switch (opcion) {
                case 1:
                    Date fechaA = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaI;
                    Date dateI;
                    System.out.println("Ingrese la fecha(dd/MM/yyyy):");
                    fechaI = read.next();
                    SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
                    dateI = parser.parse(fechaI);

                    String[] fecha1 = parser.format(fechaA).split("/");
                    String[] fecha2 = parser.format(dateI).split("/");
                    int dias,
                     meses,
                     años;
                    if (Integer.parseInt(fecha1[0]) > Integer.parseInt(fecha2[0])) {
                        dias = Integer.parseInt(fecha1[0]) - Integer.parseInt(fecha2[0]);
                    } else {
                        dias = Integer.parseInt(fecha2[0]) - Integer.parseInt(fecha1[0]);
                    }
                    if (Integer.parseInt(fecha1[1]) > Integer.parseInt(fecha2[1])) {
                        meses = Integer.parseInt(fecha1[1]) - Integer.parseInt(fecha2[1]);
                    } else {
                        meses = Integer.parseInt(fecha2[1]) - Integer.parseInt(fecha1[1]);
                    }
                    if (Integer.parseInt(fecha1[2]) > Integer.parseInt(fecha2[2])) {
                        años = Integer.parseInt(fecha1[2]) - Integer.parseInt(fecha2[2]);
                    } else {
                        años = Integer.parseInt(fecha2[2]) - Integer.parseInt(fecha1[2]);
                    }
                    System.out.println("Fecha 1: \n" + parser.format(fechaA) + "\nFecha 2: \n" + parser.format(dateI) + "\nLa diferencia es de " + dias + " dia(s), " + meses + " mes(es) y " + años + " año(s)");
                    break;

                case 2:
                    int digitos = 2;
                    while (digitos == 1 || digitos % 2 == 0) {
                        System.out.println("Ingrese la cantidad de digitos a introducir: ");
                        digitos = read.nextInt();
                        if (digitos % 2 == 0) {
                            System.out.println("La cantidad de digitos no puede ser par");
                        } else if (digitos == 1) {
                            System.out.println("La cantidad de digitos no puede ser uno");
                        }
                    }

                    int[] arr1 = new int[digitos];
                    int num;
                    for (int i = 0; i < arr1.length; i++) {
                        System.out.println("Ingrese el numero " + (i + 1) + ": ");
                        num = read.nextInt();
                        arr1[i] = num;
                    }
                    for (int i = 0; i < arr1.length; i++) {
                        System.out.print("[" + arr1[i] + "] ");
                    }
                    if (palindromo(0, digitos, arr1) == 0) {
                        System.out.println("\nEl numero es palindromo");
                    } else {
                        System.out.println("\nEl numero NO es palindromo");
                    }
                    break;

                case 3:
                    opcion = 3;
                    break;

                default:
                    System.out.println("Numero no valido ");
                    break;
            }
        } while (opcion != 3);
    }

    public static int palindromo(int p, int digitos, int[] array) {

        if (p == array.length - 1 && array[p] == array[(digitos - 1) - p]) {
            return 0;
        } else {
            if (array[p] == array[(array.length - 1) - p] && p <= array.length - 1) {
                return palindromo((p + 1), digitos, array);
            } else {
                return 1;
            }
        }
    }
}
