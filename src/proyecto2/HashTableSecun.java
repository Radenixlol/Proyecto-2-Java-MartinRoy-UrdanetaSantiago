package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Urdaneta
 */
public class HashTableSecun {

    private HashNodeSecun[] arreglo;
    private int capacidad;
    private int tamaño;

    public HashTableSecun() {
        this.capacidad = 401;
        arreglo = new HashNodeSecun[capacidad];
        this.tamaño = 0;
    }

    public int Tamaño() {
        return tamaño;
    }

    public boolean EsVacio() {
        return tamaño == 0;
    }

    public void Agregar(NodoListaSecun Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        HashNodeSecun cabeza = arreglo[arregloIndice];
        while (cabeza != null) {
            if (cabeza.getKey().equals(arregloIndice)) {
                cabeza.getValue().setNext(Nodo);
                return;

            }
            cabeza = cabeza.getNext();
        }
        tamaño++;
        ListaSecun Lista = new ListaSecun();
        Lista.insertarFinal(Nodo);
        cabeza = arreglo[arregloIndice];
        HashNodeSecun NodoHash = new HashNodeSecun(Nodo);
        NodoHash.setNext(cabeza);
        arreglo[arregloIndice] = NodoHash;

    }

    public int getArregloIndice(NodoListaSecun Nodo) {
        String title = Nodo.getTitle();
        int ascii = 0;
        for (int i = 0; i < title.length(); i++) {
            char caracter = title.charAt(i);
            ascii = ascii + (int) caracter;
        }
        int key = ascii % capacidad;
        HashNodeSecun NodoHash = new HashNodeSecun(Nodo);
        NodoHash.setKey(key);
        return key;
    }

    public NodoListaSecun Encontrar(NodoListaSecun Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        HashNodeSecun cabeza = arreglo[arregloIndice];
        while (cabeza != null) {
            if (cabeza.getKey().equals(getArregloIndice(Nodo))) {
                if (cabeza.getValue().getTitle().equals(Nodo.getTitle())) {
//                    imprimirNodo(cabeza);
                    System.out.println(cabeza.getValue().getTitle() + cabeza.getValue().getElementos());
                    return cabeza.getValue();
                }
            }
            cabeza = cabeza.getNext();
        }
        System.out.println("No existe");
        return null;
    }
}
