import java.util.Scanner;
public class Ejercicio2 {
    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] mapa = new int[5][5];
        String vacio = "⬜";
        String robot = "🤖";
        String enemigo = "👹";
        String[] vida = {"💙","💙","💙"};

        int columna,fila;

        do{
            for(int i=0; i<mapa.length; i++){
                for(int j=0; j<mapa[i].length; j++){
                    System.out.print(mapa[i][j] + " ");
                }
                System.out.println();
            }
        
            
        } while (mapa[5][5] == robot || vida[0] == "💔");
    }
}