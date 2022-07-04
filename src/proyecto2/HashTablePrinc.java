package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Urdaneta
 */
public class HashTablePrinc {

    private HashNodePrinc[] arreglo;
    private int capacidad;
    private int tamaño;

    public HashTablePrinc() {
        this.capacidad = 401;
        arreglo = new HashNodePrinc[capacidad];
        this.tamaño = 0;
    }

    public int Tamaño() {
        return tamaño;
    }

    public boolean EsVacio() {
        return tamaño == 0;
    }

    public void Agregar(NodoListaPrinc Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        HashNodePrinc cabeza = arreglo[arregloIndice];
        while (cabeza != null) {
            if (cabeza.getKey() == arregloIndice) {
                if (cabeza.getValue().equals(Nodo)) {
                    JOptionPane.showMessageDialog(null, "El artículo: " + Nodo.getTitle() + ", ya se encuentra en la base de datos.");
                    return;
                } else {
                    cabeza.getValue().setNext(Nodo);
                    return;
                }
            }
            cabeza = cabeza.getNext();
        }
        tamaño++;
        ListaPrinc Lista = new ListaPrinc();
        Lista.insertarFinal(Nodo);
        cabeza = arreglo[arregloIndice];
        HashNodePrinc NodoHash = new HashNodePrinc(Nodo);
        NodoHash.setNext(cabeza);
        arreglo[arregloIndice] = NodoHash;

    }

    public int getArregloIndice(NodoListaPrinc Nodo) {
        String title = Nodo.getTitle();
        int ascii = 0;
        for (int i = 0; i < title.length(); i++) {
            char caracter = title.charAt(i);
            ascii = ascii + (int) caracter;
        }
        int key = ascii % capacidad;
        HashNodePrinc NodoHash = new HashNodePrinc(Nodo);
        NodoHash.setKey(key);
        return key;
    }

    public NodoListaPrinc Encontrar(NodoListaPrinc Nodo) {
        int arregloIndice = getArregloIndice(Nodo);
        HashNodePrinc cabeza = arreglo[arregloIndice];
        while (cabeza != null) {
            if (cabeza.getKey() == arregloIndice) {
                if (cabeza.getValue().getTitle().equals(Nodo.getTitle())) {
//                    imprimirNodo(cabeza);
                    System.out.println(cabeza.getValue().getTitle() + cabeza.getValue().getText() + cabeza.getValue().getAuthors() + cabeza.getValue().getKey_words());
                    return cabeza.getValue();
                }
            }
            cabeza = cabeza.getNext();
        }
        System.out.println("No existe");
        return null;
    }
}
