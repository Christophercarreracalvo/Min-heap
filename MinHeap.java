package heap;

import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public MinHeap(ArrayList<Integer> arreglo) {
        heap = new ArrayList<>();
        heapify(arreglo);
    }

    public void insertar(int valor) {
        heap.add(valor);
        upHeapify(heap.size() - 1);
    }

    public Integer eliminarMin() {
        if (heap.isEmpty()) return null;

        int min = heap.get(0);

        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            downHeapify(0);
        }

        return min;
    }

    public Integer peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    public void upHeapify(int index) {
        while (index > 0) {
            int padre = (index - 1) / 2;
            if (heap.get(index) < heap.get(padre)) {
                intercambiar(index, padre);
                index = padre;
            } else {
                break;
            }
        }
    }

    public void downHeapify(int index) {
        int size = heap.size();

        while (true) {
            int izquierda = 2 * index + 1;
            int derecha = 2 * index + 2;
            int menor = index;

            if (izquierda < size && heap.get(izquierda) < heap.get(menor)) {
                menor = izquierda;
            }

            if (derecha < size && heap.get(derecha) < heap.get(menor)) {
                menor = derecha;
            }

            if (menor != index) {
                intercambiar(index, menor);
                index = menor;
            } else {
                break;
            }
        }
    }

    public void heapify(ArrayList<Integer> arreglo) {
        heap = new ArrayList<>(arreglo);

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    private void intercambiar(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void imprimirHeap() {
        if (heap.isEmpty()) {
            System.out.println("El heap está vacío.");
        } else {
            System.out.println("Contenido del Heap: " + heap);
        }
    }
}
