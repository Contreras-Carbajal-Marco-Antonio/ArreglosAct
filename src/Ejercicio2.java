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
        String[] vida = {"💙","💙","💙"};
        mapa[0][0] = robot;

        int columna=0,fila=0;

        do{
            for(int i=0; i<mapa.length; i++){
                for(int j=0; j<mapa[i].length; j++){
                    System.out.print(mapa[i][j] + " ");
                }
                System.out.println();
            }
            for(int i = 1; i<5; i++){
                int filaEnemigo = random.nextInt(5);
                int columnaEnemigo = random.nextInt(5);
                if(mapa[filaEnemigo][columnaEnemigo] == vacio){
                    mapa[filaEnemigo][columnaEnemigo] = enemigo;
                }     
            }
            
            System.out.println("Ingrese una tecla para moverte:");
            System.out.println("w: arriba");
            System.out.println("s: abajo");
            System.out.println("a: izquierda");
            System.out.println("d: derecha");
            String tecla = cin.nextLine().toLowerCase();
            switch(tecla){
                case "w":
                    if(mapa[fila-1][columna] == vacio){
                        mapa[fila][columna] = vacio;
                        mapa[fila-1][columna] = robot;
                    }
                    break;
                case "s":
                    if(mapa[fila+1][columna] == vacio){
                        mapa[fila][columna] = vacio;
                        mapa[fila+1][columna] = robot;
                    }
                    break;
                case "a":
                    if(mapa[fila][columna-1] == vacio){
                        mapa[fila][columna] = vacio;
                        mapa[fila][columna-1] = robot;
                    }
                    break;
                case "d":
                    if(mapa[fila][columna+1] == vacio){
                        mapa[fila][columna] = vacio;
                        mapa[fila][columna+1] = robot;
                    }
                    break;
                default:
                    System.out.println("Tecla no valida");
                    break;
            }
        } while (mapa[5][5] == robot || vida[0] == "💔");
    }
}