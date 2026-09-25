import java.util.Scanner;

public class ActArreglosMulti {
    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        String carro = "\uD83D\uDE98";
        String vacio = "⬜";
        String[][] estacionamiento = {
            {carro, vacio, vacio, carro},
            {vacio, carro, vacio, vacio},
            {carro, vacio, carro, vacio}
        };

        int opc;

        do{
            for(int i = 0; i < estacionamiento.length; i++) {
                for(int j = 0; j < estacionamiento[i].length; j++) {
                    System.out.print(estacionamiento[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();
            System.out.println("Ingrese la fila en la que desea estacionar el carro: ");
            int fila = cin.nextInt();
            System.out.println("Ingrese la columna en la que desea estacionar el carro: ");
            int columna = cin.nextInt();

            if(fila >= 0 && fila < estacionamiento.length && columna >= 0 && columna < estacionamiento[fila].length){
                if(estacionamiento[fila][columna] == vacio) {
                    System.out.println("Carro estacionado correctamente");
                    estacionamiento[fila][columna] = carro;
                } else {
                    System.out.println("La casilla ya esta ocupada");
                }
            } else {
                System.out.println("Casilla invalida");
            }
            
            System.out.println("Desea estacionar otro carro? (1: No, 2: Si)");
            opc = cin.nextInt();
        }while(opc != 1);
    }
}
