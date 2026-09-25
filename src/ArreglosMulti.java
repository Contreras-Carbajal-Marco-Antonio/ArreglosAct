public class ArreglosMulti {
    public static void main(String[] args) {
        int [][] numeros = new int[4][2];  //Primer corchete es el numero de filas, segundo corchete es el numero de columnas

        numeros[0][0] = 1;
        numeros[0][1] = 5;
        numeros[1][0] = 2;
        numeros[1][1] = 6;
        numeros[2][0] = 3;
        numeros[2][1] = 7;
        numeros[3][0] = 4;
        numeros[3][1] = 8;

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.print(numeros[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Tamaño filas: " + numeros.length);
        System.out.println("Tamaño columnas: " + numeros[0].length);
        System.out.println();

        String[][] Alumnos = {
            {"Jacobo","Alan","Abraham"},
            {"Copado","Bastian","Joss"},
            {"Jimena","Allison","Marco"}
        };

        for (int i = 0; i < Alumnos.length; i++) {
            for (int j = 0; j < Alumnos[i].length; j++) {
                System.out.print(Alumnos[i][j] + " ");
            }
            System.out.println();
        }

        
    }
}
