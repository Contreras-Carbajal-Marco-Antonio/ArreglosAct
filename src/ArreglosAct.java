import java.util.Arrays;
import java.util.Scanner;

public class ArreglosAct {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        Scanner cin = new Scanner(System.in);

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese el numero " + (i+1) + ": ");
            numeros[i] = cin.nextInt();
        }

        int mayor=numeros[0], menor=numeros[0], pares=0,impares=0,mayorPromedio=0;
        float promedio=0;

        for (int i = 0; i < numeros.length; i++) {
            promedio += numeros[i];
            if (numeros[i] % 2 == 0){
                pares++;
            } else {
                impares++;
            }
            if (numeros[i] > mayor){
                mayor = numeros[i];
                menor =numeros[i];
            } else if (numeros[i] <= menor) {
                menor = numeros[i];
            }
        }
        promedio = promedio / numeros.length;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > promedio){
                mayorPromedio++;
            }
        }
        Arrays.sort(numeros);

        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
        System.out.println("Promedio: " + promedio);
        System.out.println("Numeros mayores al promedio: " + mayorPromedio);
        System.out.print("Arreglo ordenado: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}