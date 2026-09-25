import java.util.Scanner;
import java.util.Random;

public class Ejercicio2 {
    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] mapa = new String[5][5];
        boolean[][] intrusos = new boolean[5][5];
        String vacio = "⬜";
        String robot = "🤖";
        String meta = "🏁";
        int vidas = 3;
        int fila = 0;
        int columna = 0;
        Random random = new Random();

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = vacio;
            }
        }
        mapa[4][4] = meta;
        mapa[fila][columna] = robot;

        int enemigosColocados = 0;
        while (enemigosColocados < 5) {
            int f = random.nextInt(5);
            int c = random.nextInt(5);
            boolean esInicio = (f == 0 && c == 0);
            boolean esMeta = (f == 4 && c == 4);
            if (!esInicio && !esMeta && !intrusos[f][c]) {
                intrusos[f][c] = true;
                enemigosColocados++;
            }
        }

        while (vidas > 0 && !(fila == 4 && columna == 4)) {
            mostrarLaberinto(mapa);
            System.out.println("Posición actual: [" + fila + "][" + columna + "]");
            System.out.println("Vidas restantes: " + vidas);
            System.out.println("Controles: W arriba | S abajo | A izquierda | D derecha");
            System.out.print("Movimiento: ");
            String tecla = cin.nextLine().trim().toUpperCase();

            int nuevaFila = fila;
            int nuevaColumna = columna;

            switch (tecla) {
                case "W":
                    nuevaFila--;
                    break;
                case "S":
                    nuevaFila++;
                    break;
                case "A":
                    nuevaColumna--;
                    break;
                case "D":
                    nuevaColumna++;
                    break;
                default:
                    System.out.println("Tecla no válida");
                    continue;
            }

            if (nuevaFila < 0 || nuevaFila >= 5 || nuevaColumna < 0 || nuevaColumna >= 5) {
                System.out.println("Movimiento inválido: fuera de los límites");
                continue;
            }

            if (fila == 4 && columna == 4) {
                mapa[fila][columna] = meta;
            } else {
                mapa[fila][columna] = vacio;
            }

            // ¿Hay intruso oculto?
            if (intrusos[nuevaFila][nuevaColumna]) {
                vidas--;
                System.out.println("¡Encontraste un intruso!");
                System.out.println("Vidas restantes: " + vidas);
                fila = 0;
                columna = 0;
                mapa[fila][columna] = robot;
            } else {
                fila = nuevaFila;
                columna = nuevaColumna;
                mapa[fila][columna] = robot;
            }
        }

        mostrarLaberinto(mapa);

        if (fila == 4 && columna == 4) {
            System.out.println("¡MISIÓN COMPLETADA!");
        } else {
            System.out.println("GAME OVER");
        }
    }

    static void mostrarLaberinto(String[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }
}
