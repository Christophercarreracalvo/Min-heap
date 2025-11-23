package heap;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinHeap heap = new MinHeap();

        int opcion;

        do {
            System.out.println("\n==== MENÚ MIN-HEAP ====");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Mostrar mínimo (peek)");
            System.out.println("4. Heapify desde un arreglo");
            System.out.println("5. Mostrar heap completo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un valor: ");
                    int valor = sc.nextInt();
                    heap.insertar(valor);
                    System.out.println("Elemento insertado.");
                    break;

                case 2:
                    Integer eliminado = heap.eliminarMin();
                    if (eliminado == null)
                        System.out.println("El heap está vacío.");
                    else
                        System.out.println("Se eliminó el elemento mínimo: " + eliminado);
                    break;

                case 3:
                    Integer minimo = heap.peek();
                    if (minimo == null)
                        System.out.println("El heap está vacío.");
                    else
                        System.out.println("El mínimo es: " + minimo);
                    break;

                case 4:
                    System.out.print("¿Cuántos elementos tiene el arreglo? ");
                    int n = sc.nextInt();

                    ArrayList<Integer> arr = new ArrayList<>();
                    System.out.println("Ingrese los elementos:");

                    for (int i = 0; i < n; i++) {
                        arr.add(sc.nextInt());
                    }

                    heap.heapify(arr);
                    System.out.println("Heap creado a partir del arreglo.");
                    break;

                case 5:
                    heap.imprimirHeap();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
