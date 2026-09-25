import java.util.Scanner;
import java.util.Random;

public class Ejercicio2 {
    static Scanner cin = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        String[][] mapa = new String[5][5];
        String vacio = "⬜";
        String robot = "🤖";
        String enemigo = "👹";
        int vida = 3;
        int fila = 0;
        int columna = 0;
        int metaFila = mapa.length - 1;
        int metaColumna = mapa[0].length - 1;

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = vacio;
            }
        }
        mapa[fila][columna] = robot;

        int enemigosColocados = 0;
        while (enemigosColocados < 4) {
            int filaEnemigo = random.nextInt(mapa.length);
            int columnaEnemigo = random.nextInt(mapa[0].length);
            boolean esInicio = filaEnemigo == 0 && columnaEnemigo == 0;
            boolean esMeta = filaEnemigo == metaFila && columnaEnemigo == metaColumna;
            if (!esInicio && !esMeta && mapa[filaEnemigo][columnaEnemigo] == vacio) {
                mapa[filaEnemigo][columnaEnemigo] = enemigo;
                enemigosColocados++;
            }
        }

        do {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Vidas: " + vida);
            System.out.println("Llega a la esquina inferior derecha.");
            System.out.println("Ingrese una tecla para moverte:");
            System.out.println("w: arriba");
            System.out.println("s: abajo");
            System.out.println("a: izquierda");
            System.out.println("d: derecha");
            String tecla = cin.nextLine().toLowerCase();

            int nuevaFila = fila;
            int nuevaColumna = columna;
            switch (tecla) {
                case "w":
                    nuevaFila--;
                    break;
                case "s":
                    nuevaFila++;
                    break;
                case "a":
                    nuevaColumna--;
                    break;
                case "d":
                    nuevaColumna++;
                    break;
                default:
                    System.out.println("Tecla no valida");
                    continue;
            }

            if (nuevaFila < 0 || nuevaFila >= mapa.length
                    || nuevaColumna < 0 || nuevaColumna >= mapa[nuevaFila].length) {
                System.out.println("Movimiento invalido");
            } else if (mapa[nuevaFila][nuevaColumna] == enemigo) {
                vida--;
                mapa[fila][columna] = vacio;
                mapa[nuevaFila][nuevaColumna] = robot;
                fila = nuevaFila;
                columna = nuevaColumna;
                System.out.println("Chocaste con un enemigo. Vidas: " + vida);
            } else if (mapa[nuevaFila][nuevaColumna] == vacio) {
                mapa[fila][columna] = vacio;
                mapa[nuevaFila][nuevaColumna] = robot;
                fila = nuevaFila;
                columna = nuevaColumna;
            }
        } while (mapa[metaFila][metaColumna] != robot && vida > 0);

        if (vida > 0) {
            System.out.println("Ganaste");
        } else {
            System.out.println("Perdiste");
        }
    }
}
