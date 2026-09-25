import java.util.Scanner;

public class ActArreglos {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        String[] producto = {"Mouse", "Teclado", "Monitor", "Memoria", "USB", "Audífonos"};
        int[] existencias = {8, 4, 2, 10, 3, 6};

        int opc, idProducto = -1, cantidad = 0;
        String nombreProducto;

        do {
            System.out.println("Bienvenido, ingrese una opción:");
            System.out.println("1) Mostrar inventario");
            System.out.println("2) Buscar producto");
            System.out.println("3) Registrar venta");
            System.out.println("4) Agregar existencia");
            System.out.println("5) Mostrar productos con baja existencia");
            System.out.println("6) Salir");
            System.out.print("Opción: ");
            opc = cin.nextInt();
            cin.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("INVENTARIO");
                    for (int i = 0; i < producto.length; i++) {
                        System.out.println("ID: " + (i + 1) + " | Producto: " + producto[i] + " | Existencia: " + existencias[i]);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del producto: ");
                    nombreProducto = cin.nextLine();
                    idProducto = -1;
                    for (int i = 0; i < producto.length; i++) {
                        if (producto[i].equalsIgnoreCase(nombreProducto)) {
                            idProducto = i;
                            break;
                        }
                    }
                    if (idProducto != -1) {
                        System.out.println("El producto existe.");
                        System.out.println("Cantidad disponible: " + existencias[idProducto]);
                    } else {
                        System.out.println("El producto no existe.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del producto: ");
                    nombreProducto = cin.nextLine();
                    idProducto = -1;
                    for (int i = 0; i < producto.length; i++) {
                        if (producto[i].equalsIgnoreCase(nombreProducto)) {
                            idProducto = i;
                            break;
                        }
                    }
                    if (idProducto != -1) {
                        System.out.print("Cantidad a vender: ");
                        cantidad = cin.nextInt();

                        if (cantidad <= 0) {
                            System.out.println("Cantidad inválida.");
                        } else if (cantidad > existencias[idProducto]) {
                            System.out.println("No existen suficientes unidades.");
                            System.out.println("Existencia disponible: " + existencias[idProducto]);
                        } else {
                            int existenciaAnterior = existencias[idProducto];
                            existencias[idProducto] -= cantidad;

                            System.out.println("Venta realizada.");
                            System.out.println("Existencia anterior: " + existenciaAnterior);
                            System.out.println("Existencia actual: " + existencias[idProducto]);
                        }
                    } else {
                        System.out.println("El producto no existe.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del producto: ");
                    nombreProducto = cin.nextLine();
                    idProducto = -1;
                    for (int i = 0; i < producto.length; i++) {
                        if (producto[i].equalsIgnoreCase(nombreProducto)) {
                            idProducto = i;
                            break;
                        }
                    }
                    if (idProducto != -1) {
                        System.out.print("Cantidad a agregar: ");
                        cantidad = cin.nextInt();
                        if (cantidad <= 0) {
                            System.out.println("La cantidad debe ser mayor a 0.");
                        } else {
                            existencias[idProducto] += cantidad; // Suma correcta
                            System.out.println("Cantidad añadida.");
                            System.out.println("Nueva existencia de " + producto[idProducto] + ": " + existencias[idProducto]);
                        }
                    } else {
                        System.out.println("El producto no existe.");
                    }
                    break;

                case 5:
                    System.out.println("PRODUCTOS CON EXISTENCIA BAJA");
                    boolean hayBajas = false;
                    for (int i = 0; i < existencias.length; i++) {
                        if (existencias[i] <= 3) { // Condición <= 3 correcta
                            System.out.println(producto[i] + ": " + existencias[i] + " unidades");
                            hayBajas = true;
                        }
                    }
                    if (!hayBajas) {
                        System.out.println("No hay productos con existencia baja.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema, hasta pronto.");
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        } while (opc != 6);
    }
}